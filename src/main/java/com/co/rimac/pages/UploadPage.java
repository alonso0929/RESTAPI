package com.co.rimac.pages;

import org.junit.Assert;

import java.io.File;

import static io.restassured.RestAssured.given;

public class UploadPage {

    private File file;
    private int statusCode;
    private static final String BASE_URL = "http://localhost:5002/api";

    public void cargarImagen(String archivo) {
        file = new File(archivo);
    }

    public void uploadImage(String fileName) {
        statusCode = given()
                .multiPart("file", file)
                .multiPart("name", fileName)
                .post(BASE_URL+"/upload")
                .getStatusCode();
    }

    public void validarStatus(int expectedStatusCode) {
        Assert.assertEquals(expectedStatusCode, statusCode);
    }
}
