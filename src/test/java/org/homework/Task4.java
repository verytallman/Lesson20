package org.homework;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

//(*) написать тест который может проверить какой статус код возвращает страница Features

public class Task4 extends BaseTestHomeWork {
    @Test
    public void responseCodeCheck() {

        try {
            webDriver.get("https://www.gurock.com");
            WebElement featuresButton = webHelpers.findElement(webDriver, By.xpath("//li/a[contains(text(),'Features')]"));
            webHelpers.scrollToElement(webDriver, featuresButton);
            featuresButton.click();
            String featuresLink = webDriver.getCurrentUrl();
            HttpURLConnection c = (HttpURLConnection) new URL(featuresLink).openConnection();
            c.connect();
            c.setRequestMethod("GET");
            System.out.println(c.getResponseCode());
            if (c.getResponseCode() == 403) {
                System.out.println("Forbidden " + c.getResponseCode() + " \"Запрещено\". " +
                        "У клиента нет прав доступа к содержимому, поэтому сервер отказывается дать надлежащий ответ. ");
            } else if (c.getResponseCode() == 200) {
                System.out.println(c.getResponseCode()+" OK — успешный запрос.");
            }

        } catch (IOException e) {

        }
    }
}
