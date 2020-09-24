package automationtesting;

import org.openqa.selenium.WebDriver;

public class Utilidades {

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
