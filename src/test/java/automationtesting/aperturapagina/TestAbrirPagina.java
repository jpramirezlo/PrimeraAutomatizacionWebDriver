package automationtesting.aperturapagina;

import automationtesting.Utilidades;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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

        Utilidades.esperar(10);
    }

    @After
    public void closed() {
        driver.quit();
    }
}
