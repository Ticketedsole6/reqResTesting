package in.reqres.testing.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;
import static org.hamcrest.Matchers.equalTo;

public class TheFieldsAndValueGetResponseAre implements Question {


    @Override
    public Boolean answeredBy(Actor actor) {
        actor.should(
                seeThatResponse("Keys and Values are as expected",
                        response -> response
                                .assertThat()
                                .and().body("data.id", equalTo(2))
                                .and().body("data.email", equalTo("janet.weaver@reqres.in"))
                                .and().body("data.first_name", equalTo("Janet"))
                                .and().body("data.last_name", equalTo("Weaver"))
                                .and().body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"))
                                .and().body("support.url", equalTo("https://reqres.in/#support-heading"))
                                .and().body("support.text", equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"))
                )
        );
        return true;
    }

    public static TheFieldsAndValueGetResponseAre expected() {
        return new TheFieldsAndValueGetResponseAre();
    }
}
