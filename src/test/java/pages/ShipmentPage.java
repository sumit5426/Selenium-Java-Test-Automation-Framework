package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uiutility.BrowserUtility;

public class ShipmentPage extends BrowserUtility {

    private static final By TERM_CHECKBOX_LOCATOR=By.id("uniform-cgv");
    private static final By PROCEED_TO_PAYMENT_LOCATOR=By.name("processCarrier");


    public ShipmentPage(WebDriver driver) {
        super(driver);
    }

    public PaymentPage goToPaymentPage(){
        clickOnCheckBox(TERM_CHECKBOX_LOCATOR);
        clickOn(PROCEED_TO_PAYMENT_LOCATOR);
        return new PaymentPage(getDriver());
    }
}
