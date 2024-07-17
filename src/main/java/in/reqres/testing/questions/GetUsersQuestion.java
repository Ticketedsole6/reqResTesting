package in.reqres.testing.questions;

import in.reqres.testing.models.users.UsersModel;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetUsersQuestion implements Question<UsersModel> {

    // Method to get the response as a UsersModel object
    @Override
    public UsersModel answeredBy(Actor actor) {
        // Convert the last REST response to a UsersModel object and return it
        return SerenityRest.lastResponse().as(UsersModel.class);
    }
}
