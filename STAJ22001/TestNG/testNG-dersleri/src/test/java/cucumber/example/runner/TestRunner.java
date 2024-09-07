package cucumber.example.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith( Cucumber.class )
@CucumberOptions(
        features = "C:/PeraJava/testNG-dersleri/src/test/java/cucumber/example/features",//test senaryolarının olduğu yeri gösterdik
        glue = "cucumber.example.stepDefinition",//methodlardın tanımlandığı sınıfların hangi pakette olduğunu gösterdik
        plugin = {"pretty","html:target/cucumber-html-report.html"}

)
public class TestRunner {
}
