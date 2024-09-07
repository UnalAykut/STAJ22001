package examples.com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.sql.DriverManager;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MyTests {

    WebDriver driver;
    @BeforeClass()
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 10 ));
        }



    /*@Test(priority=1, timeOut=2000)
    //dependsOnMethods=Test02 versilen method ismine bağlı olduğunu ve o çalıştıktan sonra çalışacağını gösterir.
    //invocationCount=3 tstin 3 kere tekrar etmesini sağlar
    //timeOut=2000 w saniyeden daha uzun sürerse hatalı test
    //priority önce hangisinin çalışacağı önce 0 a en yakın değer çalışır
    //eğer 1 testte priory varsa diğerlerinde yoksa alfabetik olarak çalışmaya devam eder
    public void Test01(){
        driver.get( "https://www.trendyol.com" );
        driver.findElement(By.xpath( "//*[@id=\"Combined-Shape\"]" ) ).click();
        driver.findElement( By.id( "onetrust-accept-btn-handler" ) ).click();
        WebElement searchWE= driver.findElement( By.xpath( "//input[@data-testid='suggestion']" ));
        WebElement searchButonWE=driver.findElement( By.xpath( "//i[@data-testid='search-icon']" ) );

        searchWE.sendKeys( "iphone" );
        searchButonWE.click();
        WebElement searchResultWE=driver.findElement( By.xpath( "//*[@id=\"search-app\"]/div/div[1]/div[2]/div[1]/div[1]/div" ) );
        Assert.assertTrue(searchResultWE.isDisplayed());
        }

    @Test(enabled=false description="ihtiyaç yok")
    //enabled=false metodu devre dışı bırakır j uniteki ignore benzer
    //description not bırakmak için kullanılabilir
    public void Test02(){
        driver.findElement( By.xpath( "//div[@data-id='319789388']" ) ).click();
        List<String> tabs =new ArrayList<>(driver.getWindowHandles());
        if(tabs.size()>1){ driver.switchTo().window( tabs.get(1) );}
        try {
            Thread.sleep( Duration.ofSeconds( 5 ) );
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
        driver.findElement( By.xpath( "//*[@id=\"product-detail-app\"]/div/div[2]/div/div[2]/div[2]/div/div[1]/div[5]/button" ) ).click();
        try {
            Thread.sleep( Duration.ofSeconds( 5 ) );
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }

        WebElement actualData= driver.findElement(By.xpath( "//*[@id=\"product-detail-app\"]/div/div[2]/div/div[2]/div[2]/div/div[1]/div[2]/div/div/div[1]/h1/span" ));


        String marketDataText=actualData.getText();
        driver.findElement( By.xpath( "//*[@id=\"account-navigation-container\"]/div/div[2]" ) ).click();
        driver.findElement( By.xpath( "//*[@id=\"pb-container\"]/div/div[3]/div[3]/div/div[3]/div/div/div[3]/div/div/div/button" ) ).click();
        try {
            Thread.sleep( Duration.ofSeconds( 3 ) );
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
        WebElement expectedData=driver.findElement( By.xpath( "//*[@id=\"pb-container\"]/div/div[3]/div[3]/div/div[3]/a/p[1]" ) );
        String sepetDataText= expectedData.getText();
        Assert.assertEquals( marketDataText,sepetDataText );
    }
*/

/*
    //Genel Yapı
    @BeforeSuite
    public void test1(){
        System.out.println("1");
    }
    @BeforeTest
    public void test2(){
        System.out.println("2");
    }
    @BeforeClass
    public void test3(){
        System.out.println("3");
    }
    @BeforeGroups //grup tanımlanmadan çalışmaz
    public void test4(){
        System.out.println("4");
    }
    @BeforeMethod
    public void test5(){
        System.out.println("5");
    }
    @Test
    public void test6(){
        System.out.println("6");
    }
    @AfterMethod
    public void test7(){
        System.out.println("5");
    }
    @AfterGroups
    public void test8(){
        System.out.println("4");
    }
    @AfterClass
    public void test9(){
        System.out.println("3");
    }
    @AfterTest
    public void test10(){
        System.out.println("2");
    }
    @AfterSuite
    public void test11(){
        System.out.println("1");
    }
*/


}
