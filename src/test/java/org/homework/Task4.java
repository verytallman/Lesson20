package org.homework;



import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

//(*) написать тест который может проверить какой статус код возвращает страница Features

public class Task4 extends BaseTestHomeWork {

    @Test
    public void responseCodeCheck() {
        try {
            webDriver.get("https://www.ideracorp.com/legal/Gurock");
            String featuresLink = webDriver.getCurrentUrl();
            HttpURLConnection c = (HttpURLConnection) new URL(featuresLink).openConnection();
            c.setRequestMethod("GET");
            c.connect();
            System.out.println(webDriver.getCurrentUrl());
            System.out.println(c.getResponseCode());
            if (c.getResponseCode() == 403) {
                System.out.println("Forbidden " + c.getResponseCode() + " \"Запрещено\". " +
                        "У клиента нет прав доступа к содержимому, поэтому сервер отказывается дать надлежащий ответ. ");
            } else if (c.getResponseCode() == 200) {
                    System.out.println(c.getResponseCode()+" OK — успешный запрос.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
