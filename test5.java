import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import java.util.*;
import java.util.concurrent.TimeUnit;

//borrar lista
public class test5 {
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
    public void test5() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("mingeso@gmail.com");
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).sendKeys("mingeso");
        driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
        driver.findElement(By.cssSelector(".lnk_wishlist span")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).sendKeys("lista de prueba");
        driver.findElement(By.cssSelector("#submitWishlist > span")).click();
        driver.findElement(By.cssSelector(".icon-remove")).click();
        assertThat(driver.switchTo().alert().getText(), is("Do you really want to delete this wishlist ?"));
        driver.switchTo().alert().accept();
    }
}
