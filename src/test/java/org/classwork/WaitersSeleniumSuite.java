package org.classwork;

import org.testng.annotations.Test;

public class WaitersSeleniumSuite {
    @Test
    public void threadSleep(){

        try {
            Thread.sleep(200);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
