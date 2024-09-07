package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.units.qual.A;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String baseUrl="https:/www.google.com";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 10 ) );
        /*baseUrl = "https://demo.guru99.com/test";

        driver.get( "https://www.hepsiburada.com/" );
        driver.findElement( By.id( "sec-overlay" ) );

        driver.getTitle();//sayfanın titleını getirir
        driver.getCurrentUrl();//sayfanın url adresi
        driver.getPageSource();//sayfanın kaynak kodununu getirir
        driver.getWindowHandle();//sekmeinin idsinin verir
        driver.getWindowHandles();//sekmenin idlerinin dizi olarak verir
        driver.navigate().to( "https:/www.facebook.com" );
        driver.manage().window().maximize();//full ekran yapar
        driver.manage().window().setSize( new Dimension( 200,300 ) );
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 10 ) );
        driver.manage().window().fullscreen();*/


        /* //Loginn Testing
        String baseUrl ="https://demo.guru99.com/test/login.html";
        driver.get( baseUrl );
        WebElement email= driver.findElement(By.id( "email" )); //id ye göre bulma
        WebElement password= driver.findElement(By.id( "passwd" ));
        WebElement button= driver.findElement(By.id(  "SubmitLogin"));
        email.sendKeys( "aykut17@gmail.com" ); //değer gönderme doldurma denebilir
        password.sendKeys( "1234" );
        button.click();// butona tıkla
        *//*
        //RadioButon Testing
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 10 ) );
        String baseUrl = "https://demo.guru99.com/test/radio.html";
        driver.get( baseUrl );
        WebElement radio1 = driver.findElement(By.id( "vfb-7-1" ));
        radio1.click();
        try {
            Thread.sleep( 2000 );//2 saniye bekle
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
        WebElement radio2 = driver.findElement(By.id( "vfb-7-2" ));
        radio2.click();
        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
        WebElement radio3 = driver.findElement(By.id( "vfb-7-3" ));
        radio3.click();
        // CheckBox testing
        String pageUrl ="/radio.html";
        driver.get( baseUrl+pageUrl );
        WebElement checkBox1= driver.findElement(By.id( "vfb-6-0" ));
        WebElement checkBox2= driver.findElement(By.id( "vfb-6-1" ));
        WebElement checkBox3= driver.findElement(By.id( "vfb-6-2" ));
        WebElement[] checkBox={checkBox1,checkBox2,checkBox3};
        for (WebElement i:checkBox) {
            if(i.isSelected()){
                System.out.println("CheckBox seçili");
            }
            else {
                i.click();
                try {
                    Thread.sleep( 2000 );
                } catch (InterruptedException e) {
                    throw new RuntimeException( e );
                }
            }
        }
*/
       /* String baseUrl="https://www.hepsiburada.com/";
        driver.get( baseUrl );
        WebElement hepsiBuradaLogo = driver.findElement(By.xpath( "//a[@title='Hepsiburada']" ));
        hepsiBuradaLogo.click();*/

        /*String baseUrl="https://www.hepsiburada.com/";
        driver.get( baseUrl );
        WebElement sepetimButon=driver.findElement( By.xpath( "//a[@class='sf-OldMyAccount-MjrNQp_LLdAaN1g0xvSz sf-OldMyAccount-VcxldoRSjUmlWBLJaTly' and @href='https://checkout.hepsiburada.com/sepetim']" ) );
        sepetimButon.click();
        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
        WebElement hepsiBuradaLogo = driver.findElement(By.xpath( "//a[@title='Hepsiburada']" ));
        hepsiBuradaLogo.click();
         */
       /* driver.get( baseUrl+"/link.html" );
        List<WebElement> baglantilar= driver.findElements( By.linkText( "click here" ) );
        WebElement baglanti=baglantilar.get( 1 );
        baglanti.click();

        */
        /*
        driver.get( baseUrl+"/link.html" );
        List<WebElement> baglantilar= driver.findElements( By.partialLinkText("here") );
        WebElement baglanti=baglantilar.get( 1 );
        baglanti.click();
         */
        /*
        driver.get( baseUrl+"/newtours/register.php" );
        WebElement country = driver.findElement(By.name( "country" ));
        Select dropCountry=new Select(country);
        dropCountry.selectByVisibleText( "TURKEY" );
        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
        dropCountry.selectByIndex( 0 );
        */
      /*   //fare hareketleri
        baseUrl= "https://www.amazon.com.tr/";
        driver.get( baseUrl );
        WebElement tabBarAccount = driver.findElement(By.id( "nav-link-accountList-nav-line-1" ));
        Actions actions= new Actions( driver );
        actions.moveToElement(tabBarAccount).perform();
        try {
            Thread.sleep( 3000 );
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
        WebElement login = driver.findElement(By.xpath( "//*[@id='nav-flyout-ya-signin']/a/span" ));
        login.click();
*/

/*
        String baseUrl="https://www.amazon.com.tr";
        driver.get( baseUrl );
        Actions actions = new Actions( driver );
        WebElement navBarPrime= driver.findElement(By.xpath( "//*[@id=\"nav-link-amazonprime\"]/span[1]" ));
        WebElement cookieAccept=driver.findElement( By.id( "sp-cc-accept" ) );
        cookieAccept.click();
        actions.moveToElement( navBarPrime ).perform();
        try {
            Thread.sleep( 3000 );
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
        WebElement navBarDropDownPrime= driver.findElement( By.xpath( "//*[@id=\"nav-flyout-amazonprime\"]/div[2]/ms3-selection/a/div" ) );
        navBarDropDownPrime.click();
*/


        baseUrl="https://www.hepsiburada.com";
        driver.get( baseUrl );
        WebElement cookie = driver.findElement( By.id( "onetrust-accept-btn-handler" ) );
        cookie.click();

        WebElement navBarPrime = driver.findElement(
        By.xpath(  "//*[@id=\"NavigationDesktop_dc3d2766-23df-4ecd-bcd3-fe0c87e771d9\"]/div/div/div/div/div[1]/div/ul/li[1]"));
        Actions actions= new Actions( driver );
        Actions actions2= new Actions( driver );
        actions.moveToElement(navBarPrime).perform();
        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
        WebElement navBarDropDown =driver.findElement(
        By.xpath( "//*[@id=\"NavigationDesktop_dc3d2766-23df-4ecd-bcd3-fe0c87e771d9\"]/div/div/div/div/div[1]/div/ul/li[1]/div/div/div/div[1]/ul/li/a" ) );
        actions2.moveToElement( navBarDropDown ).perform();
        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
        WebElement navBarDropDownNotebookButton = driver.findElement(
        By.xpath( "//*[@id=\"NavigationDesktop_dc3d2766-23df-4ecd-bcd3-fe0c87e771d9\"]/div/div/div/div/div[1]/div/ul/li[1]/div/div/div/div[1]/ul/li/div/ul[1]/li/ul[1]/li/a[2]/span" ) );
        navBarDropDownNotebookButton.click();

        /* //sürükle ve bırak
        String baseUrl="http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html";
        driver.get( baseUrl );
        WebElement oslo = driver.findElement(By.id( "box1" ));
        WebElement stockholm = driver.findElement(By.id( "box2" ));
        WebElement washington =driver.findElement( By.id( "box3" ) );
        WebElement copenhagen =driver.findElement( By.id( "box4" ) );
        WebElement seoul = driver.findElement(By.id( "box5" ));
        WebElement rome = driver.findElement(By.id( "box6" ));
        WebElement madrid= driver.findElement(By.id("box7"));


        WebElement italy = driver.findElement(By.id( "box106" ));
        WebElement spain = driver.findElement(By.id( "box107" ));
        WebElement norway =driver.findElement( By.id( "box101" ) );
        WebElement denmark =driver.findElement( By.id( "box104" ) );
        WebElement southKorea = driver.findElement(By.id( "box105" ));
        WebElement sweden = driver.findElement(By.id( "box102" ));
        WebElement unitedStates= driver.findElement(By.id("box103"));

        Actions actions = new Actions( driver );
        actions.dragAndDrop( rome,italy ).build().perform();
        actions.dragAndDrop( madrid,spain ).build().perform();
        actions.dragAndDrop( oslo,norway ).build().perform();
        actions.dragAndDrop( copenhagen,denmark ).build().perform();
        actions.dragAndDrop( seoul,southKorea ).build().perform();
        actions.dragAndDrop( stockholm,sweden ).build().perform();
        actions.dragAndDrop( washington,unitedStates ).build().perform();
            */

            /* //Sağ tıklama işlemi
        driver.get( baseUrl+"/simple_context_menu.html" );
        WebElement rightclickButton= driver.findElement(By.xpath( "//*[@id=\"authentication\"]/span" ));
        Actions actions = new Actions( driver);
        actions.contextClick(rightclickButton).perform(); //sağ tıklama işlemi
        WebElement buttonDropDown = driver.findElement(By.cssSelector( ".context-menu-icon-copy" )); //css göre arama . yı unutma en başa
        buttonDropDown.click();
        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
        driver.switchTo().alert().accept(); //pop up mesajını kabul etme
            */
        /*
            // çift tıklama işlemi
        driver.get( baseUrl+"/simple_context_menu.html" );
        WebElement doubleClickButton = driver.findElement(By.xpath( "//button[text()='Double-Click Me To See Alert']" )); //teti bu olan butonu seçme x path ile
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform(); // çift tıklama işlemi
        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
        driver.switchTo().alert().accept(); //pop up mesajını kabul etme
         */

        /*
            //Dosya yükleme
        driver.get( baseUrl+"/upload" );
        String images= "C:\\PeraJava\\ders1\\src\\images\\ılık.png"; //dosya yolunu atadım
        WebElement uploadElement = driver.findElement(By.id( "uploadfile_0" ));
        uploadElement.sendKeys( images ); //dosya yolunu gönderme
        driver.findElement( By.id( "terms" ) ).click();
        driver.findElement( By.id( "submitbutton" ) ).click();
        */

/*
        String dowloadsPath="C:\\Users\\muhar\\Downloads";
        String fileName="sampleFile.jpeg";
        baseUrl="https://demoqa.com/upload-download";
        driver.get( baseUrl );
        WebElement download= driver.findElement(By.id( "downloadButton" ));
        download.click();
        try {
            Thread.sleep( 3000 );
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
        System.out.println(isDownloaded( dowloadsPath,fileName ));
        //driver.quit();
    }
    public  static  boolean isDownloaded(String dowloadsPath,String fileName) {
        File file = new File( dowloadsPath );
        File[] files = file.listFiles();
        for (File i : files) {
            if (i.getName().equals( fileName )) {
                return true;
            }
        }
        return false;
    }
 */
       /* //pop upları kontrol etme
        driver.get( baseUrl+"/delete_customer.php");
        WebElement inputTextId= driver.findElement(By.name( "cusid" ));
        WebElement sumbitButon=driver.findElement( By.xpath( "//input[@name='submit']" ) );
        inputTextId.sendKeys( "7258" );
        sumbitButon.click();
        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
        Alert alert = driver.switchTo().alert();
        Alert alert2 = driver.switchTo().alert();
        System.out.println(alert.getText());

        alert.accept();
        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
        System.out.println(alert2.getText());
        alert2.accept();
        */
/*
        //Sekmeler arası geçiş yapmak
        baseUrl="https://demo.guru99.com/popup.php";
        driver.get( baseUrl );
        WebElement clickHere= driver.findElement(By.xpath( "//*[contains(@href, 'popup.php')]" ));
        clickHere.click();
        List<String> tabs= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window( tabs.get( 1 ) );
        WebElement inputEmail= driver.findElement(By.name( "emailid" ));
        WebElement submitButton= driver.findElement(By.name( "btnLogin" ));
        inputEmail.sendKeys( "a@gmail.com" );
        submitButton.click();
        driver.findElement(By.xpath( "//*[contains(@href, 'popup.php')]" )).click();
*/
/*
        baseUrl="https://demo.guru99.com/popup.php";
        driver.get( baseUrl );
        WebElement clickHere= driver.findElement(By.xpath( "//*[contains(@href , 'popup.php')]" ));
        clickHere.click();
        List<String> tabs= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window( tabs.get(1) );
        WebElement email= driver.findElement(By.name( "emailid" ));
        email.sendKeys( "a@gmail.com" );
        WebElement submitButton= driver.findElement(By.name( "btnLogin" ));
        submitButton.click();
        try {
            Thread.sleep( 2000 );
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
        WebElement clickHere2= driver.findElement(By.xpath( "//*[contains(@href , 'popup.php')]" ));
        clickHere2.click();
 */

        /*
        driver.get( baseUrl+"/social-icon.html" );
        String expentedData="Gitub";
        WebElement gitButton = driver.findElement(By.xpath( "//*[@id=\"page\"]/div[2]/div/a[4]" ));
        String value=gitButton.getAttribute( "title" );
        if (expentedData.equals( value )){
            System.out.println("Button trueee!!");
        }else {
            System.out.println("Button falseee!!");
        }
    */

        /*
        //space ile sayfa kaydırma
        driver.get( baseUrl+"/guru99home" );
        WebElement page= driver.findElement(By.xpath( "/html" ));
        page.sendKeys( Keys.SPACE );
        page.sendKeys( Keys.SPACE );
        page.sendKeys( Keys.SPACE );
         */

        /*
        //javascript ile aşağı kaydırma
        driver.get( baseUrl+"/guru99home" );
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript( "window.scrollBy(0,500)");
        */
        /*
        //sayfanın sonunan kaydırma
        js.executeScript( "window.scrollTo(0,document.body.scrollHeight)";
        //linux elementini görenee kadar aşağıya kaydırır
        driver.get( baseUrl+"/guru99home" );
        JavascriptExecutor js= (JavascriptExecutor) driver;
        WebElement linux= driver.findElement(By.linkText( "Linux" ));
        js.executeScript( "arguments[0].scrollIntoView();",linux );
        */
        /*
        baseUrl="https://www.facebook.com/";
        driver.get( baseUrl );
        TakesScreenshot screenshot = (TakesScreenshot)driver;
        File srcFile=screenshot.getScreenshotAs( OutputType.FILE );
        method( srcFile);
        public static void method(File srcFile){
            File destFile= new File( "C:/Users/muhar/OneDrive/Resimler/Ekran Görüntüleri/test.png" );
            try {
                FileUtils.copyFile( srcFile,destFile );
            } catch (IOException e) {
                throw new RuntimeException( e );
            }
         */
        baseUrl="https://www.facebook.com";
        String url="";
        HttpURLConnection huc=null;
        int respCode=200;
        driver.get( baseUrl );
        WebElement pageScroll= driver.findElement(By.xpath( "//*[@id=\"facebook\"]" ));
        pageScroll.sendKeys( Keys.SPACE );
        List<WebElement> links=driver.findElements( By.tagName( "a" ) );
        Iterator<WebElement> it=links.iterator();

        for (WebElement i:links) {
            url=it.next().getAttribute( "href" );
            if(url==null || url.isEmpty()){
                System.out.println(url+" Boş");
                continue;
            }
            if(!url.startsWith( baseUrl )){
                System.out.println(url+" bizim sayfanmızın urlsi değil");
                continue;
            }

            try {
                huc=(HttpURLConnection)(new URL(url).openConnection());
                huc.setRequestMethod( "HEAD" );
                huc.connect();
                respCode=huc.getResponseCode();
                if(respCode>=400){
                    System.out.println(url+" -Kırık Link");
                }else {
                    System.out.println(url+" -Geçerli Link çalışıyor");
                }
            } catch (IOException e) {
                throw new RuntimeException( e );
            }
        }
        System.out.println(links.size());
        driver.quit();

    }

    }




