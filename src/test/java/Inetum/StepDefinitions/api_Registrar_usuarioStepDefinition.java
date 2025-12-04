package Inetum.StepDefinitions;

import Inetum.tasks.POST_registrarUsuario;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

public class api_Registrar_usuarioStepDefinition {

    @When("^realizo una nuevo registro con los parámetros (.*) (.*) (.*) (.*)$")
    public void realizoUnNuevoRegistroConLosParametros(String nome, String email, String password, String administrador) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                POST_registrarUsuario.sending(nome, email, password, administrador)
        );
    }
}