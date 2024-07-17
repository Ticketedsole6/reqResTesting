package in.reqres.testing.tasks;

import in.reqres.testing.interactions.Put;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class UpdateUserTask implements Task {

    // Field to store the information for updating the user
    private final Object updateUserInfo;

    // Constructor to initialize the information for updating the user
    public UpdateUserTask(Object updateUserInfo) {
        this.updateUserInfo = updateUserInfo;
    }

    // Static method to create a new instance of UpdateUserTask with the provided update user information
    public static Performable withInfo(Object updateUserInfo) {
        return instrumented(UpdateUserTask.class, updateUserInfo);
    }

    // Method to perform the update user action as the given actor
    @Override
    public <T extends Actor> void performAs(T actor) {
        // Actor attempts to update the user by putting to the specified endpoint with the provided information
        actor.attemptsTo(
                Put.to("/users/2").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(updateUserInfo)
                )
        );
    }
}
