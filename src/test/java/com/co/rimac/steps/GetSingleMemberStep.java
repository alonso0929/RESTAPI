package com.co.rimac.steps;

import com.co.rimac.pages.GetPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetSingleMemberStep {

    private final GetPage getPage = new GetPage();

    @Given("los servicios se encuentran funcionando correctamente")
    public void los_servicios_se_encuentran_funcionando_correctamente() {

    }

    @When("se hace una petición GET para obtener el usuario con ID {int}")
    public void se_hace_una_petición_GET_para_obtener_el_usuario_con_ID(int id) {
        getPage.getSingleMember(id);
    }

    @Then("se valida la respuesta con codigo de estado {int}")
    public void se_valida_la_respuesta_con_codigo_de_estado(int statusCode) {

    }
}
