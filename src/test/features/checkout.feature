Feature: Fluxo de checkout simples no e-commerce

  Scenario: Adicionar produto ao carrinho e finalizar a compra com sucesso
    Given que efetuo login com uma credencial valida
    When adiciona o produto "Sauce Labs Backpack" ao carrinho
    Then o produto "Sauce Labs Backpack" deve estar visível no carrinho
    And efetivo a compra do produto selecionado