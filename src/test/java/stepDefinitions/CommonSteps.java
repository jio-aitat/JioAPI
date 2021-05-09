package stepDefinitions;

import helpers.ApiHelper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;

public class CommonSteps extends ApiHelper {

    @Given("user hit to end point {string} with get method")
    public void userHitToEndPointWithGetMethod(String endPoint) {
        setRequestSpecification();
        response = requestSpecification.get(endPoint);
    }

    @Then("user should able to see the status as {int}")
    public void userShouldAbleToSeeTheStatusAs(int statusCode) {
        System.out.println("the status code: " + response.statusCode());
    }

    @And("user validates response")
    public void userValidatesResponse() {
        System.out.println("Response Validation: " + response.asPrettyString());
    }

    @And("user validates the data {string} from the response")
    public void userValidatesTheDataFromTheResponse(String expectedValue) {
        jsonPath = new JsonPath(response.asString());
        String actualValue = jsonPath.getString("total_pages");
        System.out.println("Total Pages " + actualValue);
        System.out.println(actualValue.equals(expectedValue));
    }

    @Given("user hit to end point {string} with get method with query parameters {string} as {string}")
    public void userHitToEndPointWithGetMethodWithQueryParametersAs(String endPoint, String param, String paramValue) {
        response = requestSpecification.when().get(endPoint);
        System.out.println(strResponse);
    }

    @Given("user has parameters {string} as {string}")
    public void userHasParametersAs(String parameter, String parameterValue) {
        setRequestSpecification(parameter, parameterValue);
    }

    @Then("users hit to end point {string} with get method")
    public void usersHitToEndPointWithGetMethod(String endPoint) {
        response = requestSpecification.get(endPoint);
    }

    @Given("user has access token")
    public void userHasAccessToken() {
        response = requestSpecification.post("Account/v1/GenerateToken");
        System.out.println("token" + response.asPrettyString());
    }
}
