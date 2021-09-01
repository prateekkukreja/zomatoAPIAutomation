package Utils;

import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestUtils {

    private String FilePath = "/Users/prateek/Documents/ZomatoRecommendation/src/main/resources/application.properties";

    public void checkStatusIs200(Response response) {
        Assert.assertEquals(response.getStatusCode(), 200, "Status check failed");
    }

    public void updateInAppPropFile(String key, String str) {
        try {
            Stream<String> lines = Files.lines(Paths.get(FilePath));
            List<String> replace = lines.map(line -> line.replaceAll(key + "=", str)).collect(Collectors.toList());
            Files.write(Paths.get(FilePath), replace);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
