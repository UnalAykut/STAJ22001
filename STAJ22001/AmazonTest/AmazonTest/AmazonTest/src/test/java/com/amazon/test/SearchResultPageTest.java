package com.amazon.test;

import com.amazon.page.NavigationBarPage;
import com.amazon.page.SearchResultPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchResultPageTest extends BaseTest {

    private SearchResultPage searchResultPage;
    private NavigationBarPage navigationBarPage;
    @BeforeClass
    public void pageSetUp(){
        navigationBarPage=new NavigationBarPage( driver );
        searchResultPage=new SearchResultPage( driver );
    }
    @Test(dependsOnMethods = "com.amazon.test.AmazonTest.searchTest")
    @Parameters({"searchText", "index"})
    public void searchResultDataTest(String searchText,int index) throws InterruptedException {
        navigationBarPage.inputSearchTextBox(searchText );
        navigationBarPage.clickSubmitButton();
        searchResultPage.clickItemSearchResultsData(index);
    }


}
