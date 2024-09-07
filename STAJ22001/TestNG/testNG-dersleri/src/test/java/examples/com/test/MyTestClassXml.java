package examples.com.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class MyTestClassXml {
    WebDriver driver;
    /*
    xml kullanılarak daha düzenli bir şekilde test kontrolü ve çalıştırırlması yapılablir
    <include name="ahhahaha" bütün paketler içinden yanlızca ismi girilen paketin çalışmasını sağlar
    <exclude name"adafaf" ismi girilen paket hariç diğerlerini çalıştır demek

<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="TestNG Örnekleri">
    <test name="Temel Pratikler ">
    <groups>
        <run>
            <include name="Duman"></include>
            <exclude name="Regresyon"/>
        </run>
    </groups>
        <classes>
            <class name="examples.com.test.GroupsExamples"></class>
        </classes>
    </test>
</suite>



<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="TestNG Örnekleri">
    <parameter name="browser" value="chrome"></parameter>
    <parameter name="basUrl" value="https://www.google.com"></parameter>
    <test name="Parameter Example">
        <classes>
            <class name="examples.com.test.MyTestClass"></class>
        </classes>
    </test>

</suite>

//paralele aynı anda  testlerin çalışmasını sağlar
//thread-count="2" verilen değere göre kaç testin çalışcağını
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="TestNG Örnekleri" parallel="tests" thread-count="2">
    <test name="Test On Chrome">
        <parameter name="browser" value="chrome"></parameter>
        <classes>
            <class name="examples.com.test.MyTestClass"></class>
        </classes>
    </test>
    <test name="Test On Opera">
        <parameter name="browser" value="firefox"></parameter>
        <classes>
            <class name="examples.com.test.MyTestClass"></class>
        </classes>
    </test>

</suite>

//listenerlar sayseinde tarayıcıya ait daha anlaşılır test raporları oluşturulabilir
//çıktılar test-outpu dosyasına kaydedilşr ve tarayıcıda açılabilir
<!DOCTYPE suite SYSTEM "http://testng.org/testng-1.0.dtd">
<suite name="TestNG Örnekleri" parallel="tests" thread-count="2">
    <listeners>
        <listener class-name="org.testng.reporters.EmailableReporter2"></listener>
        <listener class-name="org.testng.reporters.XMLReporter"/>
    </listeners>
    <test name="Test On Chrome">
        <parameter name="browser" value="chrome"></parameter>
        <classes>
            <class name="examples.com.test.MyTestClass"></class>
        </classes>
    </test>
    <test name="Test On Edge">
        <parameter name="browser" value="edge"></parameter>
        <classes>
            <class name="examples.com.test.MyTestClass"></class>
        </classes>
    </test>

</suite>


    */


    //xmel dosyasından gelen Tarayıcılara göre işlem yapar
    @Parameters({"browser"})
    @BeforeClass()
    public void setUp(String browser){
        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver=new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 10 ));
    }

    @Test
    //dependsOnMethods=Test02 versilen method ismine bağlı olduğunu ve o çalıştıktan sonra çalışacağını gösterir.
    //invocationCount=3 tstin 3 kere tekrar etmesini sağlar
    //timeOut=2000 w saniyeden daha uzun sürerse hatalı test
    //priority önce hangisinin çalışacağı önce 0 a en yakın değer çalışır
    //eğer 1 testte priory varsa diğerlerinde yoksa alfabetik olarak çalışmaya devam eder
    public void Test01(){
        driver.get( "https://www.trendyol.com" );
        driver.findElement( By.xpath( "//*[@id=\"Combined-Shape\"]" ) ).click();
        driver.findElement( By.id( "onetrust-accept-btn-handler" ) ).click();
        WebElement searchWE= driver.findElement( By.xpath( "//input[@data-testid='suggestion']" ));
        WebElement searchButonWE=driver.findElement( By.xpath( "//i[@data-testid='search-icon']" ) );

        searchWE.sendKeys( "iphone" );
        searchButonWE.click();
        WebElement searchResultWE=driver.findElement( By.xpath( "//*[@id=\"search-app\"]/div/div[1]/div[2]/div[1]/div[1]/div" ) );
        Assert.assertTrue(searchResultWE.isDisplayed());
    }

    @Test
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

    @AfterClass
    public void exit(){
        driver.quit();
    }
}
