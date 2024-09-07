package pom.examples;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest(){
        driver.get( "https://practicetestautomation.com/practice-test-login/" );
        loginPage.usernameLogin("student");
        loginPage.passwordLogin( "Password123" );
        loginPage.enterSubmit();
    }

}
