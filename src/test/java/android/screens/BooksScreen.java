package android.screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;

import static drivers.AndroidDriverManager.getDriver;

public class BooksScreen {

    private WebElement firstBookTile() {
        return getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"ru.beru.android:id/image\").instance(0)"));
    }

    public void clickByFirstBookTile() {
        firstBookTile().click();
    }
}
