package drivers;

import static server.AppiumServerManager.startServer;
import static server.AppiumServerManager.stopServer;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.time.Duration;

public class AndroidDriverManager {
    private static final String                     APP_PATH = String.valueOf (
            Path.of (System.getProperty ("user.dir"), "/src/test/resources/app", "ru.beru.android.apk"));
    private static final ThreadLocal<AndroidDriver> DRIVER   = new ThreadLocal<> ();
    private static final Logger                     LOG      = LogManager.getLogger ("DriverManager.class");

    public static void createAndroidDriver () {
        startServer ("android");

        try {
            setDriver (new AndroidDriver (new URL ("http://127.0.0.1:4723/wd/hub"),uiAutomator2OptionsBasic()));
        } catch (final MalformedURLException e) {
            throw new RuntimeException ("Invalid Appium server URL", e);
        }
        setupDriverTimeouts ();
    }

    public static AndroidDriver getDriver () {
        return AndroidDriverManager.DRIVER.get ();
    }

    public static void quitSession () {
        if (null != DRIVER.get ()) {
            LOG.info ("Closing the driver...");
            getDriver ().quit ();
            DRIVER.remove ();
            stopServer ();
        }
    }

    private static void setDriver (final AndroidDriver driver) {
        AndroidDriverManager.DRIVER.set (driver);
    }

    private static void setupDriverTimeouts () {
        getDriver ().manage ()
                .timeouts ()
                .implicitlyWait (Duration.ofSeconds (17));
    }

    private static UiAutomator2Options uiAutomator2OptionsBasic () {

        final UiAutomator2Options uiAutomator2Options;
        uiAutomator2Options = new UiAutomator2Options ().setAvd ("Pixel8_API33")
                .setAvdLaunchTimeout (Duration.ofSeconds (300))
                .setAvdReadyTimeout (Duration.ofSeconds (100))
                .setDeviceName ("Pixel8_API33")
                .setAutomationName (AutomationName.ANDROID_UIAUTOMATOR2)
                .setAutoGrantPermissions(true)
                .setFullReset(true)
                .setPlatformVersion("13.0")
                .setAppPackage("ru.beru.android")
                .setApp(APP_PATH)
                .setIgnoreHiddenApiPolicyError(true)
                .setAppWaitActivity("ru.yandex.market.ui.splash.MarketSplashActivity");

        return uiAutomator2Options;
    }

}