import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

public class runner {

    @CucumberOptions(
            features = "src/main/resources/features",
//            glue= {"stepDefinitions"},-
            plugin = { "html:target/cucumber-reports.html" },
            tags = "@LoginAccount"
    )
    public static class run extends AbstractTestNGCucumberTests{}
}
