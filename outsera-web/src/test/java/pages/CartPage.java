package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class CartPage {
    public WebDriver driver;


    By BOTAO_CARRINHO = By.cssSelector("[data-icon='shopping-cart']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }


    public void clicarCheckout() {
        driver.findElement(BOTAO_CARRINHO).click();
    }


    public boolean produtoEstaNoCarrinho(String nomeProduto) {
        String xpath = String.format("//div[@class='cart_item']//div[text()='%s']", nomeProduto);
        return !driver.findElements(By.xpath(xpath)).isEmpty(); // Mais semântico
    }
}
