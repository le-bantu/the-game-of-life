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
        System.out.println("=== DÉMARRAGE DU JEU DE LA VIE ===");
        
        gameService.initializeGame();
        
        System.out.println("Simulation de 4 générations avec délai de 500ms:");
        gameService.runGenerations(4, 500);
        
        System.out.println("Test de la boucle automatique (3 secondes):");
        gameService.startSimulation(300);
        Thread.sleep(3000);
        gameService.stopSimulation();
        
        System.out.println("=== SIMULATION TERMINÉE ===");
    }
}