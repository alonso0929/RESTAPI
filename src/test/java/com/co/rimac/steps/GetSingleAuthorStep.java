package com.co.rimac.steps;

import com.co.rimac.pages.GetPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetSingleAuthorStep {

    private final GetPage getPage = new GetPage();

    @Given("los servicios GET Author se encuentran funcionando correctamente")
    public void los_servicios_GET_Author_se_encuentran_funcionando_correctamentea() {
    }

    @When("se hace una petición GET Author para obtener el usuario con ID {int}")
    public void se_hace_una_petición_GET_Author_para_obtener_el_usuario_con_ID(int id) {
        getPage.getSingleAuthor(id);
    }

    @Then("se valida la respuesta correcta GET Author con codigo de estado {int}")
    public void se_valida_la_respuesta_correcta_GET_Author_con_codigo_de_estado(int statusCode) {
        getPage.validarStatusGetAuthors(statusCode);
    }
}
