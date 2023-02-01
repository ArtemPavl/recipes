package com.example.recipes.controller;

import com.example.recipes.service.impl.RecipesServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ingredient")
public class IngredientController {

    RecipesServiceImpl recipesService;

    @GetMapping
    public void printIngrdientslist(@RequestParam long id){
        recipesService.printListOfIngredientsInTheRecipe(id);
    }

}
