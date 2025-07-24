package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.DriverManager;


import java.time.Duration;

public class ProductPage {
    WebDriver driver;
    static final By PRODUCT_LIST_TITLE = By.cssSelector("div.product_label");

    public ProductPage() {
        this.driver = DriverManager.getDriver();
    }

    public boolean isOnProductPage() {
        return new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_LIST_TITLE))
                .isDisplayed();
    }

    public void addAnyProduct(String nomeProduto) {
        String xpath = String.format(
                "//div[text()='%s']/ancestor::div[@class='inventory_item']//button", nomeProduto
        );
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)))
                .click();
    }
}