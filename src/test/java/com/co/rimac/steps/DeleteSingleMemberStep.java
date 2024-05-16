package com.co.rimac.steps;

import com.co.rimac.pages.DeletePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DeleteSingleMemberStep {
    private final DeletePage deletePage = new DeletePage();

    @Given("los servicios DELETE Member se encuentran funcionando correctamente")
    public void los_servicios_DELETE_Member_se_encuentran_funcionando_correctamente() {
    }

    @When("se hace una petición DELETE Member para eliminar el usuario con ID {int}")
    public void se_hace_una_petición_DELETE_Member_para_obtener_el_usuario_con_ID(int id) {
        deletePage.deleteMember(id);
        deletePage.deleteResponseValidate(id);
    }

    @Then("se valida la respuesta correcta DELETE Member con codigo de estado {int}")
    public void se_valida_la_respuesta_DELETE_Member_con_codigo_de_estado(int statusCode) {
        deletePage.validarStatusDeleteMembers(statusCode);
    }
}
