package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.ProductPage;
import support.DriverManager;


public class ProductSteps {
    ProductPage productPage;

    @Then("deve ser redirecionado para pagina de produtos")
    public void deve_ser_redirecionado_para_product_page() {
        productPage = new ProductPage();
        Assert.assertTrue(
                "Usuário não está na página de produtos",
                productPage.isOnProductPage()
        );
    }

    @When("adiciona o produto {string} ao carrinho")
    public void adiciona_o_produto_ao_carrinho(String nomeProduto) {
        productPage.addAnyProduct(nomeProduto);
    }
}