package automationtesting.aperturapagina;

import automationtesting.Utilidades;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAbrirPagina {

    public static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    @Test
    public void abrirPagina() {

        driver.manage().window().maximize();
        driver.get("http://practice.automationtesting.in/");
        driver.findElement(By.id("menu-item-50")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys("pruebaregistro10@correo.com");
        driver.findElement(By.id("password")).click();
        driver.findElement(By.id("password")).sendKeys("Prueba1+.,");
        driver.findElement(By.name("login")).click();
        Utilidades.esperar(10);


    }

    @After
    public void closed() {
        driver.quit();
    }
}
