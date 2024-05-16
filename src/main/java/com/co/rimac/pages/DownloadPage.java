package com.co.rimac.pages;

import io.restassured.response.Response;
import org.junit.Assert;

import static com.co.rimac.models.Variables.password;
import static com.co.rimac.models.Variables.username;
import static io.restassured.RestAssured.given;

public class DownloadPage {
    private static final String BASE_URL = "http://localhost:5002/api";
    private int statusCodeGetImage;
    Response responseGetImage;

    public void downloadImage(String fileName) {
        responseGetImage =
                given()
                        .queryParam("name", fileName)
                        .baseUri(BASE_URL)
                        .auth()
                        .preemptive()
                        .basic(username, password)
                        .when()
                        .get("/download")
                        .thenReturn();

        statusCodeGetImage = responseGetImage.getStatusCode();
    }

    public void validarStatusPostImage(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, statusCodeGetImage);
    }
}
