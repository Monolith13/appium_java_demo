package android.screens;

import io.appium.java_client.AppiumBy;

import org.openqa.selenium.WebElement;

import static drivers.AndroidDriverManager.getDriver;

public class LoginScreen {

    private WebElement emailTab() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Почта\")"));
    }

    private WebElement phoneTab() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Телефон\")"));
    }

    private WebElement backButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.Image\")"));
    }

    private WebElement loginButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Войти\")"));
    }

    public void pressBackButton() {
        backButton().click();
    }
}
