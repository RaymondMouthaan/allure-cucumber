package org.mouthaan.demo.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.StringUtils;

import java.net.URI;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class BookByISBNSteps {
    private static final URI ENDPOINT_GET_BOOK_BY_ISBN = URI.create("https://www.googleapis.com/books/v1/volumes");

    private RequestSpecification requestSpecification;
    private Response response;
    private ValidatableResponse validatableResponse;

    @Given("a book exists with an isbn of {string}")
    public void aBookExistsWithAnIsbnOf(final String isbn) {
        requestSpecification = given().param("q", "isbn:" + isbn);
    }

    @When("a user retrieves the book by isbn")
    public void aUserRetrievesTheBookByIsbn() {
        response = requestSpecification.when().get(ENDPOINT_GET_BOOK_BY_ISBN);
    }

    @Then("the status code is {int}")
    public void theStatusCodeIs(int statusCode) {
        validatableResponse = response.then().statusCode(statusCode);
    }

    @And("response includes the following")
    public void responseIncludesTheFollowing(Map<String, String> responseFields) {
        responseFields.forEach((k, v) -> {
            if (StringUtils.isNumeric(v)) {
                validatableResponse.body(k, equalTo(Integer.parseInt(v)));
            } else {
                validatableResponse.body(k, equalTo(v));
            }
        });
    }

    @And("response includes the following in any order")
    public void responseIncludesTheFollowingInAnyOrder(Map<String, String> responseFields) {
        responseFields.forEach((k, v) -> {
            if (StringUtils.isNumeric(v)) {
                validatableResponse.body(k, containsInAnyOrder(Integer.parseInt(v)));
            } else {
                validatableResponse.body(k, containsInAnyOrder(v));
            }
        });
    }
}
