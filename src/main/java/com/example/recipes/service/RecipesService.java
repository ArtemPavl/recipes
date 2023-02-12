package com.example.recipes.service;

import com.example.recipes.model.Ingredient;
import com.example.recipes.model.Recipe;

public interface RecipesService {

    long addRecipe(Recipe recipe);

    Recipe getRecipe(long id);

    void printRecipesList();

    void printListOfIngredientsInTheRecipe(long id);

    void addStep(long id, String step);

    boolean editRecipe(long id, Recipe recipe);

    boolean deleteRecipe(long id);

    void deleteAllRecipes();

    void addIngredient(Ingredient ingredient);
}
