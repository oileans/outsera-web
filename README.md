# 🚀 Projeto de Automação Web – Java + Selenium + Cucumber

Automação de testes end-to-end (E2E) para aplicações web utilizando:
- **Java 11+**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **JUnit 5**
- **Page Object Pattern**
- **Maven** (gerenciamento de dependências)

---

## ✨ Visão Geral

Este projeto executa cenários automatizados de testes em aplicações web, utilizando a abordagem BDD com Cucumber. Toda a estrutura foi criada para facilitar a manutenção e reuso de código, separando responsabilidades em Pages, Steps e suporte de WebDriver.

---

## 🛠️ Tecnologias & Bibliotecas

| Ferramenta         | Função                                      |
|--------------------|---------------------------------------------|
| Java 11+           | Linguagem de programação base               |
| Selenium WebDriver | Automação de browser                        |
| Cucumber           | Testes BDD com Gherkin                      |
| JUnit 5            | Orquestração dos testes                     |
| Maven              | Build & Gerenciamento de dependências        |

---

## ⚙️ Como Executar

### 1. **Clonar o projeto**

```sh
git clone git@github.com:oileans/outsera-web.git
cd seu-projeto-web-automation


2. Instalar dependências
```sh
mvn clean install

3. Executar os testes
```sh
mvn test


3. Relatorio de execução com Cucumber report

target/cucumber-reports/cucumber-report.html
