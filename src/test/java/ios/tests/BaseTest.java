package ios.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static drivers.IOSDriverManager.createIOSDriver;
import static drivers.IOSDriverManager.quitSession;

public class BaseTest {

    @BeforeClass(alwaysRun = true)
    public void testSetup() {
        createIOSDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        quitSession();
    }
}
