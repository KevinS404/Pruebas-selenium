import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;

// Login Valido
public class test6 {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\sebastian\\Desktop\\Pruebas\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().setSize(new Dimension(1936, 1056));
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void test3() {

        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).sendKeys("ergeag@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("asdf");
        driver.findElement(By.id("SubmitLogin")).click();
        //assertEquals("My account - My Store",driver.getTitle());
        assertEquals("http://automationpractice.com/index.php?controller=my-account",driver.getCurrentUrl());
    }
}
