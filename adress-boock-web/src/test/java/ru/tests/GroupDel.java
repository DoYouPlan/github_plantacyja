package ru.tests;


import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class GroupDel extends TestBase {

    @Test(priority = 1)
    public void testGroupDeleteTestCase() throws Exception {
        app.driver.findElement(By.name("selected[]")).click();
        app.driver.findElement(By.name("delete")).click();
        app.driver.findElement(By.linkText("group page")).click();
        app.logout();
                 }
}