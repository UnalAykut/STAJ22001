package pom.demo.examples;

import org.testng.annotations.Test;

public class TestPage extends BaseTest {

    @Test
    public void Test01(){
        driver.get( "https://www.n11.com/" );
        //popUpCookiesPage.cookieAccept();
        popUpCookiesPage.popUpExit();
        try {
            Thread.sleep( 3000 );
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }

        navBarPage.searchInput( "laptop" );
        navBarPage.searchButon();
        resultsPage.clickProduct( 1);
        resultsPage.addBasketTest();
        try {
            Thread.sleep( 3000 );
        } catch (InterruptedException e) {
            throw new RuntimeException( e );
        }
        navBarPage.basketTextControl();
    }

}
