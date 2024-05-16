package com.co.rimac.pages;

import io.restassured.response.Response;
import org.junit.Assert;

import java.io.File;

import static com.co.rimac.models.Variables.password;
import static com.co.rimac.models.Variables.username;
import static io.restassured.RestAssured.given;

public class UploadPage {
    private static final String BASE_URL = "http://localhost:5002/api";
    private File file;
    private int statusCodePostImage;
    Response responsePostImage;

    public void cargarImagen(String archivo) {
        file = new File(archivo);
    }

    public void uploadImage(String fileName) {
        responsePostImage =
                given()
                        .multiPart("file", file)
                        .multiPart("name", fileName)
                        .baseUri(BASE_URL)
                        .auth()
                        .preemptive()
                        .basic(username, password)
                        .when()

                        .post("/upload")
                        .thenReturn();

        statusCodePostImage = responsePostImage.getStatusCode();
        String responseBody = responsePostImage.getBody().asString();

        System.out.println("Response:");
        System.out.println(responseBody);
    }

    public void validarStatusPostImage(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, statusCodePostImage);
    }
}
