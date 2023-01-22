package com.example.recipes.service;

import com.example.recipes.model.Ingredient;
import com.example.recipes.model.Recipe;

public interface RecipesService {

    void addRecipe(Recipe recipe);

    Recipe getRecipe(long id);

    void printRecipesList();

    void printListOfIngredientsInTheRecipe(long id);

    void addStep(long id, String step);

    void addIngredient(Ingredient ingredient);
}
