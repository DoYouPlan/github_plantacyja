  package ru.mantis.app;

  import org.openqa.selenium.WebDriver;
  import org.openqa.selenium.chrome.ChromeDriver;
  import org.openqa.selenium.firefox.FirefoxDriver;
  import org.openqa.selenium.ie.InternetExplorerDriver;
  import org.openqa.selenium.remote.BrowserType;

  import java.io.File;
  import java.io.FileReader;
  import java.io.IOException;
  import java.util.Properties;
  import java.util.concurrent.TimeUnit;
  public class AppManager {
      private Properties properties;
      WebDriver wd;

      private String browser;

      public AppManager() {

          this.browser = browser;
          properties = new Properties();

      }

      public void init() throws IOException {
          String target = System.getProperty("target", "local");
          properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));

          if (browser.equals(BrowserType.FIREFOX)) {
              wd = new FirefoxDriver();
          } else if (browser.equals(BrowserType.CHROME)) {
              wd = new ChromeDriver();
          } else if (browser.equals(BrowserType.IE)) {
              wd = new InternetExplorerDriver();
          }
          wd.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
          wd.get(properties.getProperty("web.baseUrl"));

      }

      public void stop() {
          wd.quit();
      }

      public HttpSession newSession() {
        return  new HttpSession(this);
      }


      public String getProperty(String key) {
          return properties.getProperty(key);
      }

      public void login(String admin, String secret, String chrome) {
      }

      public void logout() {
      }
  }




//public class AppManager {
//   private final StringBuffer verificationErrors = new StringBuffer();
//   public WebDriver driver;
//   private String baseUrl;
// private JavascriptExecutor js;
// private static WebDriver driver = new ChromeDriver();
//  private boolean acceptNextAlert = true;

//public void login(String UserName, String Password, String browtype) {
//  String browser = browtype;
//if(browser == BrowserType.CHROME){
//  driver = new ChromeDriver();
// }else if(browser == BrowserType.IE){
//    driver = new InternetExplorerDriver();
// }else if(browser == BrowserType.OPERA){
//   driver = new OperaDriver();
// }
//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//js = (JavascriptExecutor) driver;

//  }
//  public void logout() {
///    driver.quit();
// String verificationErrorString = verificationErrors.toString();
//  if (!"".equals(verificationErrorString)) {
//  fail(verificationErrorString);
//   }
// }
