package automationtesting;

import automationtesting.registro.TestRegistro;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utilidades extends TestRegistro {

    public static WebDriver driver;

    public static void esperar(long cantidadTiempo) {

        cantidadTiempo = cantidadTiempo * 1000;
        try {
            Thread.sleep(cantidadTiempo);
        } catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        }

    }


}
