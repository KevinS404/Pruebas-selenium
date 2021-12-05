import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


public class test11 {
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
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By   .id("email")).sendKeys("mingeso@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("mingeso");
        driver.findElement(By.id("SubmitLogin")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("MY PERSONAL INFORMATION")).click();
        driver.findElement(By.id("firstname")).sendKeys("*");
        driver.findElement(By.id("lastname")).sendKeys("*");
        driver.findElement(By.id("old_passwd")).sendKeys("mingeso");
        driver.findElement(By.cssSelector("button[name=submitIdentity]")).click();
        Thread.sleep(3000);
        assertTrue(driver.findElement(By.xpath("//p[@class = 'alert alert-success']")).isDisplayed());



    }

}
