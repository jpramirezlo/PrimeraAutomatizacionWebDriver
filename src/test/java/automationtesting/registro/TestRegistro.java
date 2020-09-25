package automationtesting.registro;

import automationtesting.Utilidades;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

import static automationtesting.Constantes.*;
import static org.junit.Assert.assertEquals;

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

    public void hacerClicBotonSubmit(WebDriver driver) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click()", driver.findElement(By.id("submitbtn")));
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
        driver.findElement(By.id(LENGUAGE)).click();
        driver.findElement(By.xpath(SELLECION_LENGUAGE)).click();
        Select selSkills = new Select(driver.findElement(By.id(SKILLS)));
        selSkills.selectByValue(VALOR_SKILLS);
        Select selCountry = new Select(driver.findElement(By.id(COUNTRY)));
        selCountry.selectByValue(VALOR_COUNTRY);
        driver.findElement(By.xpath(SELECT_COUNTRY)).click();
        driver.findElement(By.xpath(VALOR_SELECT_COUNTRY)).click();
        Select selDateYear = new Select(driver.findElement(By.id(DATA_YEAR)));
        selDateYear.selectByValue(VALOR_DATA_YEAR);
        Select selDateMonth = new Select(driver.findElement(By.xpath(DATA_MONTH)));
        selDateMonth.selectByValue(VALOR_DATA_MONTH);
        Select selDateDay = new Select(driver.findElement(By.id(DATA_DAY)));
        selDateDay.selectByValue(VALOR_DATA_DAY);
        driver.findElement(By.xpath(PASSW)).click();
        driver.findElement(By.xpath(PASSW)).sendKeys(VALOR_PASSW);
        driver.findElement(By.xpath(CONFIRM_PASSW)).click();
        driver.findElement(By.xpath(CONFIRM_PASSW)).sendKeys(VALOR_CONFIRM_PASSW);
        Utilidades.esperar(10);
        hacerClicBotonSubmit(driver);
        Utilidades.esperar(20);

        assertEquals(VALIDAR_REGISTRO, driver.findElement(By.xpath("//h4[1]")).getText());
        Utilidades.esperar(10);

    }



    @After
    public void closed() {
        driver.quit();
    }
}
