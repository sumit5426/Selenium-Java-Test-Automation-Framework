package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import uiutility.BrowserUtility;

import java.util.Arrays;
import java.util.List;

public class SearchResultPage extends BrowserUtility {
    public SearchResultPage(WebDriver driver) {
        super(driver);
    }
    private static final By PRODUCT_LISTING_TITLE_LOCATOR= By.xpath("//span[contains(@class,\"lighter\")]");
    private static final By ALL_PRODUCT_NAME_LOCATOR=By.xpath("//div[@class=\"right-block\"]/h5/a[@class=\"product-name\"]");



    public String getSearchTitle(){
      return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
    }

    public boolean isSearchTermPresentInProductList(String searchTerm){
       List<String> productKeyword= Arrays.asList(searchTerm.toLowerCase().split(" "));
       List<String> productNameList= getAllVisibleText(ALL_PRODUCT_NAME_LOCATOR);
       boolean result=productNameList.stream().anyMatch(name->(productKeyword.stream().
               anyMatch(name.toLowerCase()::contains)));
       return result;
    }

    public ProductDetailPage clickOnProductAt(int index){
        clickOn(getAllVisibleElements(ALL_PRODUCT_NAME_LOCATOR).get(index));
        ProductDetailPage productDetailPage=new ProductDetailPage(getDriver());
        return productDetailPage;
    }
}
