package com.co.rimac.steps;

import com.co.rimac.pages.DownloadPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DownloadImageStep {

    DownloadPage downloadPage = new DownloadPage();

    @Given("el servicio esta configurado correctamente")
    public void el_servicio_esta_configurado_correctamente() {
    }

    @When("se descarga la imagen con el nombre {string}")
    public void se_descarga_la_imagen_con_el_nombre(String nombre) {
        downloadPage.uploadImage(nombre);
    }

    @Then("el servicio descargar responde con status {int}")
    public void el_servidor_descargar_responde_con_status(int status) {
        downloadPage.validarStatus(status);
    }
}
