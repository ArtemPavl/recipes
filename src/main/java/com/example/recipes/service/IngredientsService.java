package com.example.recipes.service;

import com.example.recipes.model.Ingredient;

import java.util.Map;

public interface IngredientsService {
    void addIngredient(Ingredient ingredient, long id);

    void printIngredientsList(Map<Long, Ingredient> ingredientsList);
}
