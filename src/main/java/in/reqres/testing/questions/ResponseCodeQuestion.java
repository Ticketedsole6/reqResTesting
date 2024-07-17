package in.reqres.testing.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResponseCodeQuestion implements Question<Integer> {

    // Static method to create a new instance of ResponseCodeQuestion
    public static Question<Integer> was() {
        return new ResponseCodeQuestion();
    }

    // Method to get the status code of the last response
    @Override
    public Integer answeredBy(Actor actor) {
        // Return the status code of the last REST response
        return SerenityRest.lastResponse().statusCode();
    }
}
