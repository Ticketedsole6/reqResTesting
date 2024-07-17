package in.reqres.testing.tasks;

import in.reqres.testing.interactions.Post;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RegisterUserTask implements Task {

    // Field to store the user information
    private final Object userInfo;

    // Constructor to initialize the user information
    public RegisterUserTask(Object userInfo) {
        this.userInfo = userInfo;
    }

    // Static method to create a new instance of RegisterUserTask with the provided user information
    public static Performable withInfo(Object userInfo) {
        return instrumented(RegisterUserTask.class, userInfo);
    }

    // Method to perform the register user action as the given actor
    @Override
    public <T extends Actor> void performAs(T actor) {
        // Actor attempts to register the user by posting to the specified endpoint with the provided information
        actor.attemptsTo(
                Post.to("/register").with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInfo)
                )
        );
    }
}
