package com.co.rimac.pages;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static com.co.rimac.models.Variables.password;
import static com.co.rimac.models.Variables.username;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class DeletePage {
    private static final String BASE_URL = "http://localhost:5002/api";
    private int statusCodeDeleteMember;
    Response responseDeleteAuthors;

    public void deleteMember(int id) {
        responseDeleteAuthors =
                given()
                        .baseUri(BASE_URL)
                        .auth()
                        .preemptive()
                        .basic(username, password)
                        .when()
                        .delete("/members/" + id)
                        .thenReturn();

        statusCodeDeleteMember = responseDeleteAuthors.getStatusCode();
        String responseBody = responseDeleteAuthors.getBody().asString();

        System.out.println("Response:");
        System.out.println(responseBody);
    }

    public void validarStatusDeleteMembers(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, statusCodeDeleteMember);
    }

    public void deleteResponseValidate(int id) {
        responseDeleteAuthors.then()
                .body("msg", equalTo("Member with id "+id+" is deleted successfully"));
    }
}
