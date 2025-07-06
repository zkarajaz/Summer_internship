package com.yandex.market.services;

import com.yandex.market.pages.HomePage;
import com.yandex.market.pages.LoginPage;
import com.yandex.market.utils.Constants;
import com.yandex.market.utils.LoggerUtil;
import org.openqa.selenium.WebDriver;

/**
 * Сервис для выполнения операций аутентификации.
 * Инкапсулирует логику входа в систему.
 */
public class AuthService {

    private final WebDriver driver;

    public AuthService(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Выполняет аутентификацию пользователя.
     *
     * @return HomePage главная страница после успешной аутентификации
     */
    public HomePage authenticate() {
        LoggerUtil.logInfo("Starting authentication process");

        HomePage homePage = new HomePage(driver);
        driver.get("https://market.yandex.ru");

        LoginPage loginPage = homePage.header().clickLoginButton();
        return loginPage.login(Constants.USERNAME, Constants.PASSWORD);
    }
}