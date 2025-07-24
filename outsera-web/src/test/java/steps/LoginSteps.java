package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.LoginPage;
import support.YamlUserReader;

public class LoginSteps {
    LoginPage loginPage;

    @Given("que efetuo login com uma credencial valida")
    public void loginCredentialValida() {
        loginPage = new LoginPage();
        YamlUserReader.Usuario user = YamlUserReader.getUsuarioAleatorio();
        loginPage.setUser(user.getUsuario());
        loginPage.setPassword(user.getSenha());
        loginPage.clickLogin();
        System.out.println("Credenciais utilizadas:\nUsuário: " + user.getUsuario() + "\nSenha: " + user.getSenha());
    }

    @When("preencho o usuário {string} e a senha {string}")
    public void preencherUsuarioSenha(String usuario, String senha) {
        loginPage.setUser(usuario);
        loginPage.setPassword(senha);
    }

    @Then("deve ser exibida a mensagem de erro {string}")
    public void validarMensagemErro(String mensagemEsperada) {
        Assert.assertEquals(mensagemEsperada, loginPage.getErrorMessage());
    }
}
