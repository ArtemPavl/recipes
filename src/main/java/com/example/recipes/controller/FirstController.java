package com.example.recipes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping
    public String start(){
        return "Приложение запущено";
    }

    @GetMapping("/info")
    public String info(){
        return "Артем Павленко\nРецепты\n01.01.2023\nЗдесь хронятся рецепты";
    }

}
