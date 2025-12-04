package Inetum.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;


import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GET_listarUsuarios implements Task {

    private String id, nome, email, password, administrador;
    private static final String PATH = "/usuarios";

    public GET_listarUsuarios(String id, String nome, String email, String password, String administrador) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.administrador = administrador;

    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        try {
            actor.attemptsTo(Get.resource(PATH)
                    .with(request -> {
                                if (id != null && !id.isEmpty()) request = request.queryParam("_id", id);
                                if (nome != null && !nome.isEmpty()) request = request.queryParam("nome", nome);
                                if (email != null && !email.isEmpty()) request = request.queryParam("email", email);
                                if (password != null && !password.isEmpty()) request = request.queryParam("password", password);
                                if (administrador != null && !administrador.isEmpty()) request = request.queryParam("administrador", administrador);
                                return request.log().all().relaxedHTTPSValidation();
                            }
                    ));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Log para inspeccionar la respuesta
        String response = SerenityRest.lastResponse().asString();
        System.out.println("Respuesta del servicio: " + response);

    }

    public static Performable sending(String id, String nome, String email, String password, String administrador) {
        return instrumented(GET_listarUsuarios.class, id, nome, email, password, administrador);
    }

}
