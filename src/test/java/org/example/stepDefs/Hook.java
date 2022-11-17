package org.example.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hook {
    public static WebDriver webDriver;
    @Before
    public static void OpenBrowser()
    {
        String chromePath=System.getProperty("user.dir")+"\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver",chromePath);
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.get("https://demo.nopcommerce.com/");
    }
    @After
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        webDriver.close();
    }


}