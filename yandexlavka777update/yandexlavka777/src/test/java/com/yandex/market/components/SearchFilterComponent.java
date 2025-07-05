package com.yandex.market.components;

import com.yandex.market.base.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Компонент фильтра поиска.
 * Содержит элементы и методы для работы с фильтрами на странице результатов.
 */
public class SearchFilterComponent extends BaseComponent {

    @FindBy(xpath = "//*[@id=\"range-filter-field-glprice_25563_min\"]")
    private WebElement minPriceInput;

    @FindBy(xpath = "//*[@id=\"range-filter-field-glprice_25563_max\"]")
    private WebElement maxPriceInput;

    @FindBy(css = "[data-auto='filter-apply']")
    private WebElement applyButton;

    public SearchFilterComponent(WebDriver driver) {
        super(driver);
    }

    /**
     * Устанавливает минимальную цену.
     *
     * @param price минимальная цена
     */
    public void setMinPrice(int price) {
        minPriceInput.clear();
        minPriceInput.sendKeys(String.valueOf(price));
    }

    /**
     * Устанавливает максимальную цену.
     *
     * @param price максимальная цена
     */
    public void setMaxPrice(int price) {
        maxPriceInput.clear();
        maxPriceInput.sendKeys(String.valueOf(price));
    }

    /**
     * Применяет установленные фильтры.
     */
    public void applyFilters() {
        applyButton.click();
    }
}