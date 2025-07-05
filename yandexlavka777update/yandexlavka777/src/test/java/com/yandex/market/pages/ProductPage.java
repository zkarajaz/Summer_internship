package com.yandex.market.pages;

import com.yandex.market.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductPage extends BasePage {
    @FindBy(xpath = "//*[@data-apiary-widget-name='@light/AddToCartButton']")
    private WebElement addToCartButton;


    @FindBy(xpath = "//*[@id=\"basketOutline\"]")
    private WebElement cartLink;

    @FindBy(xpath = "//*[@id=\"basketOutline\"]")
    private WebElement cartIcon;
    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addToCart() {
        addToCartButton.click();
    }

    public CartPage goToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartLink)).click();
        return new CartPage(driver);
    }

    // Добавляем публичный метод для ожидания обновления иконки
    public void waitForCartIconUpdate(String expectedText) {
        wait.until(ExpectedConditions.textToBePresentInElement(cartIcon, expectedText));
    }
}