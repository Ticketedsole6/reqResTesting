package in.reqres.testing.stepdefinitions;

import in.reqres.testing.models.TestDataModel;
import in.reqres.testing.tasks.ConsumeDelete;
import in.reqres.testing.utils.resource.WebServiceEndpoints;
import io.cucumber.java.en.When;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class DeleteStepdefinitions {

    @When("tester call delete user API")
    public void testerCallDeleteUserAPI() {
        String id = String.valueOf(TestDataModel.getData().get("id"));

        theActorInTheSpotlight().attemptsTo(
                ConsumeDelete.service(
                        WebServiceEndpoints.URI.getUrl(), id
                )
        );
    }
}
