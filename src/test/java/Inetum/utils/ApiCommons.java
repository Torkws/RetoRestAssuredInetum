package Inetum.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.module.jsv.JsonSchemaValidatorSettings;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;

import java.io.IOException;
import java.io.InputStream;


public class ApiCommons {
    public static String BASE_URL = "https://serverest.dev";
    public static Actor ACTOR;

    public void validateJsonSchema(String schemaFile) {
        InputStream schemaStream = getClass().getResourceAsStream("/schemas/" + schemaFile);
        if(schemaStream == null){
            throw new IllegalArgumentException("No se encontró el archivo de esquema: " + schemaFile);
        }

        Serenity.recordReportData().withTitle("Schema Validation").andContents("Validating response against schema: " + schemaFile);


// Convert schemaStream to String for printing
        String schemaContent = null;
        try {
            schemaContent = new String(schemaStream.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String response = SerenityRest.lastResponse().asString();
        if (response == null || response.isEmpty()) {
            throw new AssertionError("La respuesta del servicio está vacía o es nula.");
        }

        String contentType = SerenityRest.lastResponse().getContentType();
        System.out.println("Content-Type: " + contentType);
        if (!contentType.contains("application/json")) {
            throw new AssertionError("El Content-Type de la respuesta no es application/json.");
        }

        // Validate JSON format
        try {
            new ObjectMapper().readTree(response);
        } catch (Exception e) {
            throw new AssertionError("La respuesta no es un JSON válido: " + e.getMessage(), e);
        }


//        System.out.println("Contenido del JSON Schema leído del archivo:");
//        System.out.println(schemaContent);
//
//// Print the response body
//        String responseBody = SerenityRest.lastResponse().getBody().asString();
//        System.out.println("Contenido del JSON Schema obtenido de la respuesta:");
//        System.out.println(responseBody);


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
}
