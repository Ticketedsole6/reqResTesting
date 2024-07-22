package in.reqres.testing.tasks;

import in.reqres.testing.interactions.ExecutePost;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Tasks;

import static in.reqres.testing.utils.constants.Constants.BODY;

public class ConsumePost implements Task {
    private final String resource;

    public ConsumePost(String resource) {
        this.resource = resource;
    }

    public static ConsumePost service(String resource) {
        return Tasks.instrumented(ConsumePost.class, resource);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String body = actor.recall(BODY).toString();
        actor.attemptsTo(ExecutePost.service(resource, body));
    }
}
