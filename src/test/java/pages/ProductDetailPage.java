package pages;

import Constants.Size;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uiutility.BrowserUtility;

public class ProductDetailPage extends BrowserUtility {
private static final By SIZE_DROPDOWN_LOCATOR= By.id("group_1");
private static final By ADD_CART_LOCATOR=By.name("Submit");
private static final By PROCEED_TO_CHECKOUT_LOCATOR=By.xpath("//a[contains(@class,\"button-medium\")]");


    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailPage changeSize(Size size){
        selectFromDropDownData(SIZE_DROPDOWN_LOCATOR,size.toString());
        return new ProductDetailPage(getDriver());
    }

    public ProductDetailPage addToCart(){
        clickOn(ADD_CART_LOCATOR);
        return new ProductDetailPage(getDriver());

    }

    public ShoppingCartPage checkOutCart(){
        clickOn(PROCEED_TO_CHECKOUT_LOCATOR);
        ShoppingCartPage shoppingCartPage=new ShoppingCartPage(getDriver());
        return shoppingCartPage;
    }

}
