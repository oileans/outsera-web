package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    public static WebDriver driver;

    public static void inicializar() {
        if (driver == null) {
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com/v1/");
        }
    }

    public static void finalizar() {
        if (driver != null) {
            driver.quit();
            System.out.println("Navegador finalizado.");
        }
    }
}
