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
        
        model.addAttribute("title", "Jeu de la Vie");
        model.addAttribute("grid", grid);
        return "index";
    }
    
}