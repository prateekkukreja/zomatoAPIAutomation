package Utils;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class ApplicationSteps {

    public void setAPIUrl(String path) {
        Utils.RestAssuredUtils.setBasePath(path);
    }

//    public void setHeaders(String path) {
//        Utils.RestAssuredUtils.setBasePath(path);
//    }

    public void setQueryParams(HashMap<String, Object> map) {
        if (!map.isEmpty()) {

            for (Map.Entry<String, Object> set : map.entrySet()) {
                given().queryParam(set.getKey().toString(), set.getValue().toString());
            }
        }
    }
}
