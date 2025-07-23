package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.LoginPage;
import support.BaseTest;
import support.YamlUserReader;

public class LoginSteps {

    LoginPage loginPage;

    @Given("que o usuário acessa a página de login")
    public void que_usuario_acessa_pagina_login() {
        loginPage = new LoginPage(BaseTest.driver);
    }

    @When("insere credenciais válidas")
    public void insere_credenciais_validas() {
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

    @And("clico no botão de login")
    public void clicarNoLogin() {
        loginPage.clickLogin();
    }

    @Then("deve ser exibida a mensagem de erro {string}")
    public void validarMensagemErro(String mensagemEsperada) {
        Assert.assertEquals(mensagemEsperada, loginPage.getErrorMessage());
    }
}
