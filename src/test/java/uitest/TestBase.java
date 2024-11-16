package uitest;

import Constants.Browser;
import Constants.Env;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pages.HomePage;
import uiutility.BrowserUtility;
import uiutility.LambdaTestUtlity;
import uiutility.LoggerUtility;

import java.net.MalformedURLException;

import static Constants.Browser.*;

public class TestBase {
    protected HomePage homePage;

    Logger logger = LoggerUtility.getLogger(this.getClass());
    private boolean isLambdaTest;

    @Parameters({"browser", "isLambdaTest", "isHeadless", "environmentName"})
    @BeforeMethod(description = "Load the homepage of the website")
    public void setUp(@Optional("chrome") String browser,
                      @Optional("true") boolean isLambdaTest,
                      @Optional("false") boolean isHeadless,
                      @Optional("QA") String environmentName,
                      ITestResult result) throws MalformedURLException {
        logger.info("isLambdaTest value: " + isLambdaTest);
        logger.info("is headless value: " + isHeadless);
        Env env = Env.valueOf(environmentName.toUpperCase());
        //  convert a String value into an instance of the Env enum
        this.isLambdaTest = isLambdaTest;
        WebDriver lambadaDriver;


        if (isLambdaTest) {
            logger.info("lambda test is going into initialize");
            lambadaDriver = LambdaTestUtlity.intializeLambdaTestSession(result.getMethod().getMethodName(), browser);
            homePage = new HomePage(lambadaDriver,env);
        } else {
            logger.info("Load the homepage of the website local " + browser + " browser");
            homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless, env);
        }
    }

    public BrowserUtility getInstance() {
        logger.info("home page instance is getting for screenshot method");
        return homePage; // parent of homepage is returning
    }

    @AfterMethod(description = "Tear down the browser")
    public void tearDown() {
        if (isLambdaTest) {
            logger.info("Remote browser session is quited");
            LambdaTestUtlity.quitSession();
        }
        logger.info("Local browser session is quited");
        homePage.getDriver().quit();
    }
}
