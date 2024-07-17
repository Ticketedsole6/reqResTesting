package in.reqres.testing.questions;

import in.reqres.testing.models.update.ResponseUpdateModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ResUpdateUserQuestion implements Question<ResponseUpdateModel> {

    // Method to get the response as a ResponseUpdateModel object
    @Override
    public ResponseUpdateModel answeredBy(Actor actor) {
        // Convert the last REST response to a ResponseUpdateModel object and return it
        return SerenityRest.lastResponse().as(ResponseUpdateModel.class);
    }
}
