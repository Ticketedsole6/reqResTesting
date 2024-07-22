package in.reqres.testing.runners;

import in.reqres.testing.utils.exceldata.BeforeSuite;
import in.reqres.testing.utils.exceldata.DataToFeature;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features/delete.feature",
        glue = {
                "in.reqres.testing.stepdefinitions.hook",
                "in.reqres.testing.stepdefinitions"
        }
)
public class DeleteRunner {
        @BeforeSuite
        public static void test() throws IOException, InvalidFormatException {
                DataToFeature.overrideFeatureFiles("./src/test/resources/features/delete.feature");
        }
}
