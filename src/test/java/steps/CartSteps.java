package steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.CartPage;

public class CartSteps {
    private CartPage cartPage = new CartPage();


    @Then("o produto {string} deve estar visível no carrinho")
    public void o_produto_deve_estar_visível_no_carrinho(String nomeProduto) {
        cartPage.clickMiniCart();

        Assert.assertTrue(
                "O produto não está no carrinho: " + nomeProduto,
                cartPage.produtoEstaNoCarrinho(nomeProduto)
        );
    }

    @Then("efetivo a compra do produto selecionado")
    public void efetivo_a_compra_do_produto_selecionado() {
        cartPage.clickCheckout();
        cartPage.preencherDadosCheckoutFaker();
        cartPage.clickContinue();
        cartPage.clickFinish();
        cartPage.getOrderNumber();

        Assert.assertTrue(
                "Usuário não está na Success Page, verifique os logs",
                cartPage.isOnSuccessPage()
        );
    }
}