package com.example.recipes.service.impl;

import com.example.recipes.model.Ingredient;
import com.example.recipes.model.Recipe;
import com.example.recipes.service.RecipesService;

import java.util.LinkedHashMap;
import java.util.Map;

public class RecipesServiceImpl implements RecipesService {

    private long id = 0;

    private long idIngredient = 0;
    public static Map<Long, Recipe> recipesList = new LinkedHashMap<>();

    IngredientServiceImpl ingredientService;

    @Override
    public void addRecipe(Recipe recipe) {
        recipesList.put(id++, recipe);
    }

    @Override
    public Recipe getRecipe(long id) {
        return recipesList.get(id);
    }

    @Override
    public void printRecipesList(){
        for (Map.Entry<Long, Recipe> entry : recipesList.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getName() + ".");
        }
    }

    @Override
    public void printListOfIngredientsInTheRecipe(long id){
        for (Map.Entry<Long,Recipe> entry : recipesList.entrySet()) {
            if(id == entry.getKey()){
                ingredientService.printIngredientsList(recipesList.get(id).getIngredientsList());
            }
        }
    }

    @Override
    public void addStep(long id, String step){
        for (Map.Entry<Long, Recipe> entry : recipesList.entrySet()) {
            if (id == entry.getKey()){
                entry.getValue().getCookingSteps().add(step);
                break;
            }
        }
    }
    @Override
    public void addIngredient(Ingredient ingredient){
        ingredientService.addIngredient(ingredient, idIngredient++);
    }
}
