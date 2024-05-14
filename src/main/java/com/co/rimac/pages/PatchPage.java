package com.co.rimac.pages;

import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PatchPage {

    private String requestBody;
    private Response response;

    public void requestBodyService(DataTable dataTable) {
        requestBody = "{\"name\": \"" + dataTable.cell(1, 0) + "\", \"gender\": \"" + dataTable.cell(1, 1) + "\"}";
    }

    public void patchService(int id) {
        RestAssured.baseURI = "http://localhost:5002/api";

        response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .put("/members" + id);
    }

    public void patchResponseStatus() {
        response.then().statusCode(200);
    }

    public void patchResponseValidate () {
        response.then()
                .body("name", equalTo("Alonso"))
                .body("gender", equalTo("Male"));
    }
}
