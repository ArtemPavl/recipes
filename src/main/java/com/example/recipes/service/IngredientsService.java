package com.example.recipes.service;

import com.example.recipes.model.Ingredient;

import java.util.Map;

public interface IngredientsService {
    void addIngredient(Ingredient ingredient, long id);

    void printIngredientsList(Map<Long, Ingredient> ingredientsList);

    boolean editIngredient(long idRecipe, long idIngredient, Ingredient ingredient);

    boolean deleteIngredient(long idRecipe, long idIngredient);

    boolean deleteAllIngredients(long id);
}
