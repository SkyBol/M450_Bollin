package ch.tbz.recipe.planner.mapper;

import ch.tbz.recipe.planner.domain.Ingredient;
import ch.tbz.recipe.planner.domain.Unit;
import ch.tbz.recipe.planner.entities.IngredientEntity;
import org.junit.jupiter.api.Test;

class IngredientEntityMapperTest {
    @Test
    void ingredientMappingTest_toEntity() {
        Ingredient source = new Ingredient("Test", "This is a Test", Unit.GRAMM, 5);

        IngredientEntityMapper mapper = new IngredientEntityMapperImpl();

        IngredientEntity destination = mapper.domainToEntity(source);

        // TODO
    }
}