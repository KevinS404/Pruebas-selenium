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

//filtro
public class test4 {
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
    public void test4() {
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().setSize(new Dimension(1936, 1056));
        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys("dress");
        driver.findElement(By.name("submit_search")).click();
        driver.findElement(By.id("selectProductSort")).click();
        {
            WebElement dropdown = driver.findElement(By.id("selectProductSort"));
            dropdown.findElement(By.xpath("//option[. = 'Price: Lowest first']")).click();
        }
    }
}