package com.example.recipes.controller;

import com.example.recipes.model.Ingredient;
import com.example.recipes.model.Recipe;
import com.example.recipes.service.impl.IngredientServiceImpl;
import com.example.recipes.service.impl.RecipesServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    RecipesServiceImpl recipesService;
    IngredientServiceImpl ingredientService;
    @GetMapping
    public void printIngrdientslist(@RequestParam long id){
        recipesService.printListOfIngredientsInTheRecipe(id);
    }

    @PutMapping("/edit/{idRecipe}/{idIngredient}")
    public ResponseEntity<Recipe> editIngredient(@PathVariable long idRecipe, @PathVariable long idIngredient, @RequestBody Ingredient ingredient){
        if(ingredientService.editIngredient(idRecipe, idIngredient, ingredient)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{idRecipe}/{idIngredient}")
    public ResponseEntity<Recipe> deleteRecipe(@PathVariable long idRecipe, @PathVariable long idIngredient){
        if(ingredientService.deleteIngredient(idRecipe, idIngredient)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Recipe> deleteAllIngredient(@PathVariable long id){
        if (ingredientService.deleteAllIngredients(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
