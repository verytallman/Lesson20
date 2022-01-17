package org.classwork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.Driver;
import java.time.Duration;


public class BaseTest {
    WebDriver driver;

    @BeforeClass
    public void driverInt(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    @AfterClass
    public void driverClose(){
        driver.close();
    }

}
