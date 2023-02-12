package com.example.recipes.model;

import com.example.recipes.service.impl.IngredientServiceImpl;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Map;

@Data
@AllArgsConstructor
public class Recipe {

    private String name;
    private int cookingTime;
    private ArrayList<String> cookingSteps;
    private Map<Long, Ingredient> ingredientsList;

}
