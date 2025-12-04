package Inetum.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class responseApiQuestions implements Question<Integer> {

    public static Question<Integer> getStatusCode() {
        return new responseApiQuestions();
    }
    @Override
    public Integer answeredBy(net.serenitybdd.screenplay.Actor actor) {
        return SerenityRest.lastResponse().getStatusCode();
    }
}
