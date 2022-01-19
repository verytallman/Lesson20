package org.homework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.classwork.WebHelpers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;


public class BaseTestHomeWork {
    protected WebHelpers webHelpers = new WebHelpers();
    WebDriver webDriver;

    @BeforeClass
    public void driverInt(){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    @AfterClass
    public void driverClose(){
        webDriver.close();
    }

}
