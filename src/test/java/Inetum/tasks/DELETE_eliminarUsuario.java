package Inetum.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class DELETE_eliminarUsuario implements Task {

    private String id;
    private static final String PATH = "/usuarios/";

    public DELETE_eliminarUsuario(String id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Delete.from(PATH + id)
                .with(request -> request
                        .header("Content-Type", "application/json")
                        .log().all()
                        .relaxedHTTPSValidation()
                ));
    }

    public static Performable sending(String id) {
        return instrumented(DELETE_eliminarUsuario.class, id);
    }
}