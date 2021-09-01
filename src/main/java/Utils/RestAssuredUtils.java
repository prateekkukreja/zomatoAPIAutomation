package Utils;

import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RestAssuredUtils {

    public static void setBaseURI(){
        RestAssured.baseURI = "https://developers.zomato.com/api/v2.1/";
    }

    public static void setBasePath(String urlPath){
        RestAssured.basePath = urlPath;
    }

    public static void resetBasePath(){
        RestAssured.basePath = null;
    }

    public static void setContentType(ContentType type){
        given().contentType(type);
    }

    public static Response getResponse(String path){
        return given().get(path);
    }

    public static Response getResponse(){
        return given().get();
    }

    public static void setHeader(){
        given().header("accept", "application/json");
        given().header("user-key", "4bd8b592e55054458e37c284ae9459f1");
    }

    //return jsonPath resp
    public static JsonPath getJsonPath(Response response){
        String json = response.asString();
        return new JsonPath(json);
    }

}
