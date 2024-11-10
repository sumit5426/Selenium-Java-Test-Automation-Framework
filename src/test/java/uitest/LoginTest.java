//package uitest;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//public class LoginTest {
//    public static void main(String[] args) {
//        WebDriver wb=new ChromeDriver();
//        wb.get("http://www.automationpractice.pl/index.php");
//        wb.manage().window().maximize(); //method channing
//        By signonElement= By.xpath("//a[contains(text(),\"Sign\")]");
//        wb.findElement(signonElement).click();
//        By email=By.id("email");
//        wb.findElement(email).sendKeys("yeheve5164@inikale.com");
//        By password=By.id("passwd");
//        wb.findElement(password).sendKeys("qwerty");
//        By signbutton=By.xpath("//button[@id='SubmitLogin']/span");
//        wb.findElement(signbutton).click();
//
//    }
//}
