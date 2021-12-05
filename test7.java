import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class test7 {
    private WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\sebastian\\Desktop\\Pruebas\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().fullscreen();

    }
    @After
    public void tearDown() throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
        driver.quit();

    }
    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.linkText("Sign in")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("email_create")).sendKeys("mingeso3@gmail.com");
        driver.findElement(By.id("SubmitCreate")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("customer_firstname")).sendKeys("a");
        driver.findElement(By.id("customer_lastname")).sendKeys("a");
        driver.findElement(By.id("passwd")).sendKeys("mingeso");
        driver.findElement(By.id("days")).click();
        {
            WebElement dropdown = driver.findElement(By.id("days"));
            dropdown.findElement(By.cssSelector("option[value = '16']")).click();
        }
        driver.findElement(By.id("months")).click();
        {
            WebElement dropdown = driver.findElement(By.id("months"));
            dropdown.findElement(By.cssSelector("option[value = '6']")).click();
        }
        driver.findElement(By.id("years")).click();
        {
            WebElement dropdown = driver.findElement(By.id("years"));
            dropdown.findElement(By.cssSelector("option[value = '1999']")).click();
        }
        driver.findElement(By.id("company")).sendKeys("sony");
        driver.findElement(By.id("address1")).sendKeys("warilico");
        driver.findElement(By.id("id_state")).click();
        {
            WebElement dropdown = driver.findElement(By.id("id_state"));
            dropdown.findElement(By.cssSelector("option[value = '1']")).click();
        }
        driver.findElement(By.id("postcode")).sendKeys("14003");
        driver.findElement(By.id("city")).sendKeys("Genesee");

        driver.findElement(By.id("id_country")).click();
        {
            WebElement element = driver.findElement(By.id("id_country"));
            Actions builder = new Actions(driver);
            builder.doubleClick(element).perform();
        }
        driver.findElement(By.id("other")).sendKeys("si");
        driver.findElement(By.id("phone")).sendKeys("62324737457");
        driver.findElement(By.id("phone_mobile")).sendKeys("43784684694");
        driver.findElement(By.id("alias")).sendKeys("si");
        driver.findElement(By.id("submitAccount")).click();
        Thread.sleep(20000);
        assertEquals("My account - My store",driver.getTitle());
    }

}
