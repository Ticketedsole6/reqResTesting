package in.reqres.testing.tasks;

import in.reqres.testing.models.TestDataModel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Load implements Task {

    private final Map<String, String> testData;

    public Load(Map<String, String> testData) {
        this.testData = testData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        Set<Map.Entry<String, String>> testdataAux = testData.entrySet();
        TestDataModel.setData(testdataAux.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }

    public static Load testData(Map<String, String> testData) {
        return Tasks.instrumented(Load.class, testData);
    }
}
