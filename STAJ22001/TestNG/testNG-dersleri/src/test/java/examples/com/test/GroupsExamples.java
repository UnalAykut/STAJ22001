package examples.com.test;

import org.testng.annotations.Test;

public class GroupsExamples {
    @Test(groups = "Duman")
    public void Test01(){
        System.out.println("Yanlızca duman testi için çalışır");
    }
    @Test(groups = {"Regresyon","Duman"})
    public void Test02(){
        System.out.println("Duman ve regresyon testi için çalışır");
    }
    @Test(groups = "Duman")
    public void Test03(){
        System.out.println("Yanlızca duman testi için çalışır");
    }
    @Test(groups = "Entegrasyon")
    public void Test04(){
        System.out.println("Yanlızca entegre testi için çalışır");
    }
}
