package pageFactory.examples.Base;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver=driver;
    }

    public void navigateToUrl(String URL){
        driver.get(URL);
    }

    public void waitSleep(){
        try {
            Thread.sleep( 3000 );
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
    }

}
