package org.homework;

import jdk.nashorn.internal.ir.IfNode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestClassFour extends BaseTestHomeWork {
    @Test
    public void threadSleep(){
        webDriver.get("https://www.gurock.com/");
        WebElement featuresButton = webHelpers.findElement(webDriver, By.xpath("//li/a[contains(text(),'Features')]"));
        webHelpers.scrollToElement(webDriver, featuresButton);
        featuresButton.click();
        String featuresLink = webDriver.getCurrentUrl();


        try {
            HttpURLConnection c = (HttpURLConnection) new URL(featuresLink).openConnection();
            System.out.println(c.getResponseCode());
            if (c.getResponseCode() == 403){
                System.out.println("The response code from website is "+c.getResponseCode()+" everything looks good.");
            } else if (c.getResponseCode() == 301)
                System.out.println("The response code from website is "+c.getResponseCode()+", please help!");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
