package com.yandex.market.tests;
import com.yandex.market.base.BaseTest;
import com.yandex.market.pages.CartPage;
import com.yandex.market.pages.ProductPage;
import com.yandex.market.pages.SearchResultsPage;
import com.yandex.market.utils.Constants;
import com.yandex.market.utils.LoggerUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.Set;

public class YandexMarketTests extends BaseTest {

    @Test(priority = 1)
    public void testHomePageTitle() {
        LoggerUtil.logInfo("Проверка заголовка главной страницы");
        driver.get("https://market.yandex.ru");
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains("Яндекс Маркет"),
                "Заголовок страницы не содержит 'Яндекс Маркет'. Фактический заголовок: " + actualTitle);
    }

    @Test(priority = 2)
    public void testSearchFunctionality() {
        LoggerUtil.logInfo("Проверка функциональности поиска");
        homePage.search().searchFor(Constants.SEARCH_PHONE);
        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        Assert.assertTrue(resultsPage.isResultsHeaderDisplayed());
    }

    @Test(priority = 3)
    public void testPriceFilter() {
        LoggerUtil.logInfo("Проверка фильтра по цене");
        homePage.search().searchFor(Constants.SEARCH_LAPTOP);
        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        resultsPage.applyPriceFilter(Constants.MIN_PRICE, Constants.MAX_PRICE);
        int firstItemPrice = resultsPage.getFirstItemPrice();
        Assert.assertTrue(firstItemPrice >= Constants.MIN_PRICE && firstItemPrice <= Constants.MAX_PRICE,
                String.format("Цена первого товара %d не попадает в диапазон %d-%d",
                        firstItemPrice, Constants.MIN_PRICE, Constants.MAX_PRICE));
    }

    @Test(priority = 4)
    public void testSearchRelevance() {
        LoggerUtil.logInfo("Проверка релевантности поиска");
        homePage.search().searchFor(Constants.SEARCH_PHONE);
        SearchResultsPage resultsPage = new SearchResultsPage(driver);
        String firstItemTitle = resultsPage.getFirstItemTitle();
        Assert.assertTrue(firstItemTitle.toLowerCase().contains(Constants.SEARCH_PHONE.toLowerCase()),
                "Первый товар '" + firstItemTitle + "' не содержит '" + Constants.SEARCH_PHONE + "'");
    }

    @Test(priority = 5)
    public void testAddToCart() {
        LoggerUtil.logInfo("=== Тест: Добавление товара в корзину ===");
        String originalWindow = driver.getWindowHandle();

        try {
            homePage.search().searchFor(Constants.SEARCH_LAPTOP);
            SearchResultsPage resultsPage = new SearchResultsPage(driver);
            resultsPage.selectFirstProduct();

            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.numberOfWindowsToBe(2));

            Set<String> windows = driver.getWindowHandles();
            for (String window : windows) {
                if (!window.equals(originalWindow)) {
                    driver.switchTo().window(window);
                    break;
                }
            }
            // Добавление в корзину (новый код)
            ProductPage productPage = new ProductPage(driver);
            productPage.clickAddToCartButton(); // Клик по кнопке добавления

            productPage.clickAddToCartButton();

            // Проверка корзины
            CartPage cartPage = productPage.goToCart();
            driver.navigate().refresh();
            Assert.assertTrue(cartPage.isItemInCart(), "Товар не добавлен в корзину");
            LoggerUtil.logInfo("=== Тест успешно завершен ===");

        } finally {
            if (driver.getWindowHandles().size() > 1) {
                driver.close();
                driver.switchTo().window(originalWindow);
            }
        }
    }

    @Test(priority = 6)
    public void testRemoveFromCart() {
        LoggerUtil.logInfo("Тест: Удаление товара из корзины");
        CartPage cartPage = homePage.header().clickCartButton();
        Assert.assertTrue(cartPage.isItemInCart(), "Корзина должна содержать товар перед удалением");
        cartPage.removeItem();
        Assert.assertTrue(cartPage.isEmpty(), "Товар не был удален из корзины");
    }

    @Test(priority = 7)
    public void testCategoryNavigation() {
        LoggerUtil.logInfo("Тест: Навигация по категориям");
        homePage.catalog().openCatalog();
        homePage.catalog().selectElectronicsCategory();
        Assert.assertTrue(driver.getCurrentUrl().contains("elektronika"),
                "Не удалось перейти в категорию 'Электроника'");
    }

    @Test(priority = 8)
    public void testEmptyCart() {
        LoggerUtil.logInfo("Тест: Проверка пустой корзины");
        CartPage cartPage = homePage.header().clickCartFromLobbyButton();
        Assert.assertTrue(cartPage.isEmpty(), "Корзина должна быть пустой");
    }

    @Test(priority = 9)
    public void testCatalogButton() {
        LoggerUtil.logInfo("Тест: Проверка кнопки каталога");
        homePage.catalog().openCatalog();
        Assert.assertTrue(homePage.catalog().isCatalogMenuDisplayed(),
                "Меню каталога не отображается");
    }

    @Test(priority = 10)
    public void testHeaderElements() {
        LoggerUtil.logInfo("Тест: Проверка элементов хедера");
        Assert.assertTrue(homePage.header().isLoginButtonDisplayed(),
                "Кнопка входа не отображается");
        Assert.assertTrue(homePage.header().isCartButtonDisplayed(),
                "Кнопка корзины не отображается");
        Assert.assertTrue(homePage.search().isSearchInputDisplayed(),
                "Поле поиска не отображается");
    }
}