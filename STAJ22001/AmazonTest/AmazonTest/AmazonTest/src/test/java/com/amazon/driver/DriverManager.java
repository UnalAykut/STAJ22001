package com.amazon.driver;


import org.openqa.selenium.WebDriver;


import java.time.Duration;


public class DriverManager {
    private static WebDriver driver;

    public static WebDriver getDriver(String browser){
        if(driver==null){
            driver= WebDriverFactory.createDriver(browser);
        }
        return driver;
    }

    public static void quitDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }



}
