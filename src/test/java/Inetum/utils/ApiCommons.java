package Inetum.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.module.jsv.JsonSchemaValidatorSettings;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;


public class ApiCommons {
    public static String BASE_URL = "https://serverest.dev";
    public static Actor ACTOR;

    public void validateJsonSchema(String schemaFile) {
        InputStream schemaStream = getClass().getResourceAsStream("/schemas/" + schemaFile);

        String responseBody = SerenityRest.lastResponse().getBody().asString();
        System.out.println("Contenido del JSON Schema obtenido de la respuesta:");
        System.out.println(responseBody);


        SerenityRest.lastResponse()
                .then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchema(schemaStream));

    }


    public static String GenerarDataMock(String fieldName) {
        Faker faker = new Faker();
        switch (fieldName.toLowerCase()) {
            case "_id":
                return faker.number().digits(16); // Generates a 16-digit UUID-like number
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

    public static String GetField_idByList(){
        List<String> ids = SerenityRest.lastResponse().jsonPath().getList("usuarios._id");

        return ids.get(new Random().nextInt(ids.size()));

    }
}
