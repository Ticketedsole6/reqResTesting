package in.reqres.testing;

import in.reqres.testing.models.register.RegisterUserModel;
import in.reqres.testing.models.register.ResRegisterModel;
import in.reqres.testing.models.update.ResponseUpdateModel;
import in.reqres.testing.models.update.UpdateUserModel;
import in.reqres.testing.models.users.DatumModel;
import in.reqres.testing.questions.ResRegisterUserQuestion;
import in.reqres.testing.questions.ResUpdateUserQuestion;
import in.reqres.testing.tasks.DeleteUserTask;
import in.reqres.testing.tasks.UpdateUserTask;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import in.reqres.testing.questions.GetUsersQuestion;
import in.reqres.testing.questions.ResponseCodeQuestion;
import in.reqres.testing.tasks.GetUsersTask;
import in.reqres.testing.tasks.RegisterUserTask;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(SerenityRunner.class)
public class SerenityInitialTests extends BasedTest {

    @Test
    public void getUsersTestSuccessful() {
        // Perform the task to get users from page 2
        tester.attemptsTo(
                GetUsersTask.fromPage(2)
        );

        // Verify that the response code is 200
        tester.should(
                seeThat("Response Code", ResponseCodeQuestion.was(), equalTo(200))
        );

        // Extract the user with ID 7 from the response
        DatumModel user = new GetUsersQuestion().answeredBy(tester)
                .getData().stream().filter(x -> x.getId() == 7).findFirst().orElse(null);

        // Verify that the user with ID 7 is not null
        tester.should(
                seeThat("User", act -> user, notNullValue())
        );

        // Verify that the email of the user with ID 7 is as expected
        tester.should(
                seeThat("User's Email", act -> {
                    assert user != null;
                    return user.getEmail();
                }, equalTo("michael.lawson@reqres.in"))
        );
    }

    @Test
    public void RegisterUserTestSuccessful() {
        // Create and set up the model for registering a user
        RegisterUserModel registerUserInfo = RegisterUserModel.builder()
                .email("tobias.funke@reqres.in")
                .password("pistol")
                .build();

        ResRegisterModel resRegisterModel = ResRegisterModel.builder()
                .id(9)
                .token("QpwL5tke4Pnpja7X9")
                .build();

        // Perform the task to register a user with the provided information
        tester.attemptsTo(
                RegisterUserTask.withInfo(registerUserInfo)
        );

        // Verify that the response code is 200
        tester.should(
                seeThat("Response Code", ResponseCodeQuestion.was(), equalTo(200))
        );

        // Extract the response of the register user action
        ResRegisterModel responseRegisterUser = new ResRegisterUserQuestion().answeredBy(tester);

        // Verify that the response body is not null
        tester.should(
                seeThat("Response body", act -> responseRegisterUser, notNullValue())
        );

        // Verify that the id in the response is as expected
        tester.should(
                seeThat("Response id", act -> responseRegisterUser.getId(), equalTo(resRegisterModel.getId()))
        );

        // Verify that the token in the response is as expected
        tester.should(
                seeThat("Response token", act -> responseRegisterUser.getToken(), equalTo(resRegisterModel.getToken()))
        );
    }

    @Test
    public void UpdateUserTestSuccessful() {
        // Create and set up the model for updating a user
        UpdateUserModel UpdateUserInfo = UpdateUserModel.builder()
                .name("morpheus")
                .job("zion resident")
                .build();

        // Perform the task to update the user with the provided information
        tester.attemptsTo(
                UpdateUserTask.withInfo(UpdateUserInfo)
        );

        // Verify that the response code is 200
        tester.should(
                seeThat("Response Code", ResponseCodeQuestion.was(), equalTo(200))
        );

        // Extract the response of the update user action
        ResponseUpdateModel responseUpdateUser = new ResUpdateUserQuestion().answeredBy(tester);

        // Verify that the response body is not null
        tester.should(
                seeThat("Response body", act -> responseUpdateUser, notNullValue())
        );

        // Verify that the updated user's name is as expected
        tester.should(
                seeThat("User Name", act -> responseUpdateUser.getName(), equalTo(UpdateUserInfo.getName()))
        );

        // Verify that the updated user's job is as expected
        tester.should(
                seeThat("User Name", act -> responseUpdateUser.getJob(), equalTo(UpdateUserInfo.getJob()))
        );
    }

    @Test
    public void DeleteUserTestSuccessful() {
        // Perform the task to delete the user with ID 2
        tester.attemptsTo(
                DeleteUserTask.fromUser(2)
        );

        // Verify that the response code is 204 (No Content)
        tester.should(
                seeThat("Response Code", ResponseCodeQuestion.was(), equalTo(204))
        );
    }
}
