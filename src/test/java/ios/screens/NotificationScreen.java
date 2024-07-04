package ios.screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;

import static drivers.IOSDriverManager.getDriver;

public class NotificationScreen {

    private WebElement closeButton() {
        return getDriver().findElement(AppiumBy.accessibilityId("WelcomeOnboardingAccessibility.crossButton"));
    }

    private WebElement allowButton() {
        return getDriver().findElement(AppiumBy.accessibilityId("Включить уведомления"));
    }

    private WebElement remindLaterButton() {
        return getDriver().findElement(AppiumBy.accessibilityId("Не сейчас"));
    }

    private WebElement enableNotificationTextLabel() {
        return getDriver().findElement(AppiumBy.accessibilityId("Уведомления легко настраиваются"));
    }

    private WebElement descriptionTextLabel() {
        return getDriver().findElement(AppiumBy.accessibilityId("Можно оставить только нужные — например, статусы заказов. А всё лишнее отключить."));
    }

    public void pressCloseButton() {
        closeButton().click();
    }
}
