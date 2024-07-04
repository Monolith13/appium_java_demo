package android.screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;

import static drivers.AndroidDriverManager.getDriver;

public class NotificationScreen {

    private WebElement closeButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ru.beru.android:id/closeButton\")"));
    }

    private WebElement allowButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ru.beru.android:id/topButton\")"));
    }

    private WebElement remindLaterButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ru.beru.android:id/bottomButton\")"));
    }

    private WebElement enableNotificationTextLabel() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ru.beru.android:id/titleTextView\")"));
    }

    private WebElement descriptionTextLabel() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ru.beru.android:id/contentTextView\")"));
    }

    public void pressCloseButton() {
        closeButton().click();
    }
}
