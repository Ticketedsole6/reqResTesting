package in.reqres.testing.models.register;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ResRegisterModel {
    // Field to store the user ID
    private Integer id;
    // Field to store the registration token
    private String token;
}
