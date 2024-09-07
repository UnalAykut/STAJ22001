package pom.demo.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class NavBarPage {

    private WebDriver driver;
    private String searchText;
    private By searchInput= By.id( "searchData" );
    private By searchButon=By.className( "iconsSearch" );
    private By basketText=By.xpath( "//*[@id=\"header\"]/div/div/div/div[2]/div[4]/a/span" );
    public NavBarPage(WebDriver driver) {
        this.driver = driver;
    }

    public  void searchInput(String searchText){
        driver.findElement( searchInput ).sendKeys( searchText );
    }

    public void searchButon(){
        driver.findElement( searchButon ).click();
    }

    public void basketTextControl(){
        String basketDeger=driver.findElement( basketText ).getText();
        Assert.assertEquals(basketDeger,"1");
    }



}
