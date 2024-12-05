package org.bhekumuzi.stepDefinitions;
import io.cucumber.java.en.*;
import io.cucumber.java.zh_cn.假如;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.bhekumuzi.Resources.APIResources;
import org.bhekumuzi.Resources.PayLoads;
import org.bhekumuzi.Resources.Utils;
import org.testng.Assert;

import java.io.IOException;
import java.util.Locale;

public class StepDefinitions extends Utils {
    private RequestSpecification request;

    private final PayLoads payLoads = new PayLoads();
    private Response response;


    @Given("a Create booking payload {string}")
    public void aCreateBookingPayload(String boardName) throws IOException {
        payLoads.createBoardPayload(boardName, "");
        request = RestAssured.given()
                .relaxedHTTPSValidation()
                .spec(RestAssuredRequestSpecification())
                .body(payLoads.createBoardPayload(boardName,""))
                .log().all();
    }

    @When("the user sends a {string} request to the {string}")
    public void aUserSendsARequest(String method, String resource) throws IOException {
        APIResources apiResource = APIResources.valueOf(resource);
        switch (method.toUpperCase().trim()){
            case "POST":
                response = request.when().post(apiResource.getResource());
            case "GET":
            default:
                break;
        }

    }


    @Then("the API call is successful with a status code {string}")
    public void theAPICallIsSuccessfulWithAStatusCode(String statusCode) {
        Assert.assertEquals(response.statusCode(), Integer.parseInt(statusCode) ,"Status code is not as expected");
    }
}
