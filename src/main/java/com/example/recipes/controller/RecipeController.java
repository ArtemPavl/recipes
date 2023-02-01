package com.example.recipes.controller;

import com.example.recipes.model.Ingredient;
import com.example.recipes.model.Recipe;
import com.example.recipes.service.impl.IngredientServiceImpl;
import com.example.recipes.service.impl.RecipesServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/recipe")
public class RecipeController {

    public static RecipesServiceImpl recipesService;

    @GetMapping("/list")
    public void printRecipesList(){
        recipesService.printRecipesList();
    }

    @PostMapping("/add-recipe")
    public ResponseEntity<Long> addRecipe(@RequestBody Recipe recipe){
        long id = recipesService.addRecipe(recipe);
        return ResponseEntity.ok().body(id);
    }

    @PostMapping("/{id}/add-steps")
    public void addSteps(@PathVariable long id, @RequestBody String step){
        recipesService.addStep(id, step);
    }

    @PostMapping("/{id}/add-ingredients")
    public void addIngredients(@PathVariable long id, @RequestBody Ingredient ingredient) {
        for (Map.Entry<Long, Recipe> entry : RecipesServiceImpl.recipesList.entrySet()) {
            if (id == entry.getKey()) {
                recipesService.addIngredient(ingredient);
                break;
            }
        }
    }
}