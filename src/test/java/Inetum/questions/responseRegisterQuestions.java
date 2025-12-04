package Inetum.questions;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Question;

public class responseRegisterQuestions implements Question<String> {

    private String fieldName = "";

    public responseRegisterQuestions(String fieldName) {
        this.fieldName = fieldName;
    }

    public static Question<String> getFieldValue(String fieldName) {
        return new responseRegisterQuestions(fieldName);
    }

    @Override
    public String answeredBy(net.serenitybdd.screenplay.Actor actor) {
        return SerenityRest.lastResponse().jsonPath().getString(fieldName);
    }
}