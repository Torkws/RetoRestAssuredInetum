package Inetum.StepDefinitions;

import Inetum.utils.ApiCommons;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.CoreMatchers.*;

import Inetum.questions.*;

public class StepCommons {

    Actor actor;
    @Given("^que el servicio (.*) esta disponible en el ambiente$")
    public void queElServicioEstaDisponibleEnElAmbiente(String actor) {

        OnStage.theActorCalled(actor).whoCan(CallAnApi.at(ApiCommons.BASE_URL));

        System.out.println("El actor " + actor + " puede llamar al API en la URL: " + ApiCommons.BASE_URL);
    }

    @Then("^la respuesta tiene un código de estado (.*)$")
    public void laRespuestaTieneUnCodigoDeEstado(String statusCode) {
        OnStage.theActorInTheSpotlight().should(seeThat("el código de estado de la respuesta",
                responseApiQuestions.getStatusCode(), equalTo(Integer.parseInt(statusCode)))
        );
    }

    @Then("se valida el esquema JSON de la respuesta contra el archivo (.*)$")
    public void seValidaElEsquemaJSONDeLaRespuestaContraElArchivo(String schemaFile) {
        String responseBody = OnStage.theActorInTheSpotlight().recall("RESPONSE_BODY");
        try {
            new ApiCommons().validateJsonSchema(schemaFile);
            System.out.println("El esquema JSON es válido contra el archivo: " + schemaFile);
        } catch (Exception e) {
            throw new AssertionError("La validación del esquema JSON falló: " + e.getMessage(), e);
        }
    }

}
