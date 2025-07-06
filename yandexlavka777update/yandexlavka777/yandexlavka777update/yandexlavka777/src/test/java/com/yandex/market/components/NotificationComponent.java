package com.yandex.market.components;

import com.yandex.market.base.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NotificationComponent extends BaseComponent {
    @FindBy(xpath = "//div[contains(@class, 'notification')]")
    private WebElement notificationPopup;

    @FindBy(xpath = "//button[contains(text(), 'Закрыть')]")
    private WebElement closeNotificationButton;

    public NotificationComponent(WebDriver driver) {
        super(driver);
    }

    public void closeNotificationIfPresent() {
        try {
            wait.until(ExpectedConditions.visibilityOf(notificationPopup));
            closeNotificationButton.click();
        } catch (Exception e) {
            // Уведомление не появилось, ничего не делаем
        }
    }

    public boolean isNotificationDisplayed() {
        try {
            return notificationPopup.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}