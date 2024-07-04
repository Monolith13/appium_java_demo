package android.tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import static drivers.AndroidDriverManager.createAndroidDriver;
import static drivers.AndroidDriverManager.quitSession;

public class BaseTest {

    @BeforeClass(alwaysRun = true)
    public void testSetup() {
        createAndroidDriver();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        quitSession();
    }
}
