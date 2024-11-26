package pages;

import Constants.Size;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uiutility.BrowserUtility;
import uiutility.LoggerUtility;

public final class ProductDetailPage extends BrowserUtility {

    Logger logger= LoggerUtility.getLogger(this.getClass());

    private static final By SIZE_DROPDOWN_LOCATOR = By.id("group_1");
    private static final By ADD_CART_LOCATOR = By.name("Submit");
    private static final By PROCEED_TO_CHECKOUT_LOCATOR = By.xpath("//a[contains(@class,\"button-medium\")]");


    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailPage changeSize(Size size) {
        logger.info("Selecting the dress size " +size+ " from dropdown ");
        selectFromDropDownData(SIZE_DROPDOWN_LOCATOR, size.toString());
        return new ProductDetailPage(getDriver());
    }

    public ProductDetailPage addToCart() {
        logger.info("Clicking on add to cart button");
        clickOn(ADD_CART_LOCATOR);
        return new ProductDetailPage(getDriver());

    }

    public ShoppingCartPage checkOutCart() {
        logger.info("Clicking on proceed to checkout button");
        clickOn(PROCEED_TO_CHECKOUT_LOCATOR);
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage(getDriver());
        return shoppingCartPage;
    }

}
