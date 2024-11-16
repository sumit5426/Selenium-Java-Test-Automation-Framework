package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import uipojo.AddressPojo;
import uiutility.BrowserUtility;

public class NewAddressAddPage extends BrowserUtility {
    private static final By COMPANY_TEXT_BOX_LOCATOR= By.id("company");
    private static final By ADDRESS_TEXT_BOX_LOCATOR= By.id("address1");
    private static final By ADDRESS_TEXT_BOX2_LOCATOR= By.id("address2");
    private static final By CITY_TEXT_BOX_LOCATOR= By.id("city");
    private static final By POSTAL_TEXT_BOX_LOCATOR= By.id("postcode");
    private static final By HOME_PHONE_TEXT_BOX_LOCATOR= By.id("phone");
    private static final By MOBILE_PHONE_TEXT_BOX_LOCATOR= By.id("phone_mobile");
    private static final By ADDITIONAL_INFORMATION_TEXT_BOX_LOCATOR= By.id("other");
    private static final By ADDRESS_TAG_TEXT_BOX_LOCATOR= By.id("alias");
    private static final By ADDRESS_TAG_LOCATOR=By.tagName("h3");

    private static final By STATE_DROPDOWN_LOCATOR= By.id("id_state");
    private static final By ADDRESS_SAVE_BUTTON_LOCATOR=By.id("submitAddress");



    public NewAddressAddPage(WebDriver driver) {
        super(driver);
    }


    public String saveAddress(AddressPojo address){
        enterText(COMPANY_TEXT_BOX_LOCATOR,address.getCompany());
        enterText(ADDRESS_TEXT_BOX_LOCATOR, address.getAddressLine1());
        enterText(ADDRESS_TEXT_BOX2_LOCATOR,address.getAddressLine2());
        enterText(CITY_TEXT_BOX_LOCATOR, address.getCity());
        enterText(POSTAL_TEXT_BOX_LOCATOR, address.getPostCode());
        enterText(HOME_PHONE_TEXT_BOX_LOCATOR, address.getHomePhoneNumber());
        enterText(MOBILE_PHONE_TEXT_BOX_LOCATOR, address.getMobileNumber());
        enterText(ADDITIONAL_INFORMATION_TEXT_BOX_LOCATOR, address.getOtherInformation());
        clearText(ADDRESS_TAG_TEXT_BOX_LOCATOR);
        enterText(ADDRESS_TAG_TEXT_BOX_LOCATOR,address.getAddressAlias());
        selectFromDropDownData(STATE_DROPDOWN_LOCATOR,"Florida");
        clickOn(ADDRESS_SAVE_BUTTON_LOCATOR);
       return getVisibleText(ADDRESS_TAG_LOCATOR);
    }
}
