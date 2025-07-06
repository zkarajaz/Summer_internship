package com.yandex.market.components;

import com.yandex.market.base.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchComponent extends BaseComponent {
    @FindBy(xpath = "//*[@id=\"header-search\"]")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"HeaderSearchLightId\"]/div[1]/button/span")
    private WebElement searchButton;

    public SearchComponent(WebDriver driver) {
        super(driver);
    }

    public void searchFor(String text) {
        searchInput.clear();
        searchInput.sendKeys(text);
        searchButton.click();
    }

    public boolean isSearchInputDisplayed() {
        return searchInput.isDisplayed();
    }
}