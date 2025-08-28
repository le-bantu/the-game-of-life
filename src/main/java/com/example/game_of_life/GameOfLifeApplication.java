package com.example.game_of_life;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.game_of_life.service.GameService;

@SpringBootApplication
public class GameOfLifeApplication implements CommandLineRunner {

    @Autowired
    private GameService gameService;

    public static void main(String[] args) {
        SpringApplication.run(GameOfLifeApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Démarrage du Jeu de la Vie...");
        gameService.initializeGame();
        
        System.out.println("Simulation de 2 générations en console:");
        for (int i = 0; i < 2; i++) {
            gameService.nextGeneration();
        }
    }
}