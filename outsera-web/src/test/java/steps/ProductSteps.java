package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ProductPage;
import support.BaseTest;

import static support.BaseTest.driver;

public class ProductSteps {

    ProductPage productPage;


    @Then("deve ser redirecionado para pagina de produtos")
    public void deve_ser_redirecionado_para_product_page() {
        productPage = new ProductPage(BaseTest.driver);
        Assert.assertTrue("Usuário não está na página de produtos", productPage.isOnProductPage());
    }

    @When("adiciona o produto {string} ao carrinho")
    public void adicionarProdutoAoCarrinho(String nomeProduto) {
        productPage = new ProductPage(driver);
        productPage.addAnyProduct(nomeProduto);
    }
}
