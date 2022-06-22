package ru.app;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

public class AppManager {
    private final StringBuffer verificationErrors = new StringBuffer();
    public WebDriver driver;
    private String baseUrl;
    private JavascriptExecutor js;
    // private static WebDriver driver = new ChromeDriver();
    private boolean acceptNextAlert = true;

    public void login(String UserName, String Password, String browtype) {
        String browser = browtype;
        if(browser == BrowserType.CHROME){
            driver = new ChromeDriver();
        }else if(browser == BrowserType.IE){
            driver = new InternetExplorerDriver();
        }else if(browser == BrowserType.OPERA){
            driver = new OperaDriver();
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        js = (JavascriptExecutor) driver;
        driver.get("http://localhost/addresbook/www/");
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(UserName);
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(Password);
        driver.findElement(By.xpath("//input[@value='\u0412\u043E\u0439\u0442\u0438']")).click();
        driver.findElement(By.linkText("\u0413\u0440\u0443\u043f\u043f\u044b")).click();
    }
    public void LoadInfo(String Text) {
        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys(Text);
        driver.findElement(By.name("group_header")).click();
        if (!By.name("group_header").equals("null")) {
            driver.findElement(By.name("group_header")).sendKeys("fuck");
        }
        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys(Text);
    }
    public void logout() {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
          fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
      try {
        driver.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }

    private boolean isAlertPresent() {
      try {
        driver.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }

    private String closeAlertAndGetItsText() {
      try {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        if (acceptNextAlert) {
          alert.accept();
        } else {
          alert.dismiss();
        }
        return alertText;
      } finally {
        acceptNextAlert = true;
      }
    }
}
