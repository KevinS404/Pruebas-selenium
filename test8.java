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


public class test8 {
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
        driver.findElement(By.id("email_create")).sendKeys("mingeso@gmail.com");
        driver.findElement(By.id("SubmitCreate")).click();
        Thread.sleep(3000);
        assertTrue(driver.findElement(By.id("create_account_error")).isDisplayed());
    }

}
