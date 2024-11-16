package uitest;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import uipojo.User;

import static org.testng.Assert.assertEquals;
@Listeners({uilisteners.TestListener.class})
public class LoginTest extends TestBase{


    @Test(description = "verifies with valid user able to login or not using JSON", groups = {"e2e", "sanity"}
            ,dataProviderClass = uidataprovider.LoginDataProvider.class,dataProvider="LoginTestDataProvider")
    public void loginWithJSONTest(User user) {
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Shashak das");
    }

    @Test(description = "verifies with valid user able to login or not using CSV", groups = {"e2e", "sanity"},
            dataProviderClass = uidataprovider.LoginDataProvider.class,dataProvider="LoginTestCSVDataProvider")
    public void loginWithCSVTest(User user) {
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Shashak das");
    }

    @Test(description = "verifies with valid user able to login or not using excel", groups = {"e2e", "sanity"},
            dataProviderClass = uidataprovider.LoginDataProvider.class,dataProvider="loginExcelDataProvider",retryAnalyzer =uilisteners.MyRetryAnalyzer.class)
    public void loginWithExcelTest(User user) {
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Shashak das");
    }
}
