package in.reqres.testing.interactions;

import in.reqres.testing.exceptions.ErrorServicesException;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Delete;
import org.apache.http.HttpStatus;

import static in.reqres.testing.utils.constants.Constants.EXCEPTION_ERROR_CONSUMPTION_SERVICE;
import static io.restassured.http.ContentType.JSON;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ExecuteDelete implements Interaction {

    private final String resource;

    public ExecuteDelete(String resource) {
        this.resource = resource;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.attemptsTo(
                Delete.from(resource)
                        .with(request -> request
                                .contentType(JSON)
                                .relaxedHTTPSValidation()
                        )
        );

        if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_NO_CONTENT) {
            throw new ErrorServicesException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
        }
    }

    public static Performable service(String resource) {
        return instrumented(ExecuteDelete.class, resource);
    }
}
