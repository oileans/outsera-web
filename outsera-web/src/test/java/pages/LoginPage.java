package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By USERNAME = By.cssSelector("[data-test='username']");
    By PASSWORD = By.cssSelector("[data-test='password']");
    By MSG_ERROR = By.cssSelector("[data-test='error']");
    By LOGIN = By.id("login-button");


    public void setUser(String username) {
        driver.findElement(USERNAME).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(PASSWORD).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(LOGIN).isDisplayed();
        driver.findElement(LOGIN).click();
    }

    public String getErrorMessage() {
        try {
            return driver.findElement(MSG_ERROR).getText();
        } catch (NoSuchElementException e) {
            return "Não foi possível verificar a msg em tela";
        }
    }
}
