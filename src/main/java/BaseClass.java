import Utils.RestAssuredUtils;
import Utils.TestUtils;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

    public Response res = null;
    public JsonPath jp = null;

    TestUtils testUtil = new TestUtils();

    @BeforeMethod
    public void setUp(){
        Utils.RestAssuredUtils.setContentType(ContentType.TEXT);
        Utils.RestAssuredUtils.setBaseURI();
    }

    @AfterMethod
    public void AfterTest(){
        Utils.RestAssuredUtils.resetBasePath();
    }

}
