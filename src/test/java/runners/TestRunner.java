package runners;



import io.cucumber.testng.*;

@SuppressWarnings("deprecation")

@CucumberOptions(
features = "src/test/resources/features/Wordpress.feature",
glue = "stepdefinitions",
plugin = {"pretty", "html:target/cucumber-report.html"},
monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}


