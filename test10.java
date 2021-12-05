import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class test10 {
    private WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\sebastian\\Desktop\\Pruebas\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

    }
    @After
    public void tearDown() throws InterruptedException {
        driver.quit();

    }
    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.linkText("Women")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Blouse")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button[name=Submit]")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Proceed to checkout")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Proceed to checkout")).click();
        Thread.sleep(4000);
        //assertTrue(driver.findElement(By.id("SubmitCreate")).isDisplayed());
        driver.findElement(By.id("email")).sendKeys("mingeso1@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("mingeso");
        driver.findElement(By.id("SubmitLogin")).click();
        Thread.sleep(4000);
        driver.findElement(By.cssSelector("button[name=processAddress]")).click();
        Thread.sleep(4000);
        driver.findElement(By.id("cgv")).click();
        driver.findElement(By.cssSelector("button[name=processCarrier]")).click();
        Thread.sleep(3000);
        driver.findElement(By.className("cheque")).click();
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("#cart_navigation span")).click();
        Thread.sleep(4000);
        assertEquals("Order confirmation - My Store",driver.getTitle());
    }

}