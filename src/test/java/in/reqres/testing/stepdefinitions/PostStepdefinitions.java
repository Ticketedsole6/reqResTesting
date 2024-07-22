package in.reqres.testing.stepdefinitions;


import in.reqres.testing.exceptions.AssertionsServices;
import in.reqres.testing.models.TestDataModel;
import in.reqres.testing.questions.TheFieldsAndValuePostResponseAre;
import in.reqres.testing.tasks.ConsumePost;
import in.reqres.testing.tasks.Create;
import in.reqres.testing.utils.resource.WebServiceEndpoints;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class PostStepdefinitions {

    @When("tester call post user API")
    public void testerCallPostUserAPI() {
        theActorInTheSpotlight().attemptsTo(
                Create.messageBody("singleUser.json", TestDataModel.getData())
        );
        theActorInTheSpotlight().attemptsTo(
                ConsumePost.service(WebServiceEndpoints.URI.getUrl())
        );
    }

    @Then("tester validate post response contains data expected")
    public void testerValidatePostResponseContainsDataExpected() {
        theActorInTheSpotlight()
                .should(seeThat(TheFieldsAndValuePostResponseAre.expected())
                        .orComplainWith(AssertionsServices.class,
                                AssertionsServices.RESPONSE_CONTAINS_IS_NOT_EXPECTED)
                );
    }
}
