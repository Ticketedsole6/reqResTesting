package in.reqres.testing.models.update;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ResponseUpdateModel {
    // Field to store the name of the user
    private String name;
    // Field to store the job title of the user
    private String job;
    // Field to store the timestamp when the user was last updated
    private String updatedAt;
}
