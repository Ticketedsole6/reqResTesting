package in.reqres.testing.stepdefinitions;

import in.reqres.testing.exceptions.AssertionsServices;
import in.reqres.testing.questions.StatusCode;
import in.reqres.testing.questions.TheFieldsAndValueGetResponseAre;
import in.reqres.testing.questions.TheQuantityFieldsService;
import in.reqres.testing.questions.TheSchemaIs;
import in.reqres.testing.tasks.ConsumeGet;
import in.reqres.testing.tasks.Load;
import in.reqres.testing.utils.resource.WebServiceEndpoints;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static in.reqres.testing.exceptions.AssertionsServices.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.List;
import java.util.Map;

public class GetStepdefinitions {

    @When("tester call user API")
    public void testerCallUserAPI() {
        theActorInTheSpotlight().attemptsTo(
                ConsumeGet.service(
                        WebServiceEndpoints.URI.getUrl()
                )
        );
    }

    @Then("tester validate response contains data expected")
    public void testerValidateResponseContainsDataExpected() {
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsAndValueGetResponseAre.expected())
                        .orComplainWith(AssertionsServices.class,
                                RESPONSE_CONTAINS_IS_NOT_EXPECTED)
                );
    }
}
