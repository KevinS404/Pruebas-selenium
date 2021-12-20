import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;


public class test11 {
    private WebDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","E:\\Desktop\\ramos\\MINGESO\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();

    }
    @After
    public void tearDown() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        driver.quit();

    }
    //Contact us exitoso, este caso simula una prueba para la funcionalidad del contact us cuando funciona
    @Test
    public void test1() throws InterruptedException {
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.linkText("Contact us")).click();
        driver.findElement(By.id("id_contact")).click();
        {
            WebElement dropdown = driver.findElement(By.id("id_contact"));
            dropdown.findElement(By.xpath("//option[. = 'Customer service']")).click();
        }
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".form-group:nth-child(5)")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("mingeso@gmail.com");
        driver.findElement(By.id("id_order")).click();
        driver.findElement(By.id("id_order")).sendKeys("141414");
        driver.findElement(By.id("message")).click();
        driver.findElement(By.id("message")).sendKeys("Problema");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#submitMessage > span")).click();
    }

    //error de contact us, este caso simula el error del contact us cuando no se incluye un mensaje
    @Test
    public void test2() throws InterruptedException{
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.linkText("Contact us")).click();
        driver.findElement(By.id("id_contact")).click();
        {
            WebElement dropdown = driver.findElement(By.id("id_contact"));
            dropdown.findElement(By.xpath("//option[. = 'Customer service']")).click();
        }
        Thread.sleep(3000);
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("mingeso@gmail.com");
        driver.findElement(By.id("id_order")).click();
        driver.findElement(By.id("id_order")).sendKeys("141414");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#submitMessage > span")).click();
    }

    //re ordenar un pedido
    @Test
    public void test3() throws InterruptedException{
        driver.get("http://automationpractice.com/index.php");
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
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".standard-checkout > span")).click();
        driver.findElement(By.linkText("Pay by bank wire (order processing will be longer)")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#cart_navigation span")).click();
        // Falta assertion
    }

    //filtro de ropa por el precio mas bajo
    @Test
    public void test4() throws InterruptedException{
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.id("search_query_top")).click();
        driver.findElement(By.id("search_query_top")).sendKeys("dress");
        Thread.sleep(2000);
        driver.findElement(By.name("submit_search")).click();
        driver.findElement(By.id("selectProductSort")).click();
        {
            WebElement dropdown = driver.findElement(By.id("selectProductSort"));
            dropdown.findElement(By.xpath("//option[. = 'Price: Lowest first']")).click();
        }
        Thread.sleep(2000);
    }


    //borrar lista de deseos
    @Test
    public void test5() throws InterruptedException{
        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).click();
        driver.findElement(By.id("email")).sendKeys("mingeso@gmail.com");
        driver.findElement(By.id("passwd")).click();
        driver.findElement(By.id("passwd")).sendKeys("mingeso");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#SubmitLogin > span")).click();
        driver.findElement(By.cssSelector(".lnk_wishlist span")).click();
        driver.findElement(By.id("name")).click();
        driver.findElement(By.id("name")).sendKeys("lista de prueba");
        driver.findElement(By.cssSelector("#submitWishlist > span")).click();
        driver.findElement(By.cssSelector(".icon-remove")).click();
        assertThat(driver.switchTo().alert().getText(), is("Do you really want to delete this wishlist ?"));
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }

    @Test
    //Login valido
    public void test6() {

        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).sendKeys("ergeag@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("asdgf");
        driver.findElement(By.id("SubmitLogin")).click();
        //assertEquals("My account - My Store",driver.getTitle());
        assertEquals("http://automationpractice.com/index.php?controller=my-account",driver.getCurrentUrl());
    }


    //prueba de registro para usuario nuevo
    @Test
    public void test7() throws InterruptedException {
        driver.findElement(By.linkText("Sign in")).click();
        Thread.sleep(2000);
        //ES NECESARIO CAMBIAR EL CORREO CADA VEZ QUE SE EJECUTA ESTA PRUEBA
        driver.findElement(By.id("email_create")).sendKeys("mingeso32@gmail.com");
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

    //Prueba para registrarse con un correo ya creado
    @Test
    public void test8() throws InterruptedException {
        driver.findElement(By.linkText("Sign in")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("email_create")).sendKeys("mingeso@gmail.com");
        driver.findElement(By.id("SubmitCreate")).click();
        Thread.sleep(3000);
        assertTrue(driver.findElement(By.id("create_account_error")).isDisplayed());
    }


    //Prueba para tratar de añadir ropa a una lista de deseos sin estar logeado
    @Test
    public void test9() throws InterruptedException {
        driver.findElement(By.linkText("Women")).click();
        Thread.sleep(2000);
        driver.findElement(By.linkText("Blouse")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("wishlist_button")).click();
        Thread.sleep(4000);
        assertTrue(driver.findElement(By.className("fancybox-error")).isDisplayed());



    }

    //Prueba para pagar sin haber estado logeado previamente
    @Test
    public void test10() throws InterruptedException {
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


    //Prueba para actualizar los datos del usuario
    @Test
    public void test11() throws InterruptedException {
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

    @Test
    //Login invalido
    public void test12() {
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.id("email")).sendKeys("ergeag@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("asdg");
        driver.findElement(By.id("SubmitLogin")).click();
        //assertEquals("My account - My Store",driver.getTitle());
        assertEquals("http://automationpractice.com/index.php?controller=my-account",driver.getCurrentUrl());
    }

}
