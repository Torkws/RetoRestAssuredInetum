package Inetum.StepDefinitions;

import Inetum.tasks.POST_registrarUsuario;
import Inetum.utils.ApiCommons;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

public class api_Registrar_usuarioStepDefinition {


    @When("^realizo una nuevo registro con los parámetros (.*) (.*) (.*) (.*)$")
    public void realizoUnNuevoRegistroConLosParametros(String nome, String email, String password, String administrador) {
        nome = nome.equalsIgnoreCase("random") ? ApiCommons.GenerarDataMock("nome") : nome;
        email = email.equalsIgnoreCase("random") ? ApiCommons.GenerarDataMock("email") : email;
        password = password.equalsIgnoreCase("random") ? ApiCommons.GenerarDataMock("password") : password;
        administrador = administrador.equalsIgnoreCase("random") ? ApiCommons.GenerarDataMock("administrador"): administrador;
        OnStage.theActorInTheSpotlight().attemptsTo(
                POST_registrarUsuario.sending(nome, email, password, administrador)
        );
    }



}