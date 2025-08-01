package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    private static WebDriver driver;

    public static void iniciar() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();

            // desativa notificações
            options.addArguments("--disable-notifications");
            // remove infobars de controle remoto
            options.addArguments("disable-infobars", "--disable-popup-blocking");

            // desativa o Password Manager do Chrome
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            // inicializa com as opções
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
            driver.get("https://www.saucedemo.com/v1/");
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void finalizar() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
