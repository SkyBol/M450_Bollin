package ch.tbz.recipe.planner.controller;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import ch.tbz.recipe.planner.domain.Recipe;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.List;

class RecipeControllerTest {
    public static final String baseURI = "http://localhost:8080/api";
    private static final ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

    @Test
    void getRecipes() {
        get(baseURI + "/recipes")
                .then()
                .statusCode(200)
                .body("[0].name", equalTo("Lasagne al Forno"))
                .body("[0].ingredients", hasSize(1));
    }

    @Test
    void getRecipe() {
        String id = get(baseURI + "/recipes").getBody().jsonPath().get("[0].id");

        get(baseURI + "/recipes/recipe/" + id)
                .then()
                .statusCode(200)
                .body("name", equalTo("Lasagne al Forno"))
                .body("ingredients", hasSize(1));
    }

    @Test
    void addRecipe() throws JsonProcessingException {
        Recipe requestBody = new Recipe(
                "test",
                "Test object to ignore",
                "<none>",
                List.of()
        );

        given()
                .contentType(ContentType.JSON)
                .body(ow.writeValueAsString(requestBody))
                .post(baseURI + "/recipes")
                .then()
                .statusCode(200)
                .body("name", equalTo("test"))
                .body("imageUrl", equalTo("<none>"));
    }
}