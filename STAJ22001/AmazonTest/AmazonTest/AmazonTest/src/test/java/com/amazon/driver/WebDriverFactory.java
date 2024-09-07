package com.amazon.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class WebDriverFactory {
    public static WebDriver createDriver(String browser){
        WebDriver driver;
        // Eğer browser parametresi null veya boşsa, varsayılan olarak Chrome kullanılır.
        if (browser == null || browser.isEmpty()) {
            browser = "chrome";
        }
        switch (browser.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
                break;
            default:
                throw new IllegalArgumentException("Browser type not supported: " + browser);
        }
        //Tarayıcıyı tam ekran yapmak.(maksimize etmek)
        driver.manage().window().maximize();
        // Genel bekleme süresi ayarlama (Implicit Wait)
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds(10));

        return driver;
    }
}
