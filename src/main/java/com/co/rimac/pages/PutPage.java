package com.co.rimac.pages;

import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static com.co.rimac.models.Variables.password;
import static com.co.rimac.models.Variables.username;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PutPage {
    private static final String BASE_URL = "http://localhost:5002/api";
    private String requestBody;
    private int statusCodePutMember;
    Response responsePutMember;

    public void requestBodyService(DataTable dataTable) {
        requestBody = "{\"name\": \"" + dataTable.cell(1, 0) + "\", \"gender\": \"" + dataTable.cell(1, 1) + "\"}";
    }

    public void putService(int id) {
        responsePutMember =
                given()
                        .baseUri(BASE_URL)
                        .auth()
                        .preemptive()
                        .basic(username, password)
                        .when()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .put("/members/" + id)
                        .thenReturn();

        statusCodePutMember = responsePutMember.getStatusCode();
        String responseBody = responsePutMember.getBody().asString();

        System.out.println("Response:");
        System.out.println(responseBody);
    }

    public void validarStatusPutMembers(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, statusCodePutMember);
    }

    public void putResponseValidate () {
        responsePutMember.then()
                .body("member.name", equalTo("Alonso PUT"))
                .body("member.gender", equalTo("Male"));
    }
}
