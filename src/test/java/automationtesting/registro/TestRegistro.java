package automationtesting.registro;

import automationtesting.Utilidades;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

import static automationtesting.Constantes.*;

public class TestRegistro {

    public static WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
    }

    public void seleccionarGender(){
        Random rnd = new Random();
        List<WebElement> radios = driver.findElements(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[5]/div/label"));
        radios.get(rnd.nextInt(radios.size())).click();
    }

    public void seleccionarHobbies(){

        for (WebElement e : driver.findElements(By.xpath("//input[@type='checkbox']")))
        {
            if(!e.isSelected())
                e.click();
        }
    }


    @Test
    public void realizarRegistro() {

        driver.manage().window().maximize();
        driver.get(URL_DEMO_REGISTER);
        Utilidades.esperar(TIEMPO_ESPERA_CORTO);
        driver.findElement(By.xpath(CAJA_FULL_NAME)).click();
        driver.findElement(By.xpath(CAJA_FULL_NAME)).sendKeys(FULL_NAME);
        driver.findElement(By.xpath(CAJA_LAST_NAME)).click();
        driver.findElement(By.xpath(CAJA_LAST_NAME)).sendKeys(LAST_NAME);
        driver.findElement(By.xpath(TEXT_AREA_DIRECCION)).click();
        driver.findElement(By.xpath(TEXT_AREA_DIRECCION)).sendKeys(DIRECCION);
        driver.findElement(By.xpath(CAJA_EMAIL)).click();
        driver.findElement(By.xpath(CAJA_EMAIL)).sendKeys(EMAIL);
        driver.findElement(By.xpath(CAJA_TELEFONO)).click();
        driver.findElement(By.xpath(CAJA_TELEFONO)).sendKeys(TELEFONO);
        seleccionarGender();
        seleccionarHobbies();


        Utilidades.esperar(10);

    }



    @After
    public void closed() {
        driver.quit();
    }
}
