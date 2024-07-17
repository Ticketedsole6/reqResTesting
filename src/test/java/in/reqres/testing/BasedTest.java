package in.reqres.testing;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.junit.Before;

public class BasedTest {
    // Base URL for the REST API
    protected static final String restApiUrl = "https://reqres.in/api";
    // Actor representing the tester
    protected Actor tester;

    // Method to set up the tester actor before each test
    @Before
    public void setUp() {
        // Initialize the actor with the name "tester" and the ability to call the REST API at the specified URL
        tester = Actor.named("tester")
                .whoCan(CallAnApi.at(restApiUrl));
    }
}
