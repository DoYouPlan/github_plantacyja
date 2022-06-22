package ru.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import ru.model.DataObj;

public class UntitledTestCase extends TestBase {

  @Test(priority = -1)
  public void testUntitledTestCase() throws Exception {
    GreateNewGroup();
    LoadInfo(new DataObj("test", "test1", "test2"));
    GroupSubmitCreations();
    ReturnGroupPage();
    app.logout();

  }

  private void ReturnGroupPage() {
      app.driver.findElement(By.linkText("group page")).click();
  }

    private void GroupSubmitCreations() {
    app.driver.findElement(By.name("submit")).click();
  }

    public void LoadInfo(DataObj dataObj) {
    app.driver.findElement(By.name("group_name")).click();
    app.driver.findElement(By.name("group_name")).clear();
    app.driver.findElement(By.name("group_name")).sendKeys(dataObj.GroupName());
    app.driver.findElement(By.name("group_header")).click();
    app.driver.findElement(By.name("group_header")).clear();
    app.driver.findElement(By.name("group_header")).sendKeys(dataObj.GroupHeadText());
    app.driver.findElement(By.name("group_footer")).click();
    app.driver.findElement(By.name("group_footer")).clear();
    app.driver.findElement(By.name("group_footer")).sendKeys(dataObj.GroupFootText());
  }

  private void GreateNewGroup() {
    app.driver.findElement(By.name("new")).click();
  }

}
