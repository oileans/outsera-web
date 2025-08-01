package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.DriverManager;

import java.time.Duration;
import java.util.Locale;

public class CartPage {
    private WebDriver driver;
    private static final By BOTAO_CARRINHO = By.cssSelector("[data-icon='shopping-cart']");
    private static final By BOTAO_CHECKOUT = By.cssSelector(".btn_action.checkout_button");
    private static final By FIRST_NAME = By.cssSelector("[data-test='firstName']");
    private static final By LAST_NAME = By.cssSelector("[data-test='lastName']");
    private static final By ZIP_CODE = By.cssSelector("[data-test='postalCode']");
    private static final By CONTINUE_BTN = By.cssSelector(".btn_primary.cart_button");
    private static final By ORDER_NUMBER = By.cssSelector("summary_value_label");
    private static final By SUCCESS_PAGE = By.id("checkout_complete_container");
    private static final By FINISH_BTN = By.className("cart_button");

    public CartPage() {
        this.driver = DriverManager.getDriver();
    }

    public void clickMiniCart() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(BOTAO_CARRINHO))
                .click();
    }


    public void preencherDadosCheckoutFaker() {
        Faker faker = new Faker(new Locale("pt-BR"));
        String firstName = faker.address().firstName();
        String lastName = faker.address().lastName();
        String zipCode = faker.address().zipCode();


        driver.findElement(FIRST_NAME).sendKeys(firstName);
        driver.findElement(LAST_NAME).sendKeys(lastName);
        driver.findElement(ZIP_CODE).sendKeys(zipCode);

        System.out.println("Nome: " + firstName);
        System.out.println("Sobrenome: " + lastName);
        System.out.println("Zip Code: " + zipCode);
    }

    public void clickCheckout() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(BOTAO_CHECKOUT))
                .click();
    }

    public void clickContinue() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(CONTINUE_BTN))
                .click();
    }

    public void clickFinish() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(FINISH_BTN))
                .click();
    }

    public boolean produtoEstaNoCarrinho(String nomeProduto) {
        String xpath = String.format("//div[@class='cart_item']//div[text()='%s']", nomeProduto);
        return !driver.findElements(By.xpath(xpath)).isEmpty();
    }

    public String getOrderNumber() {
        try {
            return driver.findElement(ORDER_NUMBER).getText();
        } catch (Exception e) {
            return "Erro ao obter número do pedido de erro";
        }
    }

    public boolean isOnSuccessPage() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(SUCCESS_PAGE))
                .isDisplayed();
    }

}