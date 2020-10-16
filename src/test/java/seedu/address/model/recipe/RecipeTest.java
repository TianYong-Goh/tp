package seedu.address.model.recipe;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INGREDIENT_MARGARITAS;
import static seedu.address.logic.commands.CommandTestUtil.VALID_INGREDIENT_SANDWICH;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_MARGARITAS;
import static seedu.address.logic.commands.CommandTestUtil.VALID_QUANTITY_MARGARITAS;
import static seedu.address.logic.commands.CommandTestUtil.VALID_QUANTITY_SANDWICH;
import static seedu.address.testutil.TypicalRecipes.MARGARITAS;
import static seedu.address.testutil.TypicalRecipes.SANDWICH;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.RecipeBuilder;

public class RecipeTest {

    @Test
    public void isSameRecipe() {
        // same object -> returns true
        assertTrue(SANDWICH.isSameRecipe(SANDWICH));

        // null -> returns false
        assertFalse(SANDWICH.isSameRecipe(null));

        // different ingredients -> returns false
        Recipe editedAlice =
                new RecipeBuilder(SANDWICH)
                        .withIngredient(VALID_INGREDIENT_MARGARITAS, VALID_QUANTITY_SANDWICH)
                        .build();
        assertFalse(SANDWICH.isSameRecipe(editedAlice));

        // same ingredients and quantity -> returns true
        editedAlice =
                new RecipeBuilder(SANDWICH).withIngredient(VALID_INGREDIENT_SANDWICH, VALID_QUANTITY_SANDWICH).build();
        assertTrue(SANDWICH.isSameRecipe(editedAlice));

        // different ingredients and quantity -> returns false
        editedAlice = new RecipeBuilder(SANDWICH)
                .withIngredient(VALID_INGREDIENT_MARGARITAS, VALID_QUANTITY_MARGARITAS)
                .build();
        assertFalse(SANDWICH.isSameRecipe(editedAlice));

        // different name -> returns false
        editedAlice = new RecipeBuilder(SANDWICH).withName(VALID_NAME_MARGARITAS).build();
        assertFalse(SANDWICH.isSameRecipe(editedAlice));

        // same name -> returns true
        editedAlice = new RecipeBuilder(SANDWICH).withName("Burger").build();
        assertFalse(SANDWICH.isSameRecipe(editedAlice));

        // same name, same ingredients, different attributes -> returns true
        editedAlice = new RecipeBuilder(SANDWICH)
               .build();
        assertTrue(SANDWICH.isSameRecipe(editedAlice));

        // same name, same ingredients, different attributes -> returns true
        editedAlice = new RecipeBuilder(SANDWICH)
                .withIngredient(VALID_INGREDIENT_MARGARITAS, VALID_QUANTITY_SANDWICH)
                .build();
        // assertTrue(SANDWICH.isSameRecipe(editedAlice));

        // same name, same ingredients, different attributes -> returns true
        editedAlice = new RecipeBuilder(SANDWICH).build();
        assertTrue(SANDWICH.isSameRecipe(editedAlice));
    }

    @Test
    public void equals() {
        // same values -> returns true
        Recipe aliceCopy = new RecipeBuilder(SANDWICH).build();
        assertTrue(SANDWICH.equals(aliceCopy));

        // same object -> returns true
        assertTrue(SANDWICH.equals(SANDWICH));

        // null -> returns false
        assertFalse(SANDWICH.equals(null));

        // different type -> returns false
        assertFalse(SANDWICH.equals(5));

        // different recipe -> returns false
        assertFalse(SANDWICH.equals(MARGARITAS));

        // different name -> returns false
        Recipe editedAlice = new RecipeBuilder(SANDWICH).withName(VALID_NAME_MARGARITAS).build();
        assertFalse(SANDWICH.equals(editedAlice));

        // different ingredients -> returns false
        editedAlice = new RecipeBuilder(SANDWICH)
                .withIngredient(VALID_INGREDIENT_MARGARITAS, VALID_QUANTITY_SANDWICH)
                .build();
        assertFalse(SANDWICH.equals(editedAlice));

        // different quantity -> returns false
        editedAlice =
                new RecipeBuilder(SANDWICH)
                        .withIngredient(VALID_INGREDIENT_SANDWICH, VALID_QUANTITY_MARGARITAS)
                        .build();
        assertFalse(SANDWICH.equals(editedAlice));

        // same ingredient and quantity -> returns true
        editedAlice =
                new RecipeBuilder(SANDWICH).withIngredient(VALID_INGREDIENT_SANDWICH, VALID_QUANTITY_SANDWICH).build();
        assertTrue(SANDWICH.equals(editedAlice));

    }
}
