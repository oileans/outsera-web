Feature: Login e Checkout

  Scenario: Login com sucesso e navegação para checkout
    Given que o usuário acessa a página de login
    When insere credenciais válidas
    Then deve ser redirecionado para pagina de produtos


  Scenario: Exibir mensagem de erro ao tentar login com credenciais inválidas
    Given que o usuário acessa a página de login
    When preencho o usuário "123" e a senha "123"
    And clico no botão de login
    Then deve ser exibida a mensagem de erro "Epic sadface: Username and password do not match any user in this service"

