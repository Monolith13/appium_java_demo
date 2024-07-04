package android.screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;

import static drivers.AndroidDriverManager.getDriver;

public class MenuScreen {
    private WebElement homeTab() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ru.beru.android:id/icon\").instance(0)"));
    }

    private WebElement catalogTab() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ru.beru.android:id/icon\").instance(1)"));
    }

    private WebElement foodTab() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ru.beru.android:id/icon\").instance(2)"));
    }

    private WebElement likesTab() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ru.beru.android:id/icon\").instance(3)"));
    }

    private WebElement cartTab() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ru.beru.android:id/icon\").instance(4)"));
    }

    private WebElement profileTab() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ru.beru.android:id/icon\").instance(5)"));
    }

    public void clickByHomeTab() {
        homeTab().click();
    }

    public void clickByCatalogTab() {
        catalogTab().click();
    }

    public void clickByFoodTab() {
        foodTab().click();
    }

    public void clickByLikesTab() {
        likesTab().click();
    }

    public void clickByCartTab() {
        cartTab().click();
    }

    public void clickByProfileTab() {
        profileTab().click();
    }
}
