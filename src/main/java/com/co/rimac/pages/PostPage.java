package com.co.rimac.pages;

import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static io.restassured.RestAssured.given;

public class PostPage {

    private String requestBody;
    private Response response;

    public void requestBodyService(DataTable dataTable) {
        requestBody = "{\"name\": \"" + dataTable.cell(1, 0) + "\", \"gender\": \"" + dataTable.cell(1, 1) + "\"}";
    }

    public void postService() {
        RestAssured.baseURI = "http://localhost:5002/api";

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/members");
    }

    public void postResponseStatus() {
        response.then().statusCode(201);
    }

    public void postResponseValidate () {
        response.then()
                .body("name", equalTo("Alonso"))
                .body("gender", equalTo("Male"));
    }
}
