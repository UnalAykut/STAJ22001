package pom.demo.examples;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseTest {

    WebDriver driver;
    PopUpCookiesPage popUpCookiesPage;
    ResultsPage resultsPage;
    NavBarPage navBarPage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        popUpCookiesPage=new PopUpCookiesPage( driver);
        resultsPage=new ResultsPage( driver );
        navBarPage=new NavBarPage( driver );
        driver.manage().timeouts().implicitlyWait( Duration.ofSeconds( 10 ) );
        driver.manage().window().maximize();
    }
}
