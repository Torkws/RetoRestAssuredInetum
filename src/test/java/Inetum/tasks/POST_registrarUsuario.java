package Inetum.tasks;

import com.google.gson.Gson;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class POST_registrarUsuario implements Task {

    private String nome, email, password, administrador;
    private static final String PATH = "/usuarios";

    public POST_registrarUsuario(String nome, String email, String password, String administrador) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.administrador = administrador;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(Post.to(PATH)
                    .with(request -> request
                            .header("Content-Type", "application/json")
                            .body(createRequestBody())
                            .log().all()
                            .relaxedHTTPSValidation()
                    ));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private String createRequestBody() {
        Map<String, String> requestBody = new HashMap<>();
        if (nome != null && !nome.isEmpty()) requestBody.put("nome", nome);
        if (email != null && !email.isEmpty()) requestBody.put("email", email);
        if (password != null && !password.isEmpty()) requestBody.put("password", password);
        if (administrador != null && !administrador.isEmpty()) requestBody.put("administrador", administrador);
        return new Gson().toJson(requestBody);
    }

    public static Performable sending(String nome, String email, String password, String administrador) {
        return instrumented(POST_registrarUsuario.class, nome, email, password, administrador);
    }
}