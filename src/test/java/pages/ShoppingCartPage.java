package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uiutility.BrowserUtility;
import uiutility.LoggerUtility;

public final class ShoppingCartPage extends BrowserUtility {
    Logger logger= LoggerUtility.getLogger(this.getClass());

    private static final By CHECK0UT_BUTTON_LOCATOR=By.xpath("//a[contains(@class,'standard-checkout')]");
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public ConfirmAddressPage goToCheckOutCartPage(){
        logger.info("Clicking on checkout button");
        clickOn(CHECK0UT_BUTTON_LOCATOR);
        return new ConfirmAddressPage(getDriver());
    }


}
