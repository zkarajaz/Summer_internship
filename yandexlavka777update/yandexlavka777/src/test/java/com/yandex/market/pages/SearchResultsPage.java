package com.yandex.market.pages;

import com.yandex.market.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.yandex.market.utils.Constants.MAX_PRICE;
import static com.yandex.market.utils.Constants.MIN_PRICE;

/**
 * Класс для работы со страницей результатов поиска.
 */
public class SearchResultsPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"/content/page/fancyPage/searchContent/searchTitleWithBreadcrumbs\"]/div/div/div/h1")
    private WebElement resultsHeader;

    @FindBy(xpath = "//*[@id=\"/content/page/fancyPage/searchContent/searchSerpStatic/content/content/lazyGenerator/initialContent\"]/div")
    private List<WebElement> priceElements;

    @FindBy(xpath = "(//div[@data-idx][contains(@class, 'iqmYz')])[3]")
    private WebElement firstProduct;

    @FindBy(xpath = "//*[@id=\"5md6ki2ysu4\"]/div[1]/div/div[3]/div/div[1]/div/a/div/div/span/span/span[1]")
    private List<WebElement> productTitles;

    @FindBy(xpath = "//*[@id=\"range-filter-field-glprice_25563_min\"]")
    private WebElement minPriceInput;

    @FindBy(xpath = "//*[@id=\"range-filter-field-glprice_25563_max\"]")
    private WebElement maxPriceInput;

    @FindBy(xpath = "(//span[contains(@class, 'ds-text_color_price-term')])[1]")
    private WebElement firstItemPriceElement;

    // Локатор для названия первого товара
    @FindBy(xpath = "(//span[@itemprop='name' and contains(@class, 'ds-text_color_text-primary')])[1]")
    private WebElement firstItemTitleElement;


    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isResultsHeaderDisplayed() {
        return wait.until(ExpectedConditions.visibilityOf(resultsHeader)).isDisplayed();
    }

    public void applyPriceFilter(int min, int max) {
        minPriceInput.sendKeys(String.valueOf(MIN_PRICE));
        maxPriceInput.sendKeys(String.valueOf(MAX_PRICE));
        wait.until(ExpectedConditions.stalenessOf(priceElements.get(0)));
    }

    public boolean arePricesInRange(int minPrice, int maxPrice) {
        wait.until(ExpectedConditions.visibilityOfAllElements(priceElements));
        return priceElements.stream()
                .map(element -> Integer.parseInt(element.getText().replaceAll("[^0-9]", "")))
                .allMatch(price -> price >= MIN_PRICE && price <= MAX_PRICE);
    }

    public void selectFirstProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(firstProduct)).click();
    }


    public boolean doProductTitlesContain(String keyword) {
        wait.until(ExpectedConditions.visibilityOfAllElements(productTitles));
        return productTitles.stream()
                .anyMatch(element -> element.getText().toLowerCase().contains(keyword.toLowerCase()));
    }


        // Метод для получения цены первого товара
        public int getFirstItemPrice() {
            wait.until(ExpectedConditions.visibilityOf(firstItemPriceElement));
            String priceText = firstItemPriceElement.getText()
                    .replaceAll("[^0-9]", "");
            return Integer.parseInt(priceText);
        }

        // Метод для получения названия первого товара
        public String getFirstItemTitle() {
            wait.until(ExpectedConditions.visibilityOf(firstItemTitleElement));
            return firstItemTitleElement.getText();
        }


}