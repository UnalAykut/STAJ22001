package cucumber.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class TestLoginPage {
    private WebDriver driver;

    @FindBy(id = "username")
    private WebElement emailText;
    @FindBy(id = "password")
    private WebElement passwordText;
    @FindBy(id = "submit")
    private WebElement submit;
    @FindBy(className = "post-title")
    private WebElement successMesage;

    public TestLoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements( driver,this );
    }

    public void goLoginPage(){
        driver.get( "https://practicetestautomation.com/practice-test-login/" );
    }
    public void inputEmail(String email) {
        emailText.sendKeys( email );
    }

    public void inputPassword(String password) {
        passwordText.sendKeys( password );
    }

    public void clickButton() {
        submit.click();
    }

    public void successMesage() {
        Assert.assertTrue( successMesage.isDisplayed() );
    }
}
