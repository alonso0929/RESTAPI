package com.co.rimac.steps;

import com.co.rimac.pages.PostPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PostCreateNewMemberStep {
    private final PostPage postPage = new PostPage();

    @Given("se ingresa la data del usuario")
    public void se_ingresa_la_data_del_usuario(DataTable dataTable) {
        postPage.requestBodyService(dataTable);
    }

    @When("se envia un request para crear un nuevo usuario")
    public void se_envia_un_request_para_crear_un_nuevo_usuario() {
        postPage.postService();
    }

    @And("se genera el response {int}")
    public void se_genera_el_response(int statusCode) {
        postPage.validarStatusPostMembers(statusCode);
    }

    @Then("se validan los datos del response")
    public void se_validan_los_datos_del_response() {
        postPage.patchResponseValidate();
    }
}
