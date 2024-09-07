package com.amazon.test.login;

import com.amazon.page.BasePage;
import com.amazon.page.CartPage;
import com.amazon.page.ProductPage;
import com.amazon.page.SearchResultPage;
import com.amazon.util.Utils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginCartTest extends LoginBaseTest{
    private ProductPage productPage;
    private CartPage cartPage;
    private SearchResultPage searchResultPage;
    @BeforeClass
    public void pageSetUp() {
        cartPage= BasePage.getInstance( CartPage.class,driver );
        productPage=BasePage.getInstance( ProductPage.class,driver );
        searchResultPage=BasePage.getInstance( SearchResultPage.class,driver );
    }
    @Test()
    public void addToCartTest() throws InterruptedException {
        int index=12;
        navigationBarPage.inputSearchTextBox("laptop");
        navigationBarPage.clickSubmitButton();
        Utils.waitForSeconds( 3 );
        searchResultPage.clickItemSearchResultsData(index); //
        productPage.addCart();
        String actualData="Sepete Eklendi";
        if(Utils.nameControl( cartPage.addTextControl(), actualData)){
            System.out.println("Sepete Eklendi");
        }else {
            System.out.println("Sepete eklenmede sorun oluştu");
        }

    }


}
