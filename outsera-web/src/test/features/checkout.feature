Feature: Fluxo de checkout simples no e-commeerce


  Scenario: Adicionar produto ao carrinho e finalizar a compra com sucesso
    Given que o usuário acessa a página de login
    And insere credenciais válidas
    When adiciona o produto "Sauce Labs Backpack" ao carrinho
    Then o produto "Sauce Labs Backpack" deve estar visível no carrinho


