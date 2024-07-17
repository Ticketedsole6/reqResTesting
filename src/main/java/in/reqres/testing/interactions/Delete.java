package in.reqres.testing.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class Delete extends RestInteraction {
    // Field to store the resource URL or path for the DELETE request
    private final String resource;

    // Constructor to initialize the resource URL or path
    public Delete(String resource) {
        this.resource = resource;
    }

    // Method to perform the DELETE action as the given actor
    @Step("{0} executes a DELETE on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        // Perform the DELETE request on the specified resource, logging request and response details
        rest().log().all().delete(as(actor).resolve(resource)).then().log().all();
    }

    // Static method to create a new instance of Delete with the provided resource URL or path
    public static Delete from(String resource) {
        return instrumented(Delete.class, resource);
    }
}
