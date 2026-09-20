package runners;

import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;


    @CucumberOptions(

            features = "src/test/resources/features",

            glue = "steps",

            plugin = {
                    "pretty",
                    "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
                    "html:target/cucumber-reports/cucumber-pretty.html"
            }
    )

    public class RunCucumberTest extends AbstractTestNGCucumberTests {

        @Override
        @DataProvider(parallel = false)
        public Object[][] scenarios() {
            return super.scenarios();
        }
}
