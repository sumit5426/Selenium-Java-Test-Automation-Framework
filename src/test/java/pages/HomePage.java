package pages;

import Constants.Browser;

import static Constants.Env.*;

import Constants.Env;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uiutility.BrowserUtility;
import uiutility.JsonUtility;
import uiutility.LoggerUtility;
import uiutility.PropertiesUtil;


final public class HomePage extends BrowserUtility {
    Logger logger = LoggerUtility.getLogger(this.getClass());

    public HomePage(Browser browserName, boolean isHeadless, Env env) {
        super(browserName, isHeadless);
        logger.info("Local Browser that going to launch is " + browserName);
        logger.info("Fetching the url from the environment properties file ");
        goToWebsite(PropertiesUtil.readProperty(env, "URL"));
//        goToWebsite(JsonUtility.readJSON(env).getUrl());
        maximizeBrowser();
    }

    public HomePage(WebDriver driver,Env env) {
        super(driver);
        logger.info("Remote Browser that going to launch is Lambda");
        logger.info("Reading the url from the environment json or properties file ");
        goToWebsite(JsonUtility.readJSON(env).getUrl());
        maximizeBrowser();

    }
    private static final By SIGN_IN_LINK_LOCATOR = By.xpath("//a[contains(text(),\"Sign\")]");

    public LoginPage goToLoginPage() {
        clickOn(SIGN_IN_LINK_LOCATOR);
        logger.info("Going to create login page object inside homepage");
        LoginPage loginPage = new LoginPage(getDriver());
        return loginPage;

    }

}
