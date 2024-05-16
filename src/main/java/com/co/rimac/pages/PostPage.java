package com.co.rimac.pages;

import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static com.co.rimac.models.Variables.password;
import static com.co.rimac.models.Variables.username;
import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class PostPage {
    private static final String BASE_URL = "http://localhost:5002/api";
    private String requestBody;
    private int statusCodePostMember;
    Response responsePostMember;

    public void requestBodyService(DataTable dataTable) {
        requestBody = "{\"name\": \"" + dataTable.cell(1, 0) + "\", \"gender\": \"" + dataTable.cell(1, 1) + "\"}";
    }

    public void postService() {
        responsePostMember =
                given()
                        .baseUri(BASE_URL)
                        .auth()
                        .preemptive()
                        .basic(username, password)
                        .when()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .post("/members")
                        .thenReturn();

        statusCodePostMember = responsePostMember.getStatusCode();
        String responseBody = responsePostMember.getBody().asString();

        System.out.println("Response:");
        System.out.println(responseBody);
    }

    public void validarStatusPostMembers(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, statusCodePostMember);
    }

    public void patchResponseValidate () {
        responsePostMember.then()
                .body("name", equalTo("Alonso"))
                .body("gender", equalTo("Male"));
    }
}
