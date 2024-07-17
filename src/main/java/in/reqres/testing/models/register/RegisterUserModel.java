package in.reqres.testing.models.register;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class RegisterUserModel {
    // Field to store the user's email address
    private String email;
    // Field to store the user's password
    private String password;
}
