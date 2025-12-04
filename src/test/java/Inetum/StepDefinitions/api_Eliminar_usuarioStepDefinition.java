package Inetum.StepDefinitions;

import Inetum.tasks.DELETE_eliminarUsuario;
import Inetum.utils.ApiCommons;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

public class api_Eliminar_usuarioStepDefinition {
    String idEliminar;
    @And("^se obtiene un id existente de la lista para ser eliminado$")
    public void seObtieneUnIdExistenteDeLaListaParaSerEliminado() {
        this.idEliminar = ApiCommons.GetField_idByList();
    }

    @When("^realizo una eliminación con el parámetro (.*)$")
    public void realizoUnaEliminacionConElParametro(String id) {
        this.idEliminar = id.equalsIgnoreCase("exists") ? this.idEliminar : id;
        this.idEliminar = id.equalsIgnoreCase("random") ? ApiCommons.GenerarDataMock("_id") : this.idEliminar;
        OnStage.theActorInTheSpotlight().attemptsTo(
                DELETE_eliminarUsuario.sending(this.idEliminar)
        );
    }
}