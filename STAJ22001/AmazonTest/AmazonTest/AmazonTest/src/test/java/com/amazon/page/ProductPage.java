package com.amazon.page;

import com.amazon.util.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage {

    @FindBy(xpath = "//span[@id='productTitle']")
    private WebElement productName;
    @FindBy(css = "#add-to-cart-button")
    private WebElement addButton;

    public ProductPage(WebDriver driver) {
        super( driver );
    }



    public String expectedProductName(){
        return Utils.waitForElementToBeVisible( driver,productName ).getText();
    }
    public  void addCart(){
       Utils.waitForElementToBeClickable( driver ,addButton).click();
    }



}
