package in.reqres.testing.models.users;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DatumModel {
    // Field to store the user's ID
    private Integer id;
    // Field to store the user's email
    private String email;
    // Field to store the user's first name
    private String firstName;
    // Field to store the user's last name
    private String lastName;
    // Field to store the user's avatar URL
    private String avatar;
}
