package steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CartPage;
import support.BaseTest;

public class CartSteps {

    CartPage cartPage;

    @Then("o produto {string} deve estar visível no carrinho")
    public void verificarProdutoNoCarrinho(String nomeProduto) {
        cartPage = new CartPage(BaseTest.driver);
        cartPage.clicarCheckout();
        boolean presente = cartPage.produtoEstaNoCarrinho(nomeProduto);
        Assert.assertTrue("O produto não está no carrinho: " + nomeProduto, presente);
    }
}
