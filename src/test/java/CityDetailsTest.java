import Utils.ApplicationSteps;
import Utils.TestUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CityDetailsTest extends BaseClass {

    ApplicationSteps steps = new ApplicationSteps();
    TestUtils testUtil = new TestUtils();
    public Response response = null;
    public JsonPath jp = null;

    @Test
    public void getCategoryID() {
        //     steps.setAPIUrl("categories");
        steps.setQueryParams(null);
        response = Utils.RestAssuredUtils.getResponse("categories");
        testUtil.checkStatusIs200(response);
        jp = Utils.RestAssuredUtils.getJsonPath(response);

        List<HashMap<String, HashMap<String, String>>> list = new ArrayList<>();
        list = jp.get("categories");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).get("categories").get("name").equalsIgnoreCase("Dine-out")) {
                testUtil.updateInAppPropFile("categories", list.get(i).get("categories").get("id").toString());
            }
        }
    }


}
