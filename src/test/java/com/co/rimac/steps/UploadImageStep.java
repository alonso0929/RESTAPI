package com.co.rimac.steps;

import com.co.rimac.pages.UploadPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UploadImageStep {
    UploadPage uploadPage = new UploadPage();

    @Given("se envia la ruta de la imagen {string}")
    public void se_envia_la_ruta_de_la_imagen(String archivo) {
        uploadPage.cargarImagen(archivo);
    }

    @When("se carga la imagen con el nombre {string} al servidor")
    public void se_carga_la_imagen_con_el_nombre_al_servidor(String nombre) {
        uploadPage.uploadImage(nombre);
    }

    @Then("el servicio cargar responde con status {int}")
    public void el_servidor_responde_con_status(int status) {
        uploadPage.validarStatus(status);
    }
}
