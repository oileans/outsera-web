package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private WebDriver driver;

    By PRODUCT_LIST_TITLE = By.cssSelector("div.product_label");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isOnProductPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_LIST_TITLE)).isDisplayed();
    }

    public void addAnyProduct(String nomeProduto) {
        String xpath = String.format("//div[text()='%s']/ancestor::div[@class='inventory_item']//button", nomeProduto);
        driver.findElement(By.xpath(xpath)).click();
    }
}
