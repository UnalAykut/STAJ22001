package pageFactory.examples.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageFactory.examples.Base.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super( driver );
        PageFactory.initElements( driver,this );
    }
    @FindBy(id = "email")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "loginButton")
    private WebElement loginButon;

    @FindBy(className = "error-message")
    private WebElement errorMessage;
    public void textEmailInput(String email){
        emailInput.sendKeys( email );
    }

    public void textPasswordInput(String password) {
        passwordInput.sendKeys( password );
    }

    public void LoginButton() {
        loginButon.click();
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }
}
