import Utils.ApplicationSteps;
import Utils.PropertyReader;
import Utils.TestUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GetCuisinesTests {

    ApplicationSteps steps = new ApplicationSteps();
    TestUtils testUtil = new TestUtils();
    public Response response = null;
    public JsonPath jp = null;
    PropertyReader prop = new PropertyReader();

    @Test
    public void getCuisinesIds() {
        response = Utils.RestAssuredUtils.getResponse("cuisines?city_id=" + prop.getValue("city_id"));
        testUtil.checkStatusIs200(response);
        jp = Utils.RestAssuredUtils.getJsonPath(response);

        List<String> list = new ArrayList<>();

        List<HashMap<String, HashMap<String, String>>> outerList;
        outerList = jp.get("cuisines");

        for (int i = 0; i < outerList.size(); i++) {
            if (outerList.get(i).get("cuisine").get("cuisine_name").equalsIgnoreCase("Indian")
                    || outerList.get(i).get("cuisine").get("cuisine_name").equalsIgnoreCase("Continental")) {
                list.add(outerList.get(i).get("cuisine").get("cuisine_id"));
                testUtil.updateInAppPropFile("cuisineIds", list.toString());
            }
        }

    }
}
