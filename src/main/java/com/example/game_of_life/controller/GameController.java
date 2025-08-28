package com.example.game_of_life.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GameController {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("title", "Jeu de la Vie");
        return "index";
    }
}