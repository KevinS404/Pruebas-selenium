import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import java.util.concurrent.TimeUnit;

//re ordenar un pedido
public class test3 {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "E:\\Desktop\\ramos\\MINGESO\\chromedriver.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        driver.quit();
    }
    @Test
    public void test3() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("mingeso@gmail.com");
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).sendKeys("mingeso");
        driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
        driver.findElement(By.cssSelector(".col-xs-12:nth-child(1) > .myaccount-link-list > li:nth-child(1) span")).click();
        driver.findElement(By.cssSelector(".item:nth-child(2) > .history_detail > .link-button")).click();
        driver.findElement(By.cssSelector(".standard-checkout > span")).click();
        driver.findElement(By.cssSelector(".button:nth-child(4) > span")).click();
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.cssSelector(".standard-checkout > span")).click();
        driver.findElement(By.linkText("Pay by bank wire (order processing will be longer)")).click();
        driver.findElement(By.cssSelector("#cart_navigation span")).click();
    }
}
