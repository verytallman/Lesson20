package org.homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Task2 extends BaseTestHomeWork {
    @Test
    public void aboutGurockLinkCheck(){
        webDriver.get("https://www.gurock.com");
        WebElement aboutGurockLink = webHelpers.findElement(webDriver, By.xpath("//a[contains(text(),'About Gurock')]"));
        webHelpers.scrollToElement(webDriver, aboutGurockLink);
        aboutGurockLink.click();
        WebElement desiredText1 = webDriver.findElement(By.xpath("//h2[contains(text(),'Outstanding customer satisfaction')]"));
        Assert.assertEquals(webDriver.findElement(By.xpath("//h2[contains(text(),'Outstanding customer satisfaction')]")).isDisplayed(),
                desiredText1.isDisplayed());
        WebElement desiredText2 = webDriver.findElement(By.xpath("//a[contains(text(),'2021 G2 Grid for Test Management and Software Test')]"));
        Assert.assertEquals(webDriver.findElement(By.xpath("//a[contains(text(),'2021 G2 Grid for Test Management and Software Test')]")).isDisplayed(),
                desiredText2.isDisplayed());
    }

    @Test
    public void jobsLinkCheck(){
        webDriver.get("https://www.gurock.com");
        WebElement jobsLink = webHelpers.findElement(webDriver, By.xpath("//a[contains(text(),'Jobs')]"));
        webHelpers.scrollToElement(webDriver, jobsLink);
        jobsLink.click();
        WebElement desiredText1 = webDriver.findElement(By.xpath("//h2[contains(text(),'Browse Open Positions')]"));
        Assert.assertEquals(webDriver.findElement(By.xpath("//h2[contains(text(),'Browse Open Positions')]")).isDisplayed(),
                desiredText1.isDisplayed());
        WebElement browseOpenButton = webDriver.findElement(By.xpath("//a[@class='btn btn-medium btn-outline-blue']"));
        Assert.assertEquals(webDriver.findElement(By.xpath("//a[@class='btn btn-medium btn-outline-blue']")).isDisplayed(),
                browseOpenButton.isDisplayed());
    }

    @Test
    public void сontactLinkCheck(){
        webDriver.get("https://www.gurock.com");
        WebElement contactLink = webHelpers.findElement(webDriver,
                By.xpath("//li[@class='menu-item menu-item-type-custom menu-item-object-custom menu-item-706']/a[contains(text(),'Contact')]"));
        webHelpers.scrollToElement(webDriver, contactLink);
        contactLink.click();
        WebElement desiredTelephoneNumber = webDriver.findElement(By.xpath("//span[contains(text(),' +49-6103-599-6099')]"));
        Assert.assertEquals(webDriver.findElement(By.xpath("//span[contains(text(),' +49-6103-599-6099')]")).isDisplayed(),
                desiredTelephoneNumber.isDisplayed());
        WebElement desiredText = webDriver.findElement(By.xpath("//span[contains(text(),'HRB53083 Offenbach am Main')]"));
        Assert.assertEquals(webDriver.findElement(By.xpath("//span[contains(text(),'HRB53083 Offenbach am Main')]")).isDisplayed(),
                desiredText.isDisplayed());
    }

    @Test
    public void complianceLinkCheck(){
        webDriver.get("https://www.gurock.com");
        WebElement contactLink = webHelpers.findElement(webDriver, By.xpath("//a[contains(text(),'Compliance')]"));
        webHelpers.scrollToElement(webDriver, contactLink);
        contactLink.click();
        WebElement testRailText = webDriver.findElement(By.xpath("//span[contains(text()," +
                "'TestRail maintains compliance with SOC 2 auditing procedures and has received a SOC 2 Type 1 certification.')]"));
        Assert.assertEquals(webDriver.findElement(By.xpath("//span[contains(text()," +
                        "'TestRail maintains compliance with SOC 2 auditing procedures and has received a SOC 2 Type 1 certification.')]")),
                testRailText);
        WebElement aicpaLink = webDriver.findElement(By.xpath("//a[contains(text(),'AICPA')]"));
        Assert.assertEquals(webDriver.findElement(By.xpath("//a[contains(text(),'AICPA')]")),
                aicpaLink);
    }
}
