package com.amazon.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Utils {
    private static final int TIMEOUT=10;

    public static void waitForSeconds(int seconds) throws InterruptedException {
        // Belirtilen süre kadar bekler (milisaniye cinsinden)
        Thread.sleep(seconds * 1000);
    }
    public static WebElement waitForElementToBeClickable(WebDriver driver, WebElement element) {
        // Belirli bir süre boyunca elementin tıklanabilir olmasını bekler
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until( ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForElementToBeVisible(WebDriver driver, WebElement element) {
        // Belirli bir süre boyunca elementin görünür olmasını bekler
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForElementPresence(WebDriver driver, By locator) {
        // Belirli bir süre boyunca belirtilen lokasyonda elementin varlığını bekler
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        // Sayfa üzerinde belirli bir elemente kaydırma yapar
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public static void scrollToElementUntilVisible(WebDriver driver, WebElement element) throws InterruptedException {
        // Element görünür olana kadar sayfada aşağı doğru kaydırma yapar
        while (!element.isDisplayed()) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,250)");
            waitForSeconds(1);
        }
    }

    public static boolean nameControl(String expectedData,String actualData){
        if(expectedData.equals( actualData )){
            return true;
        }else {
        return false;
        }
    }


}
