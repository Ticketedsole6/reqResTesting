package in.reqres.testing.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

public class Post extends RestInteraction {
    // Field to store the resource URL or path for the POST request
    private final String resource;

    // Constructor to initialize the resource URL or path
    public Post(String resource) {
        this.resource = resource;
    }

    // Method to perform the POST action as the given actor
    @Step("{0} executes a POST on the resource #resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        // Perform the POST request on the specified resource, logging request and response details
        rest().log().all().post(as(actor).resolve(resource)).then().log().all();
    }

    // Static method to create a new instance of Post with the provided resource URL or path
    public static Post to(String resource) {
        return instrumented(Post.class, resource);
    }
}
