package in.reqres.testing.questions;

import in.reqres.testing.models.register.ResRegisterModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResRegisterUserQuestion implements Question<ResRegisterModel> {

    // Method to get the response as a ResRegisterModel object
    @Override
    public ResRegisterModel answeredBy(Actor actor) {
        // Convert the last REST response to a ResRegisterModel object and return it
        return SerenityRest.lastResponse().as(ResRegisterModel.class);
    }
}
