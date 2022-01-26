package org.homework;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

// для ссылки Legal, перейти на следующее окно,
// кликнуть на одну из внутренних таб, проверить что отобразился необходимый контент,
// вернуться на предидущее окно и кликнуть на кнопку Subscribe

public class Task3 extends BaseTestHomeWork {

    @Test
    public void switchTabCheck() {
        webDriver.get("https://www.gurock.com");
        webDriver.manage().window().maximize();
        String mainTab = webDriver.getWindowHandle();
        WebElement legalLink = webHelpers.findElement(webDriver, By.xpath("//a[contains(text(),'Legal')]"));
        webHelpers.scrollToElement(webDriver, legalLink);
        legalLink.click();
        for (String tab:webDriver.getWindowHandles()) {
            webDriver.switchTo().window(tab);
        }
        String legalLinkSite = "https://www.ideracorp.com/legal/Gurock";
        Assert.assertEquals(webDriver.getCurrentUrl(), legalLinkSite);
        WebElement policiesAndProceduresTab = webDriver.findElement(By.xpath("//a[@id='ui-id-3']"));
        policiesAndProceduresTab.click();
        WebElement exportCompliencePolicy = webDriver.findElement(By.xpath("//a[contains(text(),'Export Compliance Policy')]"));
        WebElement dataStoragePolicy = webDriver.findElement(By.xpath("//a[contains(text(),'Data Storage Policy')]"));
        Assert.assertEquals(webDriver.findElement(By.xpath("//a[contains(text(),'Export Compliance Policy')]")).isDisplayed(),
                    exportCompliencePolicy.isDisplayed());
        Assert.assertEquals(webDriver.findElement(By.xpath("//a[contains(text(),'Data Storage Policy')]")).isDisplayed(),
                    dataStoragePolicy.isDisplayed());
        webDriver.switchTo().window(mainTab);
        WebElement subscribeButton = webDriver.findElement(By.xpath("//div[@class='col-6 col-sm-6 col-md-4 col-lg-3 gk-footer-menu-item-first']/a[@role='button']"));
        webHelpers.scrollToElement(webDriver, subscribeButton);
        subscribeButton.click();
        String desiredURl = "https://www.gurock.com/testrail/newsletter/";
        Assert.assertEquals(webDriver.getCurrentUrl(), desiredURl);
    }
}