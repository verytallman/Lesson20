package org.classwork;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class WaitersSeleniumSuite extends BaseTestClassWork {
    @Test
    public void threadSleep(){
        driver.get("https://www.gurock.com/testrail/tour/modern-test-management");

//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        wait
//                .until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='SubmitCreate']")));

        try {
            HttpURLConnection c = (HttpURLConnection) new URL("https://www.gurock.com/testrail/tour/modern-test-management")
                            .openConnection();

            System.out.println(c.getResponseCode());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
