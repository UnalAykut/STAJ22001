package pom.demo.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopUpCookiesPage {
    private WebDriver driver;
    private By popUpExitButon = By.xpath( "//*[@id=\"dengage-push-perm-slide\"]/div/div[2]/div[2]/button[1]" );
    private By cookieAcceptButon= By.xpath( "//*[@id=\"2a7d83f8-effc-496f-ab9f-ed6840f0a847\"]" );

    public PopUpCookiesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void popUpExit(){
        driver.findElement( popUpExitButon ).click();
    }
    public void cookieAccept(){
        driver.findElement( cookieAcceptButon ).click();
    }

}
