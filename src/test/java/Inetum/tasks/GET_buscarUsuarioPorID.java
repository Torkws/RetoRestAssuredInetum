package Inetum.tasks;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GET_buscarUsuarioPorID implements Task {

    private final String id;
    private static final String PATH = "/usuarios";

    public GET_buscarUsuarioPorID(String id) {
        this.id = id;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Get.resource(PATH + "/" + id)
                .with(request -> request.log().all().relaxedHTTPSValidation())
        );

    }

    public static Performable sending(String id) {
        return instrumented(GET_buscarUsuarioPorID.class, id);
    }
}