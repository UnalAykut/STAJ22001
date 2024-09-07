package pageFactory.examples.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pageFactory.examples.Base.BasePage;
import pom.demo.examples.BaseTest;

public class NavBarPage extends BasePage {
    public NavBarPage(WebDriver driver) {
        super( driver );
        PageFactory.initElements( driver, this);
    }

  @FindBy(xpath = "//a[@class='btnSignIn']")
  private WebElement loginButon;


    public void loginButton(){
        loginButon.click();
    }


}
