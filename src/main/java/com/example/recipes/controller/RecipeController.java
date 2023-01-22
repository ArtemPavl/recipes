package com.example.recipes.controller;

import com.example.recipes.model.Ingredient;
import com.example.recipes.model.Recipe;
import com.example.recipes.service.impl.IngredientServiceImpl;
import com.example.recipes.service.impl.RecipesServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    public static RecipesServiceImpl recipesService;

    @GetMapping("/list")
    public void printRecipesList(){
        recipesService.printRecipesList();
    }

    @GetMapping("/inggedients")
    public void printIngrdientslist(@RequestParam long id){
        recipesService.printListOfIngredientsInTheRecipe(id);
    }

    @GetMapping("/add-recipe")
    public void addRecipe(@RequestParam String name, @RequestParam int coocingTime){
        Recipe recipe = new Recipe(name, coocingTime, null, null);
        recipesService.addRecipe(recipe);
    }

    @GetMapping("/add-steps")
    public void addSteps(@RequestParam long id, @RequestParam String step){
        recipesService.addStep(id, step);
    }

    @GetMapping("/add-ingredients")
    public void addIngredients(@RequestParam long id, @RequestParam String name, @RequestParam int count, @RequestParam String unit) {
        Ingredient ingredient = new Ingredient(name, count, unit);
        for (Map.Entry<Long, Recipe> entry : RecipesServiceImpl.recipesList.entrySet()) {
            if (id == entry.getKey()) {
                recipesService.addIngredient(ingredient);
                break;
            }
        }
    }
}