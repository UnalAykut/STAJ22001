package examples.com.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BaseTestUseExample extends BaseTest {
@Test
    public void login(){
    driver.get( "https://practicetestautomation.com/practice-test-login/" );
    String username="student";
    String password="Password123";
    String wrongPasswordExpected="Your password 1 invalid!";
    String wrongUsernameExpected="Your username 1 invalid!";
    WebElement usernameInput= driver.findElement( By.id( "username" ));
    WebElement passwordInput= driver.findElement( By.id( "password" ) );
    WebElement sumbitButton=driver.findElement( By.id( "submit" ) );

    usernameInput.sendKeys( "as" );
    passwordInput.sendKeys( password );
    sumbitButton.click();
    WebElement actualData=driver.findElement( By.id( "error" ) );
    softAssert.assertEquals( actualData,wrongUsernameExpected );

    usernameInput.sendKeys( username );
    passwordInput.sendKeys( "as" );
    sumbitButton.click();
    actualData=driver.findElement( By.id( "error" ) );
    softAssert.assertEquals( actualData,wrongPasswordExpected);
    usernameInput.sendKeys( username );
    passwordInput.sendKeys( password );
    sumbitButton.click();
    WebElement postTitle=driver.findElement( By.className( "post-title" ) );
    softAssert.assertTrue(postTitle.isDisplayed());
}

}
