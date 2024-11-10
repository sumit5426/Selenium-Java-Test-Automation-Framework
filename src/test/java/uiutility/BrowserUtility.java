package uiutility;

import Constants.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverLogLevel;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class BrowserUtility {
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    public BrowserUtility(WebDriver driver) {
        this.driver.set(driver);
    }

    //    public  BrowserUtility(String browserName){
//        if(browserName.equalsIgnoreCase("chrome")){
//            driver=new ChromeDriver();
//        } else if (browserName.equalsIgnoreCase("edge")) {
//            driver=new EdgeDriver();
//        }
//        else {
//            System.err.println("Incorrect Browser Details");
//        }
//    }
    public BrowserUtility(Browser browserName, boolean isHeadless) {
        if (browserName == Browser.CHROME) {
            if (isHeadless) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless=old");
                options.addArguments("disable-gpu");
                driver.set(new ChromeDriver(options));
            } else {
                driver.set(new ChromeDriver());
            }
        } else if (browserName == Browser.EDGE) {
            if (isHeadless) {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless=old");
                options.addArguments("--window--size=1920,1080");
                options.addArguments("--disable-gpu");
                driver.set(new EdgeDriver(options));
            } else {
                driver.set(new EdgeDriver());
            }
        } else if (browserName == Browser.FIREFOX) {
            if (isHeadless) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                options.addArguments("--window--size=1920,1080");
                options.addArguments("--disable-gpu");
                driver.set(new FirefoxDriver(options));
            } else {
                driver.set(new FirefoxDriver());
            }
        } else {
            System.err.println("Incorrect Browser Details");
        }
    }

    public void goToWebsite(String url) {
        driver.get().get(url);
    }

    public void maximizeBrowser() {
        driver.get().manage().window().maximize();
    }

    public void clickOn(By locator) {
        WebElement signInLinkWebElement = driver.get().findElement(locator);
        signInLinkWebElement.click();
    }

    public void enterText(By locator, String textToEnter) {
        WebElement element = driver.get().findElement(locator);
        element.sendKeys(textToEnter);
    }

    public String getVisibleText(By Locator) {
        WebElement element = driver.get().findElement(Locator);
        return element.getText();

    }

    public String takeSceenShot(String name) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver.get();
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
