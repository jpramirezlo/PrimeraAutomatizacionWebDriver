package automationtesting.aperturapagina;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestAbrirPagina {

    public static WebDriver driver;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    @Test
    public void abrirPagina() throws InterruptedException {

        driver.manage().window().maximize();
        driver.get("http://practice.automationtesting.in/");

    }


    @After
    public void closed(){
        driver.quit();
    }
}
