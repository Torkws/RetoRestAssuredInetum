package Inetum.StepDefinitions;

import Inetum.tasks.GET_listarUsuarios;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;


public class api_Listar_usuariosStepDefinition {


    @When("^realizo una solicitud con los parámetros (.*) (.*) (.*) (.*) (.*)$")
    public void realizoUnaSolicitudConLosParametros(String _id, String nome, String email, String password, String administrador) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GET_listarUsuarios.sending(_id, nome, email, password, administrador)
        );
    }






}
