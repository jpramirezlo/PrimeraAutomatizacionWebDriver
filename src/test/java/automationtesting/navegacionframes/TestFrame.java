package automationtesting.navegacionframes;

import automationtesting.Utilidades;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static automationtesting.Constantes.*;
import static org.junit.Assert.assertEquals;

public class TestFrame {

    public static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    @Test
    public void ingresarAUnFrame() {

        driver.manage().window().maximize();
        driver.get(URL_DEMO_FRAME);
        driver.switchTo().frame("singleframe");
        driver.findElement(By.xpath("/html/body/section/div/div/div/input")).click();
        driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys(VALOR_USUARIO);
        driver.switchTo().defaultContent();

        assertEquals(VALIDAR_TEXTO_INICIAL, driver.findElement(By.tagName("h1")).getText());

        Utilidades.esperar(5);
    }

    @Test
    public void ingresarASegundoFrame() {

        driver.manage().window().maximize();
        driver.get(URL_DEMO_FRAME);
        driver.findElement(By.xpath("//a[contains(text(),'Iframe with in an Iframe')]")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("/html[1]/body[1]/section[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]/iframe[1]")));
        driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
        driver.findElement(By.xpath("//div[@class='col-xs-6 col-xs-offset-5']//input")).click();
        driver.findElement(By.xpath("//div[@class='col-xs-6 col-xs-offset-5']//input")).sendKeys(VALOR_USUARIO);
        driver.switchTo().defaultContent();

        assertEquals(VALIDAR_TEXTO_INICIAL, driver.findElement(By.tagName("h1")).getText());
        Utilidades.esperar(10);
    }

    @After
    public void closed() {
        driver.quit();
    }
}
