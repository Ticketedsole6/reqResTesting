package in.reqres.testing.models.update;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class UpdateUserModel {
    // Field to store the name of the user
    private String name;
    // Field to store the job title of the user
    private String job;
}
