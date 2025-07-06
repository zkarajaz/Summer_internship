package com.yandex.market.components;

import com.yandex.market.base.BaseComponent;
import com.yandex.market.pages.CartPage;
import com.yandex.market.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Компонент хедера страницы.
 */
public class HeaderComponent extends BaseComponent {
    @FindBy(xpath = "//*[@id=\"/content/header/header/personalization/profile\"]/div/a")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"/content/header/header/personalization/profile\"]/div/button/img")
    private WebElement AccButton;


    @FindBy(xpath = "//*[@id=\"CART_ENTRY_POINT_ANCHOR\"]/a/div/div[1]/span")
    private WebElement cartButton;

    @FindBy(xpath = "//*[@id=\"basketOutline\"]")
    private WebElement cartFromLobbyButton;

    @FindBy(xpath = "//*[@id=\"header-search\"]")
    private WebElement searchInput;

    public HeaderComponent(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return new LoginPage(driver);
    }

    public CartPage clickCartButton() {
        cartButton.click();
        return new CartPage(driver);
    }
    public CartPage clickCartFromLobbyButton() {
        cartFromLobbyButton.click();
        return new CartPage(driver);
    }

    public boolean isLoginButtonDisplayed() {
        return AccButton.isDisplayed();
    }

    public boolean isCartButtonDisplayed() {
        return cartFromLobbyButton.isDisplayed();
    }

    public boolean isSearchInputDisplayed() {
        return searchInput.isDisplayed();
    }
}