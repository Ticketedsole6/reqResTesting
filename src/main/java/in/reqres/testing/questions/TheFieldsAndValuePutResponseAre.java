package in.reqres.testing.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class TheFieldsAndValuePutResponseAre implements Question {
    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Keys and Values are as expected",
                        response -> response
                                .assertThat()
                                .and().body("name", equalTo("morpheus"))
                                .and().body("job", equalTo("zion resident"))
                )
        );
        return true;
    }

    public static TheFieldsAndValuePutResponseAre expected() {
        return new TheFieldsAndValuePutResponseAre();
    }
}
