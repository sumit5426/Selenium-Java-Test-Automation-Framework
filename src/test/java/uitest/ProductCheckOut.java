package uitest;

import static Constants.Size.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SearchResultPage;

public class ProductCheckOut extends TestBase{

    private static final String VALID_EMAIL_ADDRESS="yeheve5164@inikale.com";
    private static final String VALID_PASSWORD="qwerty";
    private static final String SEARCH_TERM="Printed Summer Dress";
    SearchResultPage searchResultPage;
    @BeforeMethod
    public void setup(){
     searchResultPage=  homePage.goToLoginPage().doLoginWith(VALID_EMAIL_ADDRESS,VALID_PASSWORD).searchForProduct(SEARCH_TERM);
    }

    @Test(description = "verify user able to buy a dress or not")
    public void checkoutTest(){
        searchResultPage.clickOnProductAt(0).changeSize(M).addToCart().checkOutCart().checkOut();

    }
}
