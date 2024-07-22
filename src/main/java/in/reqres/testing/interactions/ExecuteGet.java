package in.reqres.testing.interactions;

import static in.reqres.testing.utils.constants.Constants.EXCEPTION_ERROR_CONSUMPTION_SERVICE;
import static io.restassured.http.ContentType.JSON;
import in.reqres.testing.exceptions.ErrorServicesException;
import in.reqres.testing.models.TestDataModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.apache.http.HttpStatus;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ExecuteGet implements Interaction {

    private final String resource;

    public ExecuteGet(String resource) {
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.attemptsTo(
                Get.resource(resource)
                        .with(requestSpecification -> requestSpecification
                                .contentType(JSON).params(TestDataModel.getData())
                                .relaxedHTTPSValidation()
                        )
        );

        if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK) {
            throw new ErrorServicesException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
        }
    }

    public static Performable service(String resource) {
        return instrumented(ExecuteGet.class, resource);
    }
}
