package org.classwork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverInit {
    private static WebDriver webDriver;

    private DriverInit(Browser browser){
        setWebDriver(browser);
    }

    public static WebDriver getWebDriver(Browser browser) {
        if (webDriver == null){
        new DriverInit(browser);
        }
        return webDriver;
    }

    private void setWebDriver(Browser browserName){

        String browser = "chrome";
        switch (browserName){
            case CHROME:
                webDriver = WebDriverManager.chromedriver().create();
                break;
            case FF:
                webDriver = WebDriverManager.firefoxdriver().create();
                break;
        }
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
    }

    public enum Browser{
        CHROME,
        FF
    }

}
