package in.reqres.testing.tasks;

import in.reqres.testing.interactions.ExecuteDelete;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsumeDelete implements Task {

    private final String resource;
    private final String id;

    public ConsumeDelete(String resource, String id) {
        this.resource = resource;
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(ExecuteDelete.service(resource + "/" + id));
    }

    public static ConsumeDelete service(String resource, String id) {
        return instrumented(ConsumeDelete.class, resource, id);
    }
}
