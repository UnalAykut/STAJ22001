package pom.examples;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;


    private By usernameLocater=By.id( "username" );
    private By passwordLocater=By.id( "password" );
    private By sumbitButton= By.id( "submit" );

    public LoginPage(WebDriver driver){
        this.driver=driver;
    }


    public void usernameLogin(String username){
        driver.findElement( usernameLocater ).sendKeys( username );
    }
    public void passwordLogin(String paswword){
        driver.findElement( passwordLocater ).sendKeys( paswword );
    }
    public void enterSubmit(){
        driver.findElement( sumbitButton ).click();
    }

}
