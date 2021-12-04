import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import java.util.concurrent.TimeUnit;

//Contacto exitoso
public class test1 {
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
    public void test1() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.linkText("Contact us")).click();
        driver.findElement(By.id("id_contact")).click();
        {
            WebElement dropdown = driver.findElement(By.id("id_contact"));
            dropdown.findElement(By.xpath("//option[. = 'Customer service']")).click();
        }
        driver.findElement(By.cssSelector(".form-group:nth-child(5)")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("mingeso@gmail.com");
        driver.findElement(By.id("id_order")).click();
        driver.findElement(By.id("id_order")).sendKeys("141414");
        driver.findElement(By.id("message")).click();
        driver.findElement(By.id("message")).sendKeys("Problema");
        driver.findElement(By.cssSelector("#submitMessage > span")).click();
    }
}
