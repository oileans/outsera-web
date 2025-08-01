package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import support.DriverManager;

public class LoginPage {
    private WebDriver driver;

    private By USERNAME = By.cssSelector("[data-test='username']");
    private By PASSWORD = By.cssSelector("[data-test='password']");
    private By LOGIN    = By.id("login-button");
    private By MSG_ERROR = By.cssSelector("[data-test='error']");

    public LoginPage() {
        this.driver = DriverManager.getDriver();
    }

    public void setUser(String username) {
        driver.findElement(USERNAME).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(PASSWORD).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(LOGIN).click();
    }

    public String getErrorMessage() {
        try {
            return driver.findElement(MSG_ERROR).getText();
        } catch (Exception e) {
            return "Erro ao obter mensagem de erro";
        }
    }
}