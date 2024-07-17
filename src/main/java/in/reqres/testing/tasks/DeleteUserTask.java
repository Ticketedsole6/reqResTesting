package in.reqres.testing.tasks;

import in.reqres.testing.interactions.Delete;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DeleteUserTask implements Task {
    // Field to store the user ID
    private final int user;

    // Constructor to initialize the user ID
    public DeleteUserTask(int user) {
        this.user = user;
    }

    // Static method to create a new instance of DeleteUserTask with the provided user ID
    public static Performable fromUser(int user) {
        return instrumented(DeleteUserTask.class, user);
    }

    // Method to perform the delete action as the given actor
    @Override
    public <T extends Actor> void performAs(T actor) {
        // Actor attempts to delete the user from the specified endpoint
        actor.attemptsTo(
                Delete.from("/user/" + user)
        );
    }
}
