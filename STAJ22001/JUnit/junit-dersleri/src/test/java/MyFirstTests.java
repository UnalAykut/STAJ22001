import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;

import java.sql.Driver;
import java.time.Duration;

public class MyFirstTests {
    static WebDriver driver;

   /* @BeforeClass
    public static void setUpTest(){ //static olmalı bllekten yeri önceden hazır olmalı içinde kulllanılacak paraametrede öyle olmalı
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }*/

    @BeforeAll
    public static void setUpTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @ParameterizedTest
    @ValueSource(strings = {"laptop", "telefon", "süpürge"})
    public void AmazonSearchTest(String searchTexts){
        driver.get( "https://www.amazon.com.tr" );
        String expectedDataLaptop= "3.000";
        String expectedDataTelefon="1.000";
        String expectedDataSupurge="10.000";
        WebElement searchButon= driver.findElement(By.id( "nav-search-submit-button" ));
        WebElement search= driver.findElement(By.id( "twotabsearchtextbox" ));
        search.sendKeys( searchTexts );
        searchButon.click();
        switch (searchTexts){
            case "laptop":{
                WebElement actualData= driver.findElement(By.xpath( "//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[1]" ));
                String actualDatatext=actualData.getText();
                Assert.assertTrue( actualDatatext.contains( expectedDataLaptop) );
                System.out.println(actualDatatext);
            }
            break;
            case "telefon": {
                WebElement actualData = driver.findElement( By.xpath( "//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[1]" ) );
                String actualDatatext = actualData.getText();
                Assert.assertTrue( actualDatatext.contains( expectedDataTelefon ) );
                System.out.println(actualDatatext);
            }
            break;
            case "süpürge": {
                WebElement actualData = driver.findElement( By.xpath( "//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[1]" ) );
                String actualDatatext = actualData.getText();
                Assert.assertTrue( actualDatatext.contains( expectedDataSupurge ) );
                System.out.println(actualDatatext);
            }
            break;
            }

        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
        }

         @AfterAll
         public static void tearDown(){
            driver.quit();
        }








    /*
    @Test
    public void LoginTest(){
        driver.get( "https://www.amazon.com.tr/" );
        String expectedDataLaptop="3.000";
        String expectedDataTelefon="1000";
        String actualDataLaptop;
        String actualDataTelelfon;
        WebElement searchInput= driver.findElement( By.id( "twotabsearchtextbox" ) );
        searchInput.sendKeys( "laptop" );
        WebElement searchButon=driver.findElement( By.id("nav-search-submit-button") );
        searchButon.click();
        WebElement searchResultLaptop=driver.findElement( By.xpath( "//*[@id=\"search\"]/span[2]/div/h1/div/div[1]/div/div/span[1]" ) );
        actualDataLaptop=searchResultLaptop.getText();
        Assert.assertTrue( actualDataLaptop.contains( expectedDataLaptop) );
    }
    */

/*
    @Test
    public void TestPractice(){
        driver.get( "https://practicetestautomation.com/practice-test-exceptions/" );
        WebElement addButton= driver.findElement(By.id( "add_btn" ));
        addButton.click();
        WebElement page=driver.findElement( By.xpath( "/html" ) );
        page.sendKeys( Keys.SPACE );
        WebElement inputElement = driver.findElement(By.id("row2"));
        WebElement text=driver.findElement( By.xpath( "//*[@id=\"row2\"]/input" ) );
        text.sendKeys( "ay" );
        driver.findElement( By.xpath( "//*[@id=\"save_btn\"]" ) ).click();
        WebElement kaydedildiMi= driver.findElement(By.xpath( "//*[@id=\"row2\"]/input" ));
        String kontrolText=kaydedildiMi.getText();
        // Giriş alanının görüntülendiğini doğrulayın
        if (inputElement.isDisplayed()) {
            System.out.println("Giriş alanı görüntüleniyor.");
        } else {
            System.out.println("Giriş alanı görüntülenmiyor.");
        }

        if (kontrolText.equals( "ay" )) {
            System.out.println("Kaydedildi.");
        } else {
            System.out.println("Kaydedilmedi.");
        }

    }*/
/*
    @AfterClass
    public static void tearDown(){

            driver.quit();

    }
*/
}
