package com.example.game_of_life.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.game_of_life.model.Grid;
import com.example.game_of_life.service.GameService;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public String home(Model model) {
        gameService.initializeGame();
        Grid grid = gameService.getGrid();
        
        model.addAttribute("title", "Jeu de la Vie");
        model.addAttribute("grid", grid);
        model.addAttribute("gridState", grid.getGridState());
        model.addAttribute("generation", gameService.getGeneration());
        return "index";
    }

    @PostMapping("/next")
    public String nextGeneration(@RequestParam int generation, Model model) {
        gameService.nextGeneration();
        Grid grid = gameService.getGrid();
        
        model.addAttribute("title", "Jeu de la Vie - Génération " + gameService.getGeneration());
        model.addAttribute("grid", grid);
        model.addAttribute("gridState", grid.getGridState());
        model.addAttribute("generation", gameService.getGeneration());
        return "index";
    }

}