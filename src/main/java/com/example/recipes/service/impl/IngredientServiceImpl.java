package com.example.recipes.service.impl;

import com.example.recipes.model.Ingredient;
import com.example.recipes.service.IngredientsService;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static com.example.recipes.service.impl.RecipesServiceImpl.*;

public class IngredientServiceImpl implements IngredientsService {

    @Override
    public void addIngredient(Ingredient ingredient, long id){
        Map<Long, Ingredient> ingredientsList = new LinkedHashMap<>();
        ingredientsList.put(id, ingredient);
    }

//    public Ingredient getIngredient(long id){
//        return ingredientsList.get(id);
//    }

    @Override
    public void printIngredientsList(Map<Long, Ingredient> ingredientsList){
        for (Map.Entry<Long, Ingredient> entry : ingredientsList.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getName() + " "
                    + entry.getValue().getCount() + " " + entry.getValue().getUnitOfMeasurement() + ".");
        }
    }

    @Override
    public boolean editIngredient(long idRecipe, long idIngredient, Ingredient ingredient){
        if(recipesList.containsKey(idRecipe)){
            if (recipesList.get(idRecipe).getIngredientsList().containsKey(idIngredient)) {
                recipesList.get(idRecipe).getIngredientsList().put(idIngredient, ingredient);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean deleteIngredient(long idRecipe, long idIngredient){
        if(recipesList.containsKey(idRecipe)){
            if (recipesList.get(idRecipe).getIngredientsList().containsKey(idIngredient)) {
                recipesList.get(idRecipe).getIngredientsList().remove(idIngredient);
                return true;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean deleteAllIngredients(long id) {
        if (recipesList.containsKey(id)) {
            recipesList.get(id).setIngredientsList(new HashMap<>());
            return true;
        }
        return false;
    }

}
