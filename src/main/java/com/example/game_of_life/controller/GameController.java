package com.example.game_of_life.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.game_of_life.model.Grid;

@Controller
public class GameController {

    @GetMapping("/")
    public String home(Model model) {
        Grid grid = new Grid();
        grid.initializeWithBlinker();
        
        model.addAttribute("title", "Jeu de la Vie");
        model.addAttribute("grid", grid);
        model.addAttribute("gridState", grid.getGridState());
        model.addAttribute("generation", 0);
        return "index";
    }

    @PostMapping("/next")
    public String nextGeneration(@RequestParam int generation, Model model) {
        Grid grid = new Grid();
        grid.initializeWithBlinker();
        
        for (int i = 0; i < generation + 1; i++) {
            grid.nextGeneration();
        }
        
        model.addAttribute("title", "Jeu de la Vie - Génération " + (generation + 1));
        model.addAttribute("grid", grid);
        model.addAttribute("gridState", grid.getGridState());
        model.addAttribute("generation", generation + 1);
        return "index";
    }

}