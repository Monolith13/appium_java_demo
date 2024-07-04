package android.tests;

import static org.testng.Assert.assertTrue;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.TmsLink;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import android.screens.*;
import io.qameta.allure.Step;
import static io.qameta.allure.SeverityLevel.*;

public class BooksTests extends BaseTest {
    LoginScreen loginScreen = new LoginScreen();
    NotificationScreen notificationScreen = new NotificationScreen();
    CookiesAlertScreen cookiesAlertScreen = new CookiesAlertScreen();
    MenuScreen menuScreen = new MenuScreen();
    CatalogScreen catalogScreen = new CatalogScreen();
    BooksScreen booksScreen = new BooksScreen();
    CartScreen cartScreen = new CartScreen();

    @Step("Launch App and Skip Something")
    public void stepLaunchApp() {
        loginScreen.pressBackButton();
        notificationScreen.pressCloseButton();
        cookiesAlertScreen.pressSkipButton();
    }

    @Step("Assert cart screen is empty")
    public void stepAssertEmptyScreen() {
        assertTrue(cartScreen.assertEmptyCartTextLabel(), "Текстовка 'Корзина пустая' не найдена");
        assertTrue(cartScreen.assertEmptyCartDescriptionTextLabel(), "Текстовка 'Чтобы увидеть добавленные товары...' не найдена");
    }

    @Test
    @Severity(BLOCKER)
    @TmsLink("TEST-1")
    @Owner("Vlad")
    @Feature("Books")
    public void testAddBook() throws InterruptedException {
        stepLaunchApp();
        menuScreen.clickByCatalogTab();
        Thread.sleep(5000); //  added to reduce flakiness
        catalogScreen.scrollUntilBooksAndClick();
        booksScreen.clickByFirstBookTile();
        //TODO: Required anti-bot hack
    }

    @Test(enabled=false)
    @Severity(MINOR)
    @TmsLink("TEST-2")
    @Owner("Vlad")
    public void testAddRemoveBook() {
        loginScreen.pressBackButton();
        notificationScreen.pressCloseButton();
        cookiesAlertScreen.pressSkipButton();
        //TODO: Required anti-bot hack
    }

    @Test
    @Severity(CRITICAL)
    @TmsLink("TEST-3")
    @Owner("Vlad")
    @Feature("Cart")
    public void testEmptyCart() {
        stepLaunchApp();
        menuScreen.clickByCartTab();
        stepAssertEmptyScreen();
    }
}
