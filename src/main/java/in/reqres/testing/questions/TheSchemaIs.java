package in.reqres.testing.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TheSchemaIs implements Question {

    private final String structure;

    public TheSchemaIs(String structure) {
        this.structure = structure;
    }

    @Override
    public Object answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("The schema is as expected",
                        response -> response
                                .assertThat()
                                .body(matchesJsonSchemaInClasspath("schemas/" + structure + ".json"))
                )
        );
        return true;
    }

    public static TheSchemaIs expected(String schemeResponse) {
        return new TheSchemaIs(schemeResponse);
    }
}
