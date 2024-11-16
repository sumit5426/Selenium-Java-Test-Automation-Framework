package uitest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InvalidLoginTest extends TestBase {
    private static final String INVALID_EMAIL_ADDRESS="abc@gmail.com";
    private static final String INVALID_PASSWORD="qwerty";

    @Test(description = "verifies error message displaying or not with invalid details", groups = {"e2e", "sanity"})
    public void invalidCredentiallogin(){
        Assert.assertEquals(homePage.goToLoginPage().doLoginWithInvalidDetails(INVALID_EMAIL_ADDRESS,INVALID_PASSWORD).loginErrorMessage(),"Authentication failed.");


    }

}
