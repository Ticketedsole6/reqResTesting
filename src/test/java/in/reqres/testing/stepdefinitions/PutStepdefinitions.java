package in.reqres.testing.stepdefinitions;

import in.reqres.testing.exceptions.AssertionsServices;
import in.reqres.testing.models.TestDataModel;
import in.reqres.testing.questions.TheFieldsAndValuePutResponseAre;
import in.reqres.testing.tasks.ConsumePut;
import in.reqres.testing.tasks.Create;
import in.reqres.testing.utils.resource.WebServiceEndpoints;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PutStepdefinitions {

    @When("tester call put user API")
    public void testerCallPutUserAPI() {
        String id = String.valueOf(TestDataModel.getData().get("id"));

        theActorInTheSpotlight().attemptsTo(
                Create.messageBody("singleUser.json", TestDataModel.getData())
        );
        theActorInTheSpotlight().attemptsTo(
                ConsumePut.service(
                        WebServiceEndpoints.URI.getUrl(), id
                )
        );
    }

    @Then("tester validate put response contains data expected")
    public void testerValidatePutResponseContainsDataExpected() {
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsAndValuePutResponseAre.expected())
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.RESPONSE_CONTAINS_IS_NOT_EXPECTED)
                );
    }
}
