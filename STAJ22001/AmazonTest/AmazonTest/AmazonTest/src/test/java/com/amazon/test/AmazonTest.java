package com.amazon.test;

import com.amazon.page.NavigationBarPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonTest extends BaseTest{
    private NavigationBarPage navigationBarPage;
    @BeforeClass
    public void pageSetUp(){
        navigationBarPage=new NavigationBarPage( driver );
    }
    @Test
    public void searchTest(){

        navigationBarPage.inputSearchTextBox( "laptop" );
        navigationBarPage.clickSubmitButton();
    }


}
