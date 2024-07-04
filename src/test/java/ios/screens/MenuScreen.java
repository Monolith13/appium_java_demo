package ios.screens;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;

import static drivers.IOSDriverManager.getDriver;

public class MenuScreen {
    private WebElement homeTab() {
        return getDriver().findElement(AppiumBy.accessibilityId("TabBarAccessibility.mordaTab"));
    }

    private WebElement catalogTab() {
        return getDriver().findElement(AppiumBy.accessibilityId("TabBarAccessibility.catalogTab"));
    }

    private WebElement foodTab() {
        return getDriver().findElement(AppiumBy.accessibilityId("???"));
    }

    private WebElement wishListTab() {
        return getDriver().findElement(AppiumBy.accessibilityId("TabBarAccessibility.wishlistTab"));
    }

    private WebElement cartTab() {
        return getDriver().findElement(AppiumBy.accessibilityId("TabBarAccessibility.cartTab"));
    }

    private WebElement profileTab() {
        return getDriver().findElement(AppiumBy.accessibilityId("TabBarAccessibility.profileTab"));
    }

    public void clickByHomeTab() {
        homeTab().click();
    }

    public void clickBySearchTab() {
        catalogTab().click();
    }

    public void clickByFoodTab() {
        foodTab().click();
    }

    public void clickByLikesTab() {
        wishListTab().click();
    }

    public void clickByCartTab() {
        cartTab().click();
    }

    public void clickByProfileTab() {
        profileTab().click();
    }
}
