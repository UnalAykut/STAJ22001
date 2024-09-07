package com.amazon.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    private static BasePage instance;
    @FindBy(id = "sp-cc-accept")
    private WebElement acceptCookie;
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
        //her sayfada FindBy anatasyonu kullınalacağınan dolayı burada tanımladık.
        PageFactory.initElements( driver,this );
    }
    public static <T extends BasePage> T getInstance(Class<T> pageClass, WebDriver driver) {
        T page = null;
        try {
            page = pageClass.getDeclaredConstructor(WebDriver.class).newInstance(driver);
            PageFactory.initElements(driver, page);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return page;
    }


    public void clickAcceptCookie(){
        try {
            acceptCookie.click();
        }catch (Exception e){
            //eğer cookie yoksa devam et
            System.out.println("Cookie bulunamadı");
        }
    }
    protected void click(WebElement element) throws Exception {
        try {
            element.click();
        }catch (Exception e){
            throw new Exception("Elemente tıklanamadı"+e.getMessage());
        }
    }
    protected String getText(WebElement element) throws Exception {
        try {
            return element.getText();
        }catch (Exception e){
            throw new Exception("Element metni alınamadı:"+e.getMessage());
        }
    }


}



