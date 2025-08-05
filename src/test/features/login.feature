@Epic(Login)
Feature: Login

  Scenario: Login com sucesso e navegação para checkout
    Given que efetuo login com uma credencial valida
    Then deve ser redirecionado para pagina de produtos


  Scenario: Login com usuário bloqueado
    Given que estou na página de login
    When preencho o usuário "locked_out_user" e a senha "secret_sauce"
    And clico no botão de login
    Then devo ver a mensagem de erro "Epic sadface: Sorry, this user has been locked out."