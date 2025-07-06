package com.yandex.market.pages;

import com.yandex.market.base.BasePage;
import com.yandex.market.utils.LoggerUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"passp:exp-register\"]")
    private WebElement moreOptionsButton;

    @FindBy(xpath = "//*[@id=\"passp-field-login\"]")
    private WebElement usernameInput;

    @FindBy(xpath = "//*[@id=\"passp:sign-in\"]")
    private WebElement submitLoginButton;

    @FindBy(xpath = "//*[@id=\"passp-field-passwd\"]")
    private WebElement passwordInput;

    @FindBy(xpath = "//*[@id=\"passp:sign-in\"]")
    private WebElement submitPasswordButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public HomePage login(String username, String password) {
        clickMoreOptionsButton();
        selectLoginByUsername();
        enterUsername(username);
        clickSubmitLoginButton();
        enterPassword(password);
        return clickSubmitPasswordButton();
    }

    private void clickMoreOptionsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(moreOptionsButton)).click();
        LoggerUtil.logInfo("Clicked 'More options' button");
    }

    private void selectLoginByUsername() {
        try {
            // Первый вариант XPath (новая структура)
            String xpath1 = "//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div[2]/div[3]/div/div/div/div/form/div/div[3]/div[2]/div/div[2]/div/div/ul/li[3]/button";

            // Второй вариант XPath (старая структура)
            String xpath2 = "//*[@id=\"root\"]/div/div[2]/div[2]/div/div[2]/div[2]/div[2]/div/div/div/div/form/div/div[3]/div[2]/div/div[2]/div/div/ul/li[3]/button";

            // Пытаемся найти по первому XPath
            List<WebElement> options = driver.findElements(By.xpath(xpath1));

            // Если первый не найден, пробуем второй
            if (options.isEmpty()) {
                options = driver.findElements(By.xpath(xpath2));
            }

            // Если хотя бы один вариант найден
            if (!options.isEmpty()) {
                WebElement element = options.get(0);
                wait.until(ExpectedConditions.elementToBeClickable(element)).click();
                LoggerUtil.logInfo("Selected 'Login by username' option");
            } else {
                throw new NoSuchElementException("Login option not found with either XPath");
            }
        } catch (Exception e) {
            // Используем новый метод logError
            LoggerUtil.logError("Error selecting login option: " + e.getMessage());
            throw e;
        }
    }

    private void enterUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(usernameInput)).sendKeys(username);
        LoggerUtil.logInfo("Entered username");
    }

    private void clickSubmitLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitLoginButton)).click();
        LoggerUtil.logInfo("Submitted login");
    }

    private void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);
        LoggerUtil.logInfo("Entered password");
    }

    private HomePage clickSubmitPasswordButton() {
        wait.until(ExpectedConditions.elementToBeClickable(submitPasswordButton)).click();
        LoggerUtil.logInfo("Submitted password");
        return new HomePage(driver);
    }
}