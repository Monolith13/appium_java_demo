package android.screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;

import static drivers.AndroidDriverManager.getDriver;

public class CartScreen {

    private WebElement emptyCartTextLabel() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Корзина пустая\")"));
    }

    private WebElement emptyCartDescriptionTextLabel() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().textContains(\"Чтобы увидеть добавленные\")"));
    }

    public Boolean assertEmptyCartTextLabel() {
        return emptyCartTextLabel().isDisplayed();
    }

    public Boolean assertEmptyCartDescriptionTextLabel() {
        return emptyCartDescriptionTextLabel().isDisplayed();
    }
}
