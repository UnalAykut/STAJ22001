package cucumber.example.stepDefinition;

import cucumber.example.pages.TestLoginPage;
import cucumber.example.utilitles.MyDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.TestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class StepDefinitions {
    private WebDriver driver;
    private TestLoginPage testLoginPage;
    @Before
    public void setUp(){
        driver= MyDriver.getDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 10 ) );
        testLoginPage=new TestLoginPage( driver );
    }
    @After
    public void tearDown(){
        MyDriver.closeDriver();
    }

    @Given("go to login page")
    public void go_to_login_page() {
        testLoginPage.goLoginPage();
    }
    @And("type username as {string}")
    public void typeUsernameAsUsername(String name) {
        testLoginPage.inputEmail(name );
    }

    @And("type password as {string}")
    public void typePasswordAsPassword(String passw) {
        testLoginPage.inputPassword( passw );
    }
    @When("click button")
    public void click_button() {
        testLoginPage.clickButton();
    }
    @Then("assert to success message")
    public void assert_to_success_message() {
        testLoginPage.successMesage();
    }




}
