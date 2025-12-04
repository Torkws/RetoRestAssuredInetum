package Inetum.StepDefinitions;

import Inetum.tasks.PUT_actualizarUsuario;
import Inetum.utils.ApiCommons;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

public class api_Actualizar_usuarioStepDefinition {

    @When("^realizo una actualización con el parámetro (.*) y el cuerpo: (.*) (.*) (.*) (.*)$")
    public void realizoUnaActualizacionConElParametroYCuerpo(String id, String nome, String email, String password, String administrador) {
        id = id.equalsIgnoreCase("random") ? ApiCommons.GenerarDataMock("_id") : id;
        nome = nome.equalsIgnoreCase("random") ? ApiCommons.GenerarDataMock("nome") : nome;
        email = email.equalsIgnoreCase("random") ? ApiCommons.GenerarDataMock("email") : email;
        password = password.equalsIgnoreCase("random") ? ApiCommons.GenerarDataMock("password") : password;
        administrador = administrador.equalsIgnoreCase("random") ? ApiCommons.GenerarDataMock("administrador"): administrador;

        OnStage.theActorInTheSpotlight().attemptsTo(
                PUT_actualizarUsuario.sending(id, nome, email, password, administrador)
        );
    }
}