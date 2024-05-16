package com.co.rimac.steps;

import com.co.rimac.pages.GetPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetSingleMemberStep {
    private final GetPage getPage = new GetPage();

    @Given("los servicios GET Member se encuentran funcionando correctamente")
    public void los_servicios_GET_Member_se_encuentran_funcionando_correctamente() {
    }

    @When("se hace una petición GET Member para obtener el usuario con ID {int}")
    public void se_hace_una_petición_GET_Member_para_obtener_el_usuario_con_ID(int id) {
        getPage.getSingleMember(id);
    }

    @Then("se valida la respuesta correcta GET Member con codigo de estado {int}")
    public void se_valida_la_respuesta_GET_Member_con_codigo_de_estado(int statusCode) {
        getPage.validarStatusGetMembers(statusCode);
    }
}
