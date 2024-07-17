package in.reqres.testing.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class Put extends RestInteraction {
    // Field to store the resource URL or path for the PUT request
    private final String resource;

    // Constructor to initialize the resource URL or path
    public Put(String resource) {
        this.resource = resource;
    }

    // Method to perform the PUT action as the given actor
    @Step("{0} executes a PUT on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        // Perform the PUT request on the specified resource, logging request and response details
        rest().log().all().put(as(actor).resolve(resource)).then().log().all();
    }

    // Static method to create a new instance of Put with the provided resource URL or path
    public static Put to(String resource) {
        return instrumented(Put.class, resource);
    }
}
