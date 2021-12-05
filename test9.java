import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class test9 {
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
        TimeUnit.SECONDS.sleep(10);
        driver.quit();

    }
    @Test
    public void test1() throws InterruptedException {
        driver.findElement(By.linkText("Women")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Blouse")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("wishlist_button")).click();
        Thread.sleep(7000);
        assertTrue(driver.findElement(By.className("fancybox-error")).isDisplayed());



    }

}
