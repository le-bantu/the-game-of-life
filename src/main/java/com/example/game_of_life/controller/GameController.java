package com.example.game_of_life.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.game_of_life.service.GameService;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Jeu de la Vie");
        model.addAttribute("grid", gameService.getGrid());
        model.addAttribute("gridState", gameService.getGrid().getGridState());
        model.addAttribute("generation", gameService.getGeneration());
        model.addAttribute("running", gameService.isRunning());
        model.addAttribute("elapsedTime", gameService.getElapsedTime());
        return "index";
    }

    @PostMapping("/next")
    public String nextGeneration(Model model) {
        gameService.nextGeneration();
        updateModel(model);
        return "index";
    }

    @PostMapping("/start")
    public String startSimulation(@RequestParam(defaultValue = "1000") int delay, Model model) {
        gameService.startSimulation(delay);
        updateModel(model);
        return "index";
    }

    @PostMapping("/stop")
    public String stopSimulation(Model model) {
        gameService.stopSimulation();
        updateModel(model);
        return "index";
    }

    @PostMapping("/reset")
    public String resetGame(Model model) {
        gameService.initializeGame();
        updateModel(model);
        return "index";
    }

    private void updateModel(Model model) {
        model.addAttribute("title", "Jeu de la Vie - Génération " + gameService.getGeneration());
        model.addAttribute("grid", gameService.getGrid());
        model.addAttribute("gridState", gameService.getGrid().getGridState());
        model.addAttribute("generation", gameService.getGeneration());
        model.addAttribute("running", gameService.isRunning());
        model.addAttribute("elapsedTime", gameService.getElapsedTime());
    }

}