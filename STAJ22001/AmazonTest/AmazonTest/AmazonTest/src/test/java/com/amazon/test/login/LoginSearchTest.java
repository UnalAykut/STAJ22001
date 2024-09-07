package com.amazon.test.login;

import com.amazon.page.ProductPage;
import com.amazon.page.SearchResultPage;
import com.amazon.util.Utils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
public class LoginSearchTest extends LoginBaseTest {
    private SearchResultPage searchResultPage;
    private ProductPage productPage;

    @BeforeClass
    public void pageSetUp() {
        searchResultPage = new SearchResultPage(driver);
        productPage= new  ProductPage(driver );
    }

    @Test(priority = 1)
    public void searchItemTest() throws InterruptedException {
        int index =5;
        if (!isLoginSuccessful()) {
            throw new IllegalStateException("User is not logged in. Login is required to perform this test.");
        }
        navigationBarPage.inputSearchTextBox("laptop");
        navigationBarPage.clickSubmitButton();
        Utils.waitForSeconds( 3 );
        String actualData=searchResultPage.actualProductName(index);
        searchResultPage.clickItemSearchResultsData(index); // Belirtilen indexteki ürünü tıklama
        Utils.waitForSeconds( 3 );
        String expectedData = productPage.expectedProductName();
        if(Utils.nameControl(actualData, expectedData)){
            System.out.println("Ürün eşleşti");
        }else {
            System.out.println("Ürün eşleşmedi.");
        }
        Utils.waitForSeconds( 3 );
        driver.navigate().refresh();
    }

}
