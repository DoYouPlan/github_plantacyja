package ru.mantis.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ru.mantis.app.AppManager;

public class TestBase {

    protected final AppManager app = new AppManager();

    @BeforeMethod(alwaysRun = true)
    public void setUp() throws Exception {
     // System.setProperty("webdriver.chrome.driver", "path to chromedriver");
        app.login("admin", "secret", BrowserType.CHROME);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() throws Exception {
        app.logout();
    }

}
