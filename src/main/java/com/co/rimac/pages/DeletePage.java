package com.co.rimac.pages;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class DeletePage {

    private static final String BASE_URL = "http://localhost:5002/api";

    public void deleteMember(int id) {
        given()
                .baseUri(BASE_URL)
                .contentType(ContentType.JSON)
                .when()
                .delete("/members/" + id);
    }
}
