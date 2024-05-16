package com.co.rimac.pages;

import io.cucumber.datatable.DataTable;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;

import static com.co.rimac.models.Variables.password;
import static com.co.rimac.models.Variables.username;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PatchPage {
    private static final String BASE_URL = "http://localhost:5002/api";
    private String requestBody;
    private int statusCodePatchMember;
    Response responsePatchMember;

    public void requestBodyService(DataTable dataTable) {
        requestBody = "{\"name\": \"" + dataTable.cell(1, 0) + "\", \"gender\": \"" + dataTable.cell(1, 1) + "\"}";
    }

    public void patchService(int id) {
        responsePatchMember =
                given()
                        .baseUri(BASE_URL)
                        .auth()
                        .preemptive()
                        .basic(username, password)
                        .when()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .patch("/members/" + id)
                        .thenReturn();

        statusCodePatchMember = responsePatchMember.getStatusCode();
        String responseBody = responsePatchMember.getBody().asString();

        System.out.println("Response:");
        System.out.println(responseBody);
    }

    public void validarStatusPatchMembers(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, statusCodePatchMember);
    }

    public void patchResponseValidate () {
        responsePatchMember.then()
                .body("member.name", equalTo("Alonso PATCH"))
                .body("member.gender", equalTo("Male"));
    }
}
