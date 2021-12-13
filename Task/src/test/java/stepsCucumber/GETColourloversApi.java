package stepsCucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import org.testng.Assert;
import baseSetup.GETRequest;
import java.util.List;
import static io.restassured.RestAssured.given;

public class GETColourloversApi extends GETRequest {
    static Response response;
    String colourLoversPath = "api/patterns";

    @Given("I send a get request to the URL")
    public void i_send_a_get_request_to_the_url() {
        response = given().spec(SetUpGETRequest()).
                when().get(colourLoversPath);
    }

    @Then("the response will return status code 200")
    public void the_response_will_return_status_code_200() {
        response.then().spec(ReturnGETResponse()).extract().response();

        int responseStatus = response.getStatusCode();
        System.out.println("Status Code is " + responseStatus);
    }

    @And("assert that numViews is greater than 4000")
    public void assert_that_numViews_is_greater_than_4000() {
        XmlPath  responseBody = response.xmlPath();

        List<String> allNumViews = responseBody.getList("patterns.pattern.numViews");

        int i = 1;
        for(String numView : allNumViews)
        {
            int x = Integer.parseInt (numView) ;
            boolean numViews = false;
            if(x > 4000)
            {
                numViews = true;
            }
            System.out.println("The numViews : " + i + " is " + x);
            Assert.assertTrue(numViews);
            i++;
        }

    }


}
