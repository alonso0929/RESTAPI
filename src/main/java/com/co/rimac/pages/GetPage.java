package com.co.rimac.pages;

import static io.restassured.RestAssured.given;

public class GetPage {
    private static final String BASE_URL = "http://localhost:5002/api";

    public void getSingleMember(int id) {
        given()
                .baseUri(BASE_URL)
                .when()
                .get("/members/" + id);
    }

    public void getSingleAuthor(int id) {
        given()
                .baseUri(BASE_URL)
                .when()
                .get("/authors/" + id);
    }
}
