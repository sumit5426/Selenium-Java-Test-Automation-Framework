package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uiutility.BrowserUtility;

public class ConfirmAddressPage extends BrowserUtility {
    private static final By PROCEED_TO_CHECKOUT_LOCATOR= By.name("processAddress");

    public ConfirmAddressPage(WebDriver driver) {
        super(driver);
    }

    public ShipmentPage goToShipment(){
        clickOn(PROCEED_TO_CHECKOUT_LOCATOR);
        return new ShipmentPage(getDriver());
    }


}
