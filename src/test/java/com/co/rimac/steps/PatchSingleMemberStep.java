package com.co.rimac.steps;

import com.co.rimac.pages.PutPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PatchSingleMemberStep {

    private final PutPage putPage = new PutPage();

    @Given("se ingresa la data del usuario PATCH")
    public void se_ingresa_la_data_del_usuario_PUT(DataTable dataTable) {
        putPage.requestBodyService(dataTable);
    }

    @When("se envia un request para crear un nuevo usuario PATCH {int}")
    public void se_envia_un_request_para_crear_un_nuevo_usuario_PATCH(int id) {
        putPage.putService(id);
    }

    @And("se genera el response de PATCH")
    public void se_genera_el_response_PATCH() {
        putPage.putResponseStatus();
    }

    @Then("se validan los datos del response PATCH")
    public void se_validan_los_datos_del_response_PATCH() {
        putPage.putResponseValidate();
    }
}
