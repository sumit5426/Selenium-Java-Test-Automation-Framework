package pages;

import org.openqa.selenium.WebDriver;
import uiutility.BrowserUtility;
import org.openqa.selenium.By;


public final class LoginPage extends BrowserUtility {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
    private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
    private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//button[@id='SubmitLogin']/span");
     public MyAccountPage doLoginWith(String emailAddress, String password){
         enterText(EMAIL_TEXT_BOX_LOCATOR,emailAddress);
         enterText(PASSWORD_TEXT_BOX_LOCATOR,password);
         clickOn(SUBMIT_BUTTON_LOCATOR);
         MyAccountPage myAccountPage=new MyAccountPage(getDriver());
         return myAccountPage;
     }


}
