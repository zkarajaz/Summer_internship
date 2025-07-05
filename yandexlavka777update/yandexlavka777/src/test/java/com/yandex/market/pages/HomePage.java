package com.yandex.market.pages;

import com.yandex.market.base.BasePage;
import com.yandex.market.components.HeaderComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Класс для работы с главной страницей Яндекс.Маркета.
 */
public class HomePage extends BasePage {
    private final HeaderComponent header;

    @FindBy(xpath = "//*[@id=\"header-search\"]")
    private WebElement searchInput;

    @FindBy(xpath = "//*[@id=\"HeaderSearchLightId\"]/div[1]/button/span")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id=\"/content/header/header/catalogEntrypoint\"]/div/noindex[1]/button")
    private WebElement catalogButton;

    @FindBy(xpath = "//*[@id=\"/MarketNodeHeaderCatalog42\"]/div/div[1]/div/ul/li[5]/a")
    private WebElement catalogMenu;


    public HomePage(WebDriver driver) {
        super(driver);
        this.header = new HeaderComponent(driver);
    }

    /**
     * Получает компонент хедера.
     * @return HeaderComponent
     */
    public HeaderComponent header() {
        return header;
    }

    /**
     * Проверяет корректность заголовка страницы.
     * @return boolean
     */
    public boolean isTitleCorrect() {
        return driver.getTitle().contains("Яндекс Маркет");
    }

    /**
     * Вводит текст в поле поиска.
     * @param text Текст для поиска
     */
    public void enterSearchText(String text) {
        searchInput.clear();
        searchInput.sendKeys(text);
    }

    /**
     * Нажимает кнопку поиска.
     */
    public void clickSearchButton() {
        searchButton.click();
    }

    /**
     * Нажимает кнопку каталога.
     */
    public void clickCatalogButton() {
        catalogMenu.click();
    }

    /**
     * Проверяет отображение меню каталога.
     * @return boolean
     */
    public boolean isCatalogMenuDisplayed() {
        return catalogMenu.isDisplayed();
    }

    /**
     * Открывает категорию электроники.
     */
    public void openElectronicsCategory() {
        catalogButton.click();
        // Здесь должен быть код для выбора категории
    }

}