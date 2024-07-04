package android.screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;

import static drivers.AndroidDriverManager.getDriver;

public class CatalogScreen {

    private WebElement searchTextField() {
        return getDriver().findElement(AppiumBy.id("ru.beru.android:id/viewSearchAppBarLayoutInput"));
    }

    private WebElement magnifierButton() {
        return getDriver().findElement(AppiumBy.id("ru.beru.android:id/viewSearchAppBarLayoutSearchIcon"));
    }

    public void searchGoodsViaReaquest(String searchRequest) {
        searchTextField().click();
        searchTextField().sendKeys(searchRequest);
        magnifierButton().click();
    }

    public void scrollUntilBooksAndClick() {
        getDriver().findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Книги\"));"));
        getDriver().findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Книги\")")).click();
    }

}
