package in.reqres.testing.tasks;

import in.reqres.testing.interactions.ExecutePut;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import static in.reqres.testing.utils.constants.Constants.BODY;

public class ConsumePut implements Task {
    private final String resource;
    private final String id;

    public ConsumePut(String resource, String id) {
        this.resource = resource;
        this.id = id;
    }

    public static ConsumePut service(String resource, String id) {
        return Tasks.instrumented(ConsumePut.class, resource, id);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        String path = resource + "/" + id;
        String body = actor.recall(BODY).toString();
        actor.attemptsTo(ExecutePut.service(path, body));
    }
}
