package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uiutility.BrowserUtility;

public class ShoppingCartPage extends BrowserUtility {

    private static final By TERM_CHECKBOX_LOCATOR=By.xpath("//input[@type=\"checkbox\"]");
    private static final By CHECK0UT_BUTTON_LOCATOR=By.xpath("//a[contains(@class,'standard-checkout')]");
    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public ConfirmAddressPage checkOut(){
        clickOn(CHECK0UT_BUTTON_LOCATOR);
        return new ConfirmAddressPage(getDriver());
    }


}
