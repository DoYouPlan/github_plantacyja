package ru.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import ru.app.AppManager;

public class TestBase {

    protected final AppManager app = new AppManager();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
     // System.setProperty("webdriver.chrome.driver", "path to chromedriver");
        app.login("admin", "secret", BrowserType.CHROME);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        app.logout();
    }

}
