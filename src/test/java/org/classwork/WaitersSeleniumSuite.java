package org.classwork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class WaitersSeleniumSuite extends BaseTest {
    @Test
    public void threadSleep(){
        driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("somemail@gmail.com");
        driver.findElement(By.xpath("//button[@id='SubmitCreate']")).click();
        driver.findElement(By.xpath("//button[@id='submitAccount']")).isDisplayed();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='SubmitCreate']")));




    }

}
