package support;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class DriverManager {
    private static WebDriver driver;

    public static void iniciar() {
        if (driver == null) {
            ChromeOptions options = new ChromeOptions();

            try {
                // Cria um diretório temporário para o perfil do Chrome (sem dados salvos)
                Path tempProfile = Files.createTempDirectory("chrome-profile");
                options.addArguments("--user-data-dir=" + tempProfile.toAbsolutePath());

            } catch (IOException e) {
                throw new RuntimeException("Erro ao criar perfil temporário do Chrome", e);
            }

            // Modo headless
            options.addArguments("--headless=new");

            // Força execução como convidado (sem conta Google)
            options.addArguments("--guest");

            // Desativa qualquer funcionalidade relacionada a senhas
            options.addArguments("--disable-blink-features=AutomationControlled");
            options.addArguments("--disable-extensions");
            options.addArguments("--disable-save-password-bubble");
            options.addArguments("--disable-features=PasswordManagerEnableLeakDetection,PasswordManagerPreventSigninPromo");

            // Outras opções úteis para testes
            options.addArguments("--disable-popup-blocking");
            options.addArguments("--disable-notifications");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--window-size=1920,1080");

            // Remove o gerenciador de senhas do Chrome
            Map<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);

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
