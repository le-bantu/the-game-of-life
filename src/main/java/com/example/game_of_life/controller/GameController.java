package com.example.game_of_life.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.game_of_life.model.Grid;

@Controller
public class GameController {

    @GetMapping("/")
    public String home(Model model) {
        Grid grid = new Grid();
        grid.initializeWithBlinker();
        
        int neighbors = grid.countLiveNeighbors(2, 2); 
        int edgeNeighbors = grid.countLiveNeighbors(1, 2); 
        
        model.addAttribute("title", "Jeu de la Vie");
        model.addAttribute("grid", grid);
        model.addAttribute("neighbors", neighbors);
        model.addAttribute("edgeNeighbors", edgeNeighbors);
        model.addAttribute("gridState", grid.getGridState());
        return "index";
    }

}