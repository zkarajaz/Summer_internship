package com.yandex.market.pages;

import com.yandex.market.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.yandex.market.utils.LoggerUtil;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CartPage extends BasePage {

    // Основной XPath для количества товаров
    @FindBy(xpath = "//*[@id=\"/content/page/fancyPage/@chef\\/cart\\/CartLayout/@chef\\/cart\\/ChefCartList/@light\\/SlotsTheCreator/MARKET/@chef\\/cart\\/ChefCartHeader/@chef\\/Cart\\/CartHeader\\/Title\"]/div/div[1]/div")
    private WebElement cartItemCount;

    // Локатор кнопки удаления
    @FindBy(xpath = "//*[@id=\"/content/page/fancyPage/@chef\\/cart\\/CartLayout/@chef\\/cart\\/ChefCartList/@light\\/SlotsTheCreator/MARKET/@chef\\/Cart\\/CartHeader\\/RemoveButton\"]/div/button/span/span")
    private WebElement removeButton;
    @FindBy(xpath = "//*[@id=\"/content/page/fancyPage/@chef\\/cart\\/CartLayout/@chef\\/cart\\/ChefCartList/@light\\/SlotsTheCreator/MARKET/@chef\\/Cart\\/CartHeader\\/RemoveButton\"]/div[2]/div[2]/div/div[2]/button[2]")
    private WebElement submitRemove;
    // Локатор сообщения о пустой корзине
    @FindBy(xpath = "//*[@id=\"/content/page/fancyPage/@chef\\/cart\\/CartLayout/@chef\\/cart\\/ChefCartList/@light\\/SlotsTheCreator/@chef\\/cart\\/ChefCartEmptyLayout/empty_cart_agitation/empty_cart_agitation\"]/div/div[1]/span[1]")
    private WebElement emptyCartMessage;

    // Локатор контейнеров товаров
    @FindBy(xpath = "//*[@id=\"/content/page/fancyPage/searchContent/searchSerpStatic/content/content/lazyGenerator/initialContent/serpLayoutItem_666635/serpEntity17514990531420802345427001/incutConstructor/content/content/slot-f127gfkjsru/addToCartButton\"]/div/div/button/span")
    private WebElement cartItem;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean isItemInCart() {
        try {
            String countText = wait.until(ExpectedConditions.visibilityOf(cartItemCount)).getText();
            int count = Integer.parseInt(countText.replaceAll("[^0-9]", ""));
            LoggerUtil.logInfo("Текущее количество товаров в корзине: " + count);
            return count > 0;
        } catch (Exception e) {
            LoggerUtil.logError("Не удалось проверить количество товаров: " + e.getMessage());
            return false;
        }
    }


    public void removeItem() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(removeButton)).click();
            wait.until(ExpectedConditions.elementToBeClickable(submitRemove)).click();
            // Ожидаем обновления корзины
            TimeUnit.SECONDS.sleep(1);
            wait.until(ExpectedConditions.visibilityOf(emptyCartMessage));
        } catch (Exception e) {
            throw new RuntimeException("Failed to remove item from cart", e);
        }
    }

    public boolean isEmpty() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(emptyCartMessage)).isDisplayed();
        } catch (Exception e) {
            try {
                String countText = cartItemCount.getText().replaceAll("\\D", "");
                return countText.isEmpty() || Integer.parseInt(countText) == 0;
            } catch (Exception ex) {
                return true;
            }
        }
    }

    public int getCartItemsCount() {

            if (isItemInCart()) {
                WebElement countElement = wait.until(ExpectedConditions.visibilityOf(cartItemCount));
                String countText = countElement.getText().replaceAll("\\D", "");
                return Integer.parseInt(countText);
            }
            return 0;
        }
    }
