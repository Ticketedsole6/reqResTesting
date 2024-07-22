package in.reqres.testing.interactions;

import in.reqres.testing.exceptions.ErrorServicesException;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.rest.interactions.Put;
import org.apache.http.HttpStatus;

import static in.reqres.testing.utils.constants.Constants.EXCEPTION_ERROR_CONSUMPTION_SERVICE;
import static io.restassured.http.ContentType.JSON;

public class ExecutePut implements Interaction {
    private final String resource;
    private final String body;

    public ExecutePut(String resource, String body) {
        this.resource = resource;
        this.body = body;
    }

    public static ExecutePut service(String resource, String body) {
        return Tasks.instrumented(ExecutePut.class, resource, body);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        SerenityRest.reset();
        actor.attemptsTo(
                Put.to(resource)
                        .with(request -> request.
                                contentType(JSON)
                                .body(body)
                                .relaxedHTTPSValidation()
                        )
        );

        if (SerenityRest.lastResponse().statusCode() != HttpStatus.SC_OK) {
            throw new ErrorServicesException(EXCEPTION_ERROR_CONSUMPTION_SERVICE);
        }
    }
}
