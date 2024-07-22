package in.reqres.testing.exceptions;

public class AssertionsServices extends AssertionError {

    private static final long serialVersionUID = 1L;

    public static final String THE_STATUS_CODE_SERVICE_IS_NOT_EXPECTED = "The status code is not expected";

    public static final String FIELDS_QUANTITY_IS_NOT_EXPECTED = "The fields quantity is not expected";

    public static final String SCHEMA_IS_NOT_EXPECTED = "The schema is not expected";

    public static final String RESPONSE_CONTAINS_IS_NOT_EXPECTED = "The response contains is not expected";

    public AssertionsServices(String message, Throwable cause) {
        super(message, cause);
    }

    public AssertionsServices(String message) {
        super(message);
    }
}
