package com.yandex.market.tests;
import com.yandex.market.components.HeaderComponent;
import com.yandex.market.base.BaseTest;
import com.yandex.market.pages.*;
import com.yandex.market.utils.Constants;
import com.yandex.market.utils.LoggerUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import java.util.Set;

/**
 * Набор тестов для Яндекс.Маркета.
 */
public class YandexMarketTests extends BaseTest {

    /**
     * Тест 1: Проверка заголовка главной страницы.
     */
    @Test(priority = 1)
    public void testHomePageTitle() {
        HomePage homePage = authService.authenticate();
        driver.get("https://market.yandex.ru");
        String actualTitle = driver.getTitle();


        Assert.assertTrue(actualTitle.contains("Яндекс Маркет"),
                "Заголовок страницы не содержит 'Яндекс Маркет'. Фактический заголовок: " + actualTitle);
        ;
    }

    @Test(priority = 2)
    public void testSearchFunctionality() {
        HomePage homePage = authService.authenticate();
        homePage.enterSearchText(Constants.SEARCH_PHONE);
        homePage.clickSearchButton();

        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        Assert.assertTrue(resultsPage.isResultsHeaderDisplayed());
    }

    @Test(priority = 3)
    public void testPriceFilter() {
        HomePage homePage = authService.authenticate();
        homePage.enterSearchText(Constants.SEARCH_LAPTOP);
        homePage.clickSearchButton();

        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        resultsPage.applyPriceFilter(Constants.MIN_PRICE, Constants.MAX_PRICE);
        Assert.assertTrue(resultsPage.arePricesInRange(Constants.MIN_PRICE, Constants.MAX_PRICE));
    }

    @Test(priority = 4)
    public void testSearchRelevance() {
        HomePage homePage = authService.authenticate();
        homePage.enterSearchText(Constants.SEARCH_PHONE);
        homePage.clickSearchButton();

        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        Assert.assertTrue(resultsPage.doProductTitlesContain(Constants.SEARCH_PHONE));
    }

    /**
     * Тест 5: Добавление товара в корзину (модифицированная версия с работой с вкладками).
     */
    @Test(priority = 5)
    public void testAddToCart() {
        LoggerUtil.logInfo("=== Начало теста: Добавление товара в корзину ===");
        String originalWindow = driver.getWindowHandle();

        try {
            HomePage homePage = authService.authenticate();
            LoggerUtil.logInfo("Ввод в строку поиска товар для дальнейшего добавления в корзину");
            homePage.enterSearchText(Constants.SEARCH_LAPTOP);
            LoggerUtil.logInfo("Клик по кнопке Найти");
            homePage.clickSearchButton();

            SearchResultsPage resultsPage = new SearchResultsPage(driver);
            LoggerUtil.logInfo("Выбор первого товара по запросу ноутбук");
            resultsPage.selectFirstProduct();

            // Ожидание и переключение на новую вкладку
            LoggerUtil.logInfo("Ожидание открытия новой вкладки");
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.numberOfWindowsToBe(2));

            Set<String> windows = driver.getWindowHandles();
            for (String window : windows) {
                if (!window.equals(originalWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }

            ProductPage productPage = new ProductPage(driver);
            LoggerUtil.logInfo("Добавление товара в корзину");
            productPage.addToCart();

            // Не ждем обновления иконки, сразу переходим в корзину
            LoggerUtil.logInfo("Переход в корзину");
            CartPage cartPage = productPage.goToCart();

            // Проверяем наличие товара через количество
            Assert.assertTrue(cartPage.isItemInCart(), "Товар не добавлен в корзину");
            LoggerUtil.logInfo("=== Тест успешно завершен ===");

        } catch (Exception e) {
            LoggerUtil.logError("Тест завершился с ошибкой: " + e.getMessage());
            throw e;
        } finally {
            // Закрываем новую вкладку и возвращаемся на исходную
            if (driver.getWindowHandles().size() > 1) {
                driver.close();
                driver.switchTo().window(originalWindow);
            }
        }
    }

    @Test(priority = 6)
    public void testRemoveFromCart() {
        LoggerUtil.logInfo("Запуск теста: Удаление товара из корзины");
        HomePage homePage = authService.authenticate();
        CartPage cartPage = homePage.header().clickCartButton();

        Assert.assertTrue(cartPage.isItemInCart(), "Корзина должна содержать товар перед удалением");
        cartPage.removeItem();
        Assert.assertTrue(cartPage.isEmpty(), "Товар не был удален из корзины");
    }

    /**
     * Тест 7: Проверка работы категорий.
     */
    @Test(priority = 7)
    public void testCategoryNavigation() {
        LoggerUtil.logInfo("Запуск теста: Проверка работы категорий");
        HomePage homePage = authService.authenticate();
        homePage.openElectronicsCategory();
        homePage.clickCatalogButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("elektronika"),
                "Не удалось перейти в категорию 'Электроника'");
    }

    /**
     * Тест 8: Проверка пустой корзины.
     */
    @Test(priority = 8)
    public void testEmptyCart() {
        LoggerUtil.logInfo("Запуск теста: Проверка пустой корзины");
        HomePage homePage = authService.authenticate();
        CartPage cartPage = homePage.header().clickCartFromLobbyButton();

        Assert.assertTrue(cartPage.isEmpty(), "Корзина должна быть пустой");
    }

    /**
     * Тест 9: Проверка кнопки каталога.
     */
    @Test(priority = 9)
    public void testCatalogButton() {
        LoggerUtil.logInfo("Запуск теста: Проверка кнопки каталога");
        HomePage homePage = authService.authenticate();
        homePage.openElectronicsCategory();

        Assert.assertTrue(homePage.isCatalogMenuDisplayed(), "Меню каталога не отображается");
    }

    /**
     * Тест 10: Проверка элементов хедера.
     */
    @Test(priority = 10)
    public void testHeaderElements() {
        LoggerUtil.logInfo("Запуск теста: Проверка элементов хедера");
        HomePage homePage = authService.authenticate();
        HeaderComponent header = homePage.header();

        Assert.assertTrue(header.isLoginButtonDisplayed(), "Кнопка входа не отображается");
        Assert.assertTrue(header.isCartButtonDisplayed(), "Кнопка корзины не отображается");
        Assert.assertTrue(header.isSearchInputDisplayed(), "Поле поиска не отображается");
    }
}