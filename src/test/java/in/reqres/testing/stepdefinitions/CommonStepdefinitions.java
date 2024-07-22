package in.reqres.testing.stepdefinitions;

import in.reqres.testing.exceptions.AssertionsServices;
import in.reqres.testing.questions.StatusCode;
import in.reqres.testing.questions.TheQuantityFieldsService;
import in.reqres.testing.questions.TheSchemaIs;
import in.reqres.testing.tasks.Load;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

import static in.reqres.testing.exceptions.AssertionsServices.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CommonStepdefinitions {

    @Given("tester load customer information")
    public void testerLoadCustomerInformation(List<Map<String, String>> data) {
        theActorInTheSpotlight().wasAbleTo(
                Load.testData(data.get(0))
        );
    }

    @Then("tester should get status code {int}")
    public void testerShouldGetStatusCode(int responseCode) {
        theActorInTheSpotlight()
                .should(seeThat(StatusCode.is(responseCode))
                        .orComplainWith(AssertionsServices.class,
                                THE_STATUS_CODE_SERVICE_IS_NOT_EXPECTED)
                );
    }

    @Then("tester validate keys quantity is {int}")
    public void testerValidateKeysQuantityIs(int quantity) {
        theActorInTheSpotlight()
                .should(seeThat(TheQuantityFieldsService.are(quantity))
                        .orComplainWith(AssertionsServices.class,
                                FIELDS_QUANTITY_IS_NOT_EXPECTED)
                );
    }

    @Then("tester validate schema response {string}")
    public void testerValidateSchemaResponse(String schemeResponse) {
        theActorInTheSpotlight()
                .should(seeThat(TheSchemaIs.expected(schemeResponse))
                        .orComplainWith(AssertionsServices.class,
                                SCHEMA_IS_NOT_EXPECTED)
                );
    }
}
