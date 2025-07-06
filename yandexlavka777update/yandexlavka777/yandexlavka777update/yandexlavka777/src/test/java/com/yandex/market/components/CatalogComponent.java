package com.yandex.market.components;

import com.yandex.market.base.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogComponent extends BaseComponent {
    @FindBy(xpath = "//*[@id=\"/content/header/header/catalogEntrypoint\"]/div/noindex[1]/button")
    private WebElement catalogButton;

    @FindBy(xpath = "//*[@id=\"/MarketNodeHeaderCatalog42\"]/div/div[1]/div/ul/li[5]/a")
    private WebElement catalogMenu;

    public CatalogComponent(WebDriver driver) {
        super(driver);
    }

    public void openCatalog() {
        catalogButton.click();
    }

    public void selectElectronicsCategory() {
        catalogMenu.click();
    }

    public boolean isCatalogMenuDisplayed() {
        return catalogMenu.isDisplayed();
    }
}