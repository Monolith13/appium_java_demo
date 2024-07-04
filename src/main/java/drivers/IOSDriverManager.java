package drivers;

import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.nio.file.Path;
import java.time.Duration;

import static server.AppiumServerManager.*;

public class IOSDriverManager {
    private static final ThreadLocal<io.appium.java_client.ios.IOSDriver> DRIVER = new ThreadLocal<>();
    private static final Logger LOG = LogManager.getLogger("DriverManager.class");
    public static io.appium.java_client.ios.IOSDriver getDriver() {
        return IOSDriverManager.DRIVER.get();
    }
    private static void setDriver(io.appium.java_client.ios.IOSDriver driver) {
        IOSDriverManager.DRIVER.set(driver);
    }
    private static final String APP_PATH = String.valueOf (
            Path.of (System.getProperty ("user.dir"),
                    "/src/test/resources/app",
                    "ru.yandex.blue.market.app")
    );

    private static XCUITestOptions xcuiTestOptions() {
        return new XCUITestOptions()
                .setAutomationName(AutomationName.IOS_XCUI_TEST)
                .setNewCommandTimeout(Duration.ofSeconds(60))
                .setUdid("// INSERT UDID OF YOUR DEVICE //")
                .setUsePrebuiltWda(false)
                .setUpdatedWdaBundleId("com.facebook.WebDriverAgentRunner.kek")
                .setBundleId("ru.yandex.blue.market")
                .setApp(APP_PATH)
                .setFullReset(true)
                .setAutoAcceptAlerts(true);
    }

    public static void quitSession() {
        if (null != DRIVER.get()) {
            LOG.info("Closing the driver...");
            getDriver().quit();
            DRIVER.remove();
            stopServer();
        }
    }

    public static void createIOSDriver() {
        startServer("ios");
        setDriver(new io.appium.java_client.ios.IOSDriver(getService().getUrl(), xcuiTestOptions()));
        setupDriverTimeouts();
    }

    private static void setupDriverTimeouts() {
        getDriver().manage()
                .timeouts()
                .implicitlyWait(Duration.ofSeconds(17));
    }
}
