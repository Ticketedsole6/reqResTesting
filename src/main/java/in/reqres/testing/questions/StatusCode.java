package in.reqres.testing.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class StatusCode implements Question {

    private final int code;

    public StatusCode(int statusCode) {
        this.code = statusCode;
    }

    @Override
    public Object answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("The response code is as expected",
                        response -> response
                                .statusCode(code))
        );
        return true;
    }

    public static StatusCode is(int statusCode) {
        return new StatusCode(statusCode);
    }
}
