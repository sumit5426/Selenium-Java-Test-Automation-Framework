package pages;

import Constants.Browser;
import static Constants.Env.*;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uiutility.BrowserUtility;
import uiutility.JsonUtility;
import uiutility.LoggerUtility;


final public class HomePage extends BrowserUtility {
    Logger logger= LoggerUtility.getLogger(this.getClass());

    private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign\")]");

    public HomePage(Browser browserName, boolean isHeadless) {
        super(browserName,isHeadless);
        logger.info("Browser that going to launch is"+browserName);

        // goToWebsite(readProperty(QA,"URL"));
        goToWebsite(JsonUtility.readJSON(QA).getUrl());

    }

    public HomePage(WebDriver driver) {
        super(driver);
        goToWebsite(JsonUtility.readJSON(QA).getUrl());

    }

    public LoginPage goToLoginPage() {
        clickOn(SIGN_IN_LINK_LOCATOR);
        LoginPage loginPage=new LoginPage(getDriver());
        return loginPage;

    }

}
