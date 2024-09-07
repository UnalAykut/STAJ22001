package pageFactory.examples.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageFactory.examples.Base.BasePage;
import pageFactory.examples.Base.BaseTest;
import pageFactory.examples.Pages.LoginPage;
import pageFactory.examples.Pages.NavBarPage;

public class TestN11 extends BaseTest  {
    NavBarPage navBarPage;
    LoginPage loginPage;

    @Test(priority = 1)
    public void testUrl(){
        navBarPage= new NavBarPage(driver);
        navBarPage.navigateToUrl( "https://www.n11.com" );
    }

    @Test(priority = 2)
    public void testLoginButton(){
        navBarPage= new NavBarPage(driver);
        navBarPage.loginButton();
    }
    @Test(priority = 3)
    public void testLogin(){
        loginPage=new LoginPage( driver );
        loginPage.textEmailInput( "aykut@gmail.com" );
        loginPage.textPasswordInput( "123456789" );
        loginPage.LoginButton();
        loginPage.waitSleep();
        Assert.assertTrue( loginPage.getErrorMessage().isDisplayed() );
    }

}
