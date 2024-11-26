package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uiutility.BrowserUtility;
import uiutility.LoggerUtility;

import java.util.Arrays;
import java.util.List;

public final class SearchResultPage extends BrowserUtility {
    Logger logger= LoggerUtility.getLogger(this.getClass());

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
    private static final By PRODUCT_LISTING_TITLE_LOCATOR= By.xpath("//span[contains(@class,\"lighter\")]");
    private static final By ALL_PRODUCT_NAME_LOCATOR=By.xpath("//div[@class=\"right-block\"]/h5/a[@class=\"product-name\"]");



    public String getSearchTitle(){
      return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
    }

    public boolean isSearchTermPresentInProductList(String searchTerm){
        logger.info("Checking correct product are displaying or not");
        List<String> productKeyword= Arrays.asList(searchTerm.toLowerCase().split(" "));
       List<String> productNameList= getAllVisibleText(ALL_PRODUCT_NAME_LOCATOR);
       boolean result=productNameList.stream().anyMatch(name->(productKeyword.stream().
               anyMatch(name.toLowerCase()::contains)));
       return result;
    }

    public ProductDetailPage clickOnProductAt(int index){
        logger.info("Clicking on selected product to view product details");
        clickOn(getAllVisibleElements(ALL_PRODUCT_NAME_LOCATOR).get(index));
        ProductDetailPage productDetailPage=new ProductDetailPage(getDriver());
        return productDetailPage;
    }
}
