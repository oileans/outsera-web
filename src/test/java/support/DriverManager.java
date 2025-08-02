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

            // Modo headless moderno
            options.addArguments("--headless=new");

            // Desativa notificações e popups
            options.addArguments("--disable-notifications");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("disable-infobars");

            // Outros ajustes úteis em headless
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--no-sandbox");
            options.addArguments("--window-size=1920,1080");

            // Desativa o gerenciador de senhas do Chrome
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

            // Inicializa o driver
            driver = new ChromeDriver(options);
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
