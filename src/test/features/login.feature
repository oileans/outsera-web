@Epic(Login)
Feature: Login

  Scenario: Login com sucesso e navegação para checkout
    Given que efetuo login com uma credencial valida
    Then deve ser redirecionado para pagina de produtos