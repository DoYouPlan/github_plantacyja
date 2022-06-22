package ru.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.Test;

public class TestGroupModification extends TestBase{
    @Test (priority = 0)
    public void TestTestGroupModification(){
        app.login("admin","secret", BrowserType.CHROME);
        app.driver.findElement(By.name("selected[]")).click();
        app.driver.findElement(By.name("edit")).click();
        app.LoadInfo( "test");
        app.driver.findElement(By.name("update")).click();
        app.driver.findElement(By.linkText("group page")).click();
        app.logout();

    }



}
