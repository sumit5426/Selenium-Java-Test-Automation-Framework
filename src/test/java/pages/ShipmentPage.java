package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uiutility.BrowserUtility;
import uiutility.LoggerUtility;

public final class ShipmentPage extends BrowserUtility {
    Logger logger= LoggerUtility.getLogger(this.getClass());

    private static final By TERM_CHECKBOX_LOCATOR=By.id("uniform-cgv");
    private static final By PROCEED_TO_PAYMENT_LOCATOR=By.name("processCarrier");


    public ShipmentPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage goToPaymentPage(){
        logger.info("Clicking on term and condition checkbox and proceed to checkbox button");
        clickOnCheckBox(TERM_CHECKBOX_LOCATOR);
        clickOn(PROCEED_TO_PAYMENT_LOCATOR);
        return new PaymentPage(getDriver());
    }
}
