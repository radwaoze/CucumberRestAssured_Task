package baseSetup;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class GETRequest extends AbstractTestNGCucumberTests {

    protected static RequestSpecification reqSpec;
    protected static ResponseSpecification resSpec;

    private void RequestExtension() {

    }

    public static RequestSpecification SetUpGETRequest() {
        RequestSpecBuilder reqBuilder = new RequestSpecBuilder();

        reqBuilder.addHeader("Accept-Encoding", "gzip, deflate, br");
        reqBuilder.addHeader("Accept", "*/*");
        reqBuilder.addHeader("Connection", "keep-alive");
        reqBuilder.addHeader("User-Agent", "PostmanRuntime/7.28.4");
        reqBuilder.setBaseUri("http://www.colourlovers.com/");
        reqSpec = reqBuilder.build();
        return reqSpec;
    }
    public static ResponseSpecification ReturnGETResponse() {
        ResponseSpecBuilder resBuilder = new ResponseSpecBuilder();
        resBuilder.expectStatusCode(200);
        resSpec = resBuilder.build();
        return resSpec;
    }
}
