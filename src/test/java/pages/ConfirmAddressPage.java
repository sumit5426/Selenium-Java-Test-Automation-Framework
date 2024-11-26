package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uiutility.BrowserUtility;
import uiutility.LoggerUtility;

 public final class ConfirmAddressPage extends BrowserUtility {
    Logger logger= LoggerUtility.getLogger(this.getClass());

    private static final By PROCEED_TO_CHECKOUT_LOCATOR= By.name("processAddress");

    public ConfirmAddressPage(WebDriver driver) {
        super(driver);
    }

    public ShipmentPage goToShipmentPage(){
        logger.info("Clicking on proceed to checkout button");
        clickOn(PROCEED_TO_CHECKOUT_LOCATOR);
        return new ShipmentPage(getDriver());
    }


}
