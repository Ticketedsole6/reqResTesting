package in.reqres.testing.tasks;

import in.reqres.testing.interactions.Get;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUsersTask implements Task {

    // Field to store the page number
    private final int page;

    // Constructor to initialize the page number
    public GetUsersTask(int page) {
        this.page = page;
    }

    // Static method to create a new instance of GetUsersTask with the provided page number
    public static Performable fromPage(int page) {
        return instrumented(GetUsersTask.class, page);
    }

    // Method to perform the get users action as the given actor
    @Override
    public <T extends Actor> void performAs(T actor) {
        // Actor attempts to get users from the specified page endpoint
        actor.attemptsTo(
                Get.resource("/users?page=" + page)
                        .with(requestSpecification ->
                                requestSpecification.contentType(ContentType.JSON))
        );
    }
}
