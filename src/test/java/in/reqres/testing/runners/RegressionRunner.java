package in.reqres.testing.runners;

import in.reqres.testing.utils.exceldata.BeforeSuite;
import in.reqres.testing.utils.exceldata.DataToFeature;
import io.cucumber.junit.CucumberOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(CustomRunner.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features",
        glue = {"in.reqres.testing.stepdefinitions.hook",
                "in.reqres.testing.stepdefinitions"
        },
        plugin = {
                "pretty",
                "json:target/cucumber-reports/Cucumber.json"
        }
)
public class RegressionRunner {
    @BeforeSuite
    public static void test() throws IOException, InvalidFormatException {
        DataToFeature.overrideFeatureFiles("./src/test/resources/features");
    }
}
