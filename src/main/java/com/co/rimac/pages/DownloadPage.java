package com.co.rimac.pages;

import io.restassured.response.Response;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class DownloadPage {

    private Response response;

    private static final String BASE_URL = "http://localhost:5002/api";

    public void uploadImage(String fileName) {
        response = given()
                .queryParam("name", fileName)
                .get(BASE_URL+"/download");
    }

    public void validarStatus(int expectedStatusCode) {
        int statusCode = response.getStatusCode();
        Assert.assertEquals(expectedStatusCode, statusCode);
    }
}
