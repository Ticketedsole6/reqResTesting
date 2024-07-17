package in.reqres.testing.models.users;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class UsersModel {
    // Field to store the current page number
    private Integer page;
    // Field to store the number of items per page
    private Integer perPage;
    // Field to store the total number of items
    private Integer total;
    // Field to store the total number of pages
    private Integer totalPages;
    // Field to store a list of DatumModel objects representing user data
    private List<DatumModel> data;
    // Field to store support information
    private SupportModel support;
}
