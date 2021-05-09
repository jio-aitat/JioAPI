package helpers;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Every Api Step definition class should extend this class
 */

public class ApiHelper {
    private static final Logger LOG = LoggerFactory.getLogger(ApiHelper.class);
    private static Gson gson;
    private static String environment = Props.getProp("environment");
    public static RequestSpecification requestSpecification;
    public static String generatedToken;
    public static Response response;
    public static String strResponse;
    public static JsonPath jsonPath;

    static {
        switch (environment) {
            case "dev":
                RestAssured.baseURI = Props.getProp("dev");

                break;
            case "stage":
                RestAssured.baseURI = Props.getProp("stage");
                break;
            case "preprod":
                RestAssured.baseURI = Props.getProp("preprod");
                break;
            case "prod":
                RestAssured.baseURI = Props.getProp("prod");
                System.out.println(Props.getProp("prod"));
                break;
            default:
                LOG.info("No Environment selected");
        }
        RestAssured.basePath = Props.getProp("basePath");
    }


    public static void setRequestSpecification() {
        requestSpecification = RestAssured.given().
                header("Accept-Language", "en").header("Content-Type", "application/json");
    }


    public static void setRequestSpecification(String parameter, String parameterValue) {
        requestSpecification = RestAssured.given().
                header("Accept-Language", "en").header("Content-Type", "application/json")
                .param(parameter, parameterValue);
    }


    //Specify all one time default Gson config
    public static Gson gson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gson = gson(gsonBuilder);
        return gson;
    }

    //Custom Gson config to override Default Gson  configuration
    public static Gson gson(GsonBuilder gsonBuilder) {
        gson = gsonBuilder.create();
        return gson;
    }

    public static void getToken(String endPoint) {
        String reqBodyForAccessToken = "{\n" +
                "  \"userName\": \"TOOLSQA-Test\",\n" +
                "  \"password\": \"Test@@123\"\n" +
                "}";
        requestSpecification = RestAssured.given()
                .body(reqBodyForAccessToken);
    }


}