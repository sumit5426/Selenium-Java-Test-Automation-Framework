package uitest;

import Constants.Browser;
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

    @Parameters({"browser", "isLambdaTest", "isHeadless"})
    @BeforeMethod(description = "Load the homepage of the website")
    public void setUp(@Optional("chrome") String browser,
                      @Optional("false") boolean isLambdaTest,
                      @Optional("true") boolean isHeadless, ITestResult result) throws MalformedURLException {
        this.isLambdaTest = isLambdaTest;
        WebDriver lambadaDriver;
        if (isLambdaTest) {
            lambadaDriver = LambdaTestUtlity.intializeLambdaTestSession(result.getMethod().getMethodName(), browser);
            homePage = new HomePage(lambadaDriver);
        } else {
            logger.info("Load the homepage of the website");
            homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
        }
    }

    public BrowserUtility getInstance() {
        return homePage; // parent of homepage is returning
    }

    @AfterMethod(description = "Tear down the browser")
    public void tearDown() {
        if (isLambdaTest) {
            LambdaTestUtlity.quitSession();
        }
        homePage.getDriver().quit();
    }
}
