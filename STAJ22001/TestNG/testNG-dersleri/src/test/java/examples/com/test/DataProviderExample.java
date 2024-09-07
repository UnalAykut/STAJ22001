package examples.com.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

    @DataProvider(name = "testDataPro1")
    public Object[][] testData(){
        return new Object[][]{
                {"Aykut",22},
                {"Tayfur",21},
                {"Lina",3},
        };
    }

    @Test(dataProvider = "testDataPro1")
    public void test1(String name,int age){
        System.out.println("Name:"+name+"   Age:"+age);
    }
}
