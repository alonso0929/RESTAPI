package com.co.rimac.pages;

import io.restassured.response.Response;
import org.junit.Assert;

import static com.co.rimac.models.Variables.username;
import static com.co.rimac.models.Variables.password;
import static io.restassured.RestAssured.given;

public class GetPage {
    private static final String BASE_URL = "http://localhost:5002/api";
    private int statusCodeGetMember;
    private int statusCodeGetAuthors;
    Response responseGetMember;
    Response responseGetAuthors;

    public void getSingleMember(int id) {
        responseGetMember =
                given()
                        .baseUri(BASE_URL)
                        .auth()
                        .preemptive()
                        .basic(username, password)
                        .when()
                        .get("/members/" + id)
                        .thenReturn();

        statusCodeGetMember = responseGetMember.getStatusCode();
        String responseBody = responseGetMember.getBody().asString();

        System.out.println("Response:");
        System.out.println(responseBody);
    }

    public void validarStatusGetMembers(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, statusCodeGetMember);
    }

    public void getSingleAuthor(int id) {
        responseGetAuthors =
                given()
                        .baseUri(BASE_URL)
                        .auth()
                        .preemptive()
                        .basic(username, password)
                        .when()
                        .get("/authors/" + id)
                        .thenReturn();

        statusCodeGetAuthors = responseGetAuthors.getStatusCode();
        String responseBody = responseGetAuthors.getBody().asString();

        System.out.println("Response:");
        System.out.println(responseBody);
    }

    public void validarStatusGetAuthors(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, statusCodeGetAuthors);
    }
}
