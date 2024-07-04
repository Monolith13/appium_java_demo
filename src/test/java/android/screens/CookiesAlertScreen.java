package android.screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;

import static drivers.AndroidDriverManager.getDriver;

public class CookiesAlertScreen {

    private WebElement skipButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ru.beru.android:id/negativeButton\")"));
    }

    private WebElement gotItButton() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ru.beru.android:id/positiveButton\")"));
    }

    private WebElement titleText() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Cookie files\")"));
    }

    private WebElement descriptionText() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ru.beru.android:id/textView\")"));
    }

    public void pressSkipButton() {
        skipButton().click();
    }

    public void pressGotItButton() {
        gotItButton().click();
    }


}
