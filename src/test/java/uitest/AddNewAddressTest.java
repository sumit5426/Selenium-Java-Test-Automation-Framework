package uitest;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.MyAccountPage;
import uipojo.AddressPojo;
import uiutility.FakerAddressUtility;

public class AddNewAddressTest extends TestBase{
    private MyAccountPage myAccountPage;
    private AddressPojo addressPojo;
    private static final String VALID_EMAIL_ADDRESS="yeheve5164@inikale.com";
    private static final String VALID_PASSWORD="qwerty";
    @BeforeMethod
    public void setup(){
      myAccountPage=  homePage.goToLoginPage().doLoginWith(VALID_EMAIL_ADDRESS,VALID_PASSWORD);
      addressPojo=FakerAddressUtility.getFakeAddress();
    }

    @Test(description = "Adding product shipping address")
    public void addNewAddress(){
        String addressTag=myAccountPage.goToNewAddressCreatePage().saveAddress(addressPojo);
        Assert.assertEquals(addressTag,addressPojo.getAddressAlias().toUpperCase());

    }

}
