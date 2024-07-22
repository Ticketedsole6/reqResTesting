package in.reqres.testing.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        features = "src/test/resources/features/get.feature",
        glue = {
                "in.reqres.testing.stepdefinitions.hook",
                "in.reqres.testing.stepdefinitions"
        }
)
public class GetRunner {
}
