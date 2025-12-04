package Inetum.StepDefinitions;

import Inetum.tasks.POST_registrarUsuario;
import com.github.javafaker.Faker;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;

public class api_Registrar_usuarioStepDefinition {


    @When("^realizo una nuevo registro con los parámetros (.*) (.*) (.*) (.*)$")
    public void realizoUnNuevoRegistroConLosParametros(String nome, String email, String password, String administrador) {
        nome = nome.equalsIgnoreCase("random") ? GenerarDataMock("nome") : nome;
        email = email.equalsIgnoreCase("random") ? GenerarDataMock("email") : email;
        password = password.equalsIgnoreCase("random") ? GenerarDataMock("password") : password;
        administrador = administrador.equalsIgnoreCase("random") ? GenerarDataMock("administrador"): administrador;
        OnStage.theActorInTheSpotlight().attemptsTo(
                POST_registrarUsuario.sending(nome, email, password, administrador)
        );
    }

    public String GenerarDataMock (String fieldName) {
        Faker faker = new Faker();
        switch (fieldName.toLowerCase()) {
            case "nome":
                return faker.name().fullName();
            case "email":
                return faker.internet().emailAddress();
            case "password":
                return faker.internet().password(8, 16); // Generates a password with 8-16 characters
            case "administrador":
                return faker.bool().bool() ? "true" : "false"; // Randomly returns "true" or "false"
            default:
                throw new IllegalArgumentException("Field name not recognized: " + fieldName);
        }
    }

}