package com.yandex.market.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Базовый класс для компонентов страницы.
 * Обеспечивает переиспользование общих элементов.
 */
public abstract class BaseComponent extends BasePage {

    /**
     * Конструктор базового компонента.
     *
     * @param driver WebDriver экземпляр
     */
    protected BaseComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}