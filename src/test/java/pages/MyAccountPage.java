package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import uiutility.BrowserUtility;
import uiutility.LoggerUtility;

public final class MyAccountPage extends BrowserUtility {
    public MyAccountPage(WebDriver driver){

        super(driver);
    }
    Logger logger= LoggerUtility.getLogger(this.getClass());
    private static final By USER_NAME_LOCATOR= By.xpath("//a[@title=\"View my customer account\"]/span");
    private static final  By SEARCH_TEXT_BOX_LOCATOR=By.id("search_query_top");
    private static final By ADD_NEW_ADDRESS_LOCATOR=By.xpath("//a[@title=\"Add my first address\"]");


    public String getUserName(){
        logger.info("Retrieving username from the my account page");
        return getVisibleText(USER_NAME_LOCATOR);

    } public SearchResultPage searchForProduct(String itemName){
        logger.info("searching the product with "+ itemName);
        enterText(SEARCH_TEXT_BOX_LOCATOR,itemName);
        enterSpecialKey(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);
        logger.info(itemName +" in entered and clicked ");
        SearchResultPage searchResultPage=new SearchResultPage(getDriver());
        return searchResultPage;

    }
    public NewAddressAddPage goToNewAddressCreatePage(){
        logger.info("Clicking on new address add button");
        clickOn(ADD_NEW_ADDRESS_LOCATOR);
        NewAddressAddPage newAddressAddPage=new NewAddressAddPage(getDriver());
        return newAddressAddPage;
    }


}
