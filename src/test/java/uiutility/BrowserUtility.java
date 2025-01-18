package uiutility;

import Constants.Browser;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BrowserUtility {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    protected Logger logger = LoggerUtility.getLogger(this.getClass());
    private WebDriverWait wait;

    public WebDriver getDriver() {
        logger.info("retrieves the WebDriver object stored in the ThreadLocal for the current thread by" +
                " method allows you to access the WebDriver instance associated with the current thread");
        return driver.get();
    }

    public BrowserUtility(WebDriver driver) {
        logger.info("Remote / local driver is initialized");
        this.driver.set(driver);
        //this.driver = driver; other page class driver instance to global driver
        wait=new WebDriverWait(driver, Duration.ofSeconds(30L));
    }

    public BrowserUtility(Browser browserName, boolean isHeadless) {

        if (browserName == Browser.CHROME) {
            logger.info("Local browser is "+browserName);
            if (isHeadless) {
                logger.info("Local headless " + browserName+ " browser driver is going initialized");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=old");
                options.addArguments("disable-gpu");
                options.addArguments("--disable-dev-shm-usage"); // helps with memory issues
                options.addArguments("--no-sandbox"); // helps avoid sandbox issues
                driver.set(new ChromeDriver(options));
                wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

            } else {
                logger.info("Local normal browser is going to initialized "+browserName);
                driver.set(new ChromeDriver());
                wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

            }
        } else if (browserName == Browser.EDGE) {
            logger.info("Local browser is "+browserName);
            if (isHeadless) {
                logger.info("Local headless" + browserName+ " driver is going initialized");
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless=old");
                options.addArguments("--window--size=1920,1080");
                options.addArguments("--disable-gpu");
                driver.set(new EdgeDriver(options));
                wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));

            } else {
                logger.info("Local normal browser is going to initialized"+browserName);
                driver.set(new EdgeDriver());
                wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            }
        } else if (browserName == Browser.FIREFOX) {
            logger.info("Local browser is "+browserName);
            if (isHeadless) {
                logger.info("Local headless" + browserName+ " driver is going initialized");
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                options.addArguments("--window--size=1920,1080");
                options.addArguments("--disable-gpu");
                driver.set(new FirefoxDriver(options));
                wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            } else {
                logger.info("Local normal browser is going to initialized"+browserName);
                driver.set(new FirefoxDriver());
                wait=new WebDriverWait(driver.get(), Duration.ofSeconds(30L));
            }
        } else {
            logger.error("Incorrect Browser Details");
            System.err.println("Incorrect Browser Details");
        }
    }

    public void goToWebsite(String url) {
        driver.get().get(url);
        logger.info("Browser is invoked with "+url);
    }

    public void maximizeBrowser() {

        driver.get().manage().window().maximize();
        logger.info("Browser is Maximized");

    }

    public void clickOn(By locator) {
        logger.info("Waiting for element to be clickable");
        WebElement element= wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        logger.info("Click operation is performed");

    }

    public void clickOnCheckBox(By locator) {
        logger.info("Waiting for element to be visible");
        WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.click();
        logger.info("Click operation is performed on checkBox");

    }
    public void clickOn(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        logger.info("Login operation is performed");

    }

    public void enterText(By locator, String textToEnter) {
        WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.sendKeys(textToEnter);
        logger.info("Text Entered in the text box is "+textToEnter);
    }
    public void enterSpecialKey(By locator,Keys keys) {
        WebElement element = driver.get().findElement(locator);
        element.sendKeys(keys);
        logger.info("Key Entered in the text box is " + keys);
    }
    public void clearText(By locator) {
      //  WebElement element = driver.get().findElement(locator);
        WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        logger.info("TextBox clean operation is performed");

    }

    public String getVisibleText(By Locator) {
        WebElement element = driver.get().findElement(Locator);
        logger.info("element is going to retrieve ");
        return element.getText();
    }

    public String getVisibleText(WebElement webElement) {
        logger.info("element is going to retrieve ");
        return webElement.getText();
    }

    public List<String> getAllVisibleText(By Locator) {
        List<WebElement> webElementList = driver.get().findElements(Locator);
        logger.info("element are going to retrieve from list  ");
        List<String> productList=new ArrayList<>();
        for (WebElement element:webElementList){
            productList.add(getVisibleText(element));
        }
        return productList;

    }

    public List<WebElement> getAllVisibleElements(By Locator) {
        List<WebElement> webElementList = driver.get().findElements(Locator);
        logger.info("element are going to retrieve from list  ");
       return webElementList;
    }

    public void selectFromDropDownData(By locator,String optionToSelect)  {
        logger.info("Selecting visible text from the dropdown");
        WebElement element= driver.get().findElement(locator);
        Select select=new Select(element);
        select.selectByVisibleText(optionToSelect);
        logger.info(optionToSelect+" is selected from the dropdown");


    }
    public String takeScreenShot(String name) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver.get();
        logger.info(" driver is upcasted to TakeScreenShot");
        File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
        String timeStamp = format.format(date);
        String desPath = "./screenshots/" + name + " - " + timeStamp + ".png";
        File des = new File(desPath);
        try {
            FileUtils.copyFile(src, des);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return desPath;
    }


}
