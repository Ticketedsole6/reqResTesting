package in.reqres.testing.runners;

import in.reqres.testing.utils.exceldata.BeforeSuite;
import in.reqres.testing.utils.exceldata.DataToFeature;
import static io.cucumber.junit.CucumberOptions.SnippetType;
import io.cucumber.junit.CucumberOptions;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.runner.RunWith;

import java.io.IOException;

@RunWith(CustomRunner.class)
@CucumberOptions(
        snippets = SnippetType.CAMELCASE,
        features = "src/test/resources/features/put.feature",
        glue = {"in.reqres.testing.stepdefinitions.hook",
                "in.reqres.testing.stepdefinitions"
        }
)
public class PutRunner {
    @BeforeSuite
    public static void test() throws IOException, InvalidFormatException {
        DataToFeature.overrideFeatureFiles("./src/test/resources/features/put.feature");
    }
}
