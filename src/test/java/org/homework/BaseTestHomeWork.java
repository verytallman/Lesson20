package org.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.classwork.WebHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.time.Duration;



public class BaseTestHomeWork {
    protected WebHelpers webHelpers = new WebHelpers();
    WebDriver webDriver;

    @BeforeClass
    public void driverInt(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
    }

    @AfterClass
    public void driverClose(){
        webDriver.quit();
    }

}
