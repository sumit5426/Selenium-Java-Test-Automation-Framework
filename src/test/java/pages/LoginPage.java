package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import uiutility.BrowserUtility;
import org.openqa.selenium.By;
import uiutility.LoggerUtility;


public final class LoginPage extends BrowserUtility {
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    Logger logger=LoggerUtility.getLogger(this.getClass());


    private static final By EMAIL_TEXT_BOX_LOCATOR = By.id("email");
    private static final By PASSWORD_TEXT_BOX_LOCATOR = By.id("passwd");
    private static final By SUBMIT_BUTTON_LOCATOR = By.xpath("//button[@id='SubmitLogin']/span");
    private static final By INVALID_ERROR_MESSAGE_LOCATOR=By.xpath("//div[contains(@class,\"alert-danger\")]/ol/li");
     public MyAccountPage doLoginWith(String emailAddress, String password){
         logger.info("Entering email id, password and clicking on submit button");
         enterText(EMAIL_TEXT_BOX_LOCATOR,emailAddress);
         enterText(PASSWORD_TEXT_BOX_LOCATOR,password);
         clickOn(SUBMIT_BUTTON_LOCATOR);
         logger.info("Going to create my account page object inside login page");
         MyAccountPage myAccountPage=new MyAccountPage(getDriver());
         return myAccountPage;
     }

     public LoginPage doLoginWithInvalidDetails(String emailAddress, String password){
         logger.info("Entering inValid email id, password and clicking on submit button");
         enterText(EMAIL_TEXT_BOX_LOCATOR,emailAddress);
         enterText(PASSWORD_TEXT_BOX_LOCATOR,password);
         clickOn(SUBMIT_BUTTON_LOCATOR);
         LoginPage loginPage=new LoginPage(getDriver());
         return loginPage;
     }

     public String loginErrorMessage(){
         logger.info("Retrieving Error message while login with incorrect details");
         return getVisibleText(INVALID_ERROR_MESSAGE_LOCATOR);
     }


}
