package uitest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import uipojo.User;

public class SearchProductTest extends TestBase{
    private static final String VALID_EMAIL_ADDRESS="yeheve5164@inikale.com";
    private static final String VALID_PASSWORD="qwerty";
    private static final String SEARCH_TERM="Printed Summer Dress";
    private MyAccountPage myAccountPage;

    @BeforeMethod
    public void setupMethod(){
        myAccountPage=homePage.goToLoginPage().doLoginWith(VALID_EMAIL_ADDRESS,VALID_PASSWORD);
    }

    @Test(description = "verifies product search functionality", groups = {"e2e", "sanity"})
    public void searchProductFunctionality(){
       boolean actualResult= myAccountPage.searchForProduct(SEARCH_TERM).isSearchTermPresentInProductList(SEARCH_TERM);
        Assert.assertTrue(actualResult);



    }
}
