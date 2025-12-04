package Inetum.StepDefinitions;

import Inetum.tasks.GET_buscarUsuarioPorID;
import Inetum.utils.ApiCommons;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

public class api_Buscar_usuario_por_IDStepDefinition {

    @When("^realizo una busqueda por id con el parámetro (.*)$")
    public void realizoUnaBusquedaPorIdConElParametro(String id) {
        id = id.equalsIgnoreCase("random") ? ApiCommons.GenerarDataMock("_id") : id;

        OnStage.theActorInTheSpotlight().attemptsTo(
                GET_buscarUsuarioPorID.sending(id)
        );
    }
}