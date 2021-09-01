import Utils.ApplicationSteps;
import Utils.PropertyReader;
import Utils.TestUtils;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ZomatoRestSearchApi {

    ApplicationSteps steps = new ApplicationSteps();
    TestUtils testUtil = new TestUtils();
    public Response response = null;
    public JsonPath jp = null;
    PropertyReader prop = new PropertyReader();
    HashMap<String, Object> map = new HashMap<>();

    public void doSearch() {
        map.put("count", 5);
        map.put("cuisine", prop.getValue("cuisineIds"));
        steps.setQueryParams(map);
        response = Utils.RestAssuredUtils.getResponse("search");

        testUtil.checkStatusIs200(response);
        jp = Utils.RestAssuredUtils.getJsonPath(response);

        List<String> list = new ArrayList<>();

        List<HashMap<String, HashMap<String, String>>> outerList;
        outerList = jp.get("cuisines");

    }


//    curl -X 'GET' \
//            'https://developers.zomato.com/api/v2.1/search?count=5&cuisine=35%2C%20148' \
//            -H 'accept: application/json' \
//            -H 'user-key: 4bd8b592e55054458e37c284ae9459f1'

}
