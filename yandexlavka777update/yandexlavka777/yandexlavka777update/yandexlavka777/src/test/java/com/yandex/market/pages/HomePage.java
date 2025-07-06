package com.yandex.market.pages;

import com.yandex.market.base.BasePage;
import com.yandex.market.components.*;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private final HeaderComponent header;
    private final SearchComponent search;
    private final CatalogComponent catalog;
    private final NotificationComponent notification;

    public HomePage(WebDriver driver) {
        super(driver);
        this.header = new HeaderComponent(driver);
        this.search = new SearchComponent(driver);
        this.catalog = new CatalogComponent(driver);
        this.notification = new NotificationComponent(driver);
    }

    public HeaderComponent header() {
        return header;
    }

    public SearchComponent search() {
        return search;
    }

    public CatalogComponent catalog() {
        return catalog;
    }

    public NotificationComponent notification() {
        return notification;
    }

    public boolean isTitleCorrect() {
        return driver.getTitle().contains("Яндекс Маркет");
    }
}