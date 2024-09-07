package com.amazon.test;


import com.amazon.page.LoginPage;
import com.amazon.page.NavigationBarPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class LoginPageTest extends BaseTest{
    Assertion assertion=new Assertion();
    private LoginPage loginPage;
    private NavigationBarPage navigationBarPage;

    private String expectedData;
    private String actualData;
    private String email="";
    private String password="";
    @BeforeClass
    public void pageSetUp(){
        navigationBarPage=new NavigationBarPage( driver );
        loginPage=new LoginPage( driver );
    }

    @Test(priority = 0)
    public void emptyEmailLoginTest() throws InterruptedException {
        expectedData="E-posta adresinizi veya cep telefonu numaranızı girin";
        navigationBarPage.clickLoginAccountListButton();
        loginPage.inputEmail(email);
        loginPage.clickContinueButton();
        actualData=loginPage.emptyEmailMessage();
        driver.navigate().refresh();
        assertion.assertEquals(actualData,expectedData);

    }
    @Test(priority = 1)
    public void wrongEmailLoginTest() throws InterruptedException {
        expectedData="Bu e-posta adresiyle bir hesap bulamıyoruz";
        email="asafa@gmail.com";
        loginPage.inputEmail(email);
        loginPage.clickContinueButton();
        actualData=loginPage.wrongEmailMessage();
        assertion.assertEquals(actualData,expectedData);
        loginPage.clearEmailInput();
    }
    @Test(priority = 2)
    public void trueEmailLoginTest() throws InterruptedException {
        expectedData="Bu e-posta adresiyle bir hesap bulamıyoruz";
        email="";//kendi emailinizi girip deneyebilirsiniz
        loginPage.inputEmail(email);
        loginPage.clickContinueButton();

    }
    @Test(priority = 3)
    public void emptyPasswordLoginTest() throws InterruptedException {
        expectedData="Şifrenizi girin";
        loginPage.inputPassword( password );
        loginPage.clickLoginButton();
        actualData=loginPage.emptyPasswordMessage();
        assertion.assertEquals(actualData,expectedData);
        driver.navigate().refresh();

    }
    @Test(priority = 4)
    public void wrongPasswordLoginTest() throws InterruptedException {
        expectedData="Şifreniz yanlış";
        password="asasdasa@?0";
        loginPage.inputPassword( password );
        loginPage.clickLoginButton();
        actualData=loginPage.wrongPasswordMessage();
        assertion.assertEquals(actualData,expectedData);
        loginPage.clearPasswordInput();

    }
    @Test(priority = 5)
    public void trueLoginTest() throws InterruptedException {
        password="";//kendi şifrenizi girip deneyebilirsiniz
        loginPage.inputPassword( password );
        loginPage.clickLoginButton();
    }


}
