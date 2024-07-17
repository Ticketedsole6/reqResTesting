package in.reqres.testing.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class Get extends RestInteraction {
    // Field to store the resource URL or path for the GET request
    private final String resource;

    // Constructor to initialize the resource URL or path
    public Get(String resource) {
        this.resource = resource;
    }

    // Method to perform the GET action as the given actor
    @Step("{0} executes a GET on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        // Perform the GET request on the specified resource, logging request and response details
        rest().log().all().get(as(actor).resolve(resource)).then().log().all();
    }

    // Static method to create a new instance of Get with the provided resource URL or path
    public static Get resource(String resource) {
        return instrumented(Get.class, resource);
    }
}
