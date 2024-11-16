package uiutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LambdaTestUtlity {
    public static final String hubURL = "https://hub.lambdatest.com/wd/hub";
    private static ThreadLocal<WebDriver> driverLocal=new ThreadLocal<>();
    private static ThreadLocal<DesiredCapabilities> capabilitiesLocal=new ThreadLocal<>();
    public static WebDriver intializeLambdaTestSession(String testName, String browser) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", "127");
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("user","sumit.leadwinner");
        ltOptions.put("accessKey","vFzYrOfRJgEeveavDDAOWHdV0MZCIS6eZEHnYgsiIXfa3WOxnD");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", testName);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.25.0");
        capabilities.setCapability("LT:Options", ltOptions);
        capabilitiesLocal.set(capabilities);
        WebDriver driver= new RemoteWebDriver(new URL(hubURL), capabilitiesLocal.get());
        driverLocal.set(driver);
        System.out.println(driver);
        return driverLocal.get();
    }
    public static void quitSession(){
        if(driverLocal.get()!=null){
            driverLocal.get().quit();
        }
    }
}
