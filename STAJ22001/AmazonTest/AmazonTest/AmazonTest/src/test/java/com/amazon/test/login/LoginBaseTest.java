package com.amazon.test.login;

import com.amazon.driver.DriverManager;
import com.amazon.page.BasePage;
import com.amazon.page.LoginPage;
import com.amazon.page.NavigationBarPage;
import com.amazon.util.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class LoginBaseTest {
    protected WebDriver driver;
    protected NavigationBarPage navigationBarPage;
    private BasePage basePage;
    private LoginPage loginPage;

    @BeforeSuite
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        driver = DriverManager.getDriver(browser);
        driver.get("https://www.amazon.com.tr");
        basePage = new BasePage(driver);
        basePage.clickAcceptCookie();
        navigationBarPage = new NavigationBarPage(driver);
        loginPage = new LoginPage(driver);
        // Check if login is necessary
        if (!navigationBarPage.isLoginSuccessful()) {
            performLogin();
        }
    }

    protected void performLogin() {
        ConfigReader configReader = new ConfigReader();
        String email = configReader.getProperty("email");
        String password = configReader.getProperty("password");
        if (email == null || password == null) {
            throw new IllegalArgumentException("Email veya password boş.");
        }
        navigationBarPage.clickLoginAccountListButton();
        loginPage.inputEmail(email);//emailiniz ile deneyebilirsiniz
        loginPage.clickContinueButton();
        loginPage.inputPassword(password);//şifreniz ile deneyebilirsiniz
        loginPage.clickLoginButton();
    }
    protected boolean isLoginSuccessful() {
        return navigationBarPage.isLoginSuccessful();
    }

    @AfterSuite
    public void tearDown() {
        DriverManager.quitDriver();
    }
}
