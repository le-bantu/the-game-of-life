package com.example.game_of_life.service;

import com.example.game_of_life.model.Grid;
import org.springframework.stereotype.Service;

@Service
public class ConsoleDisplay {

    public void displayGrid(Grid grid) {
        System.out.println("\n=== JEU DE LA VIE ===");
        
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                System.out.print(grid.getCell(i, j) ? "■ " : "□ ");
            }
            System.out.println();
        }
        System.out.println("====================\n");
    }

    public void displayGridWithInfo(Grid grid, int generation) {
        System.out.println("\n=== Génération " + generation + " ===");
        
        for (int i = 0; i < grid.getRows(); i++) {
            for (int j = 0; j < grid.getCols(); j++) {
                System.out.print(grid.getCell(i, j) ? "■ " : "□ ");
            }
            System.out.println();
        }
        System.out.println("====================\n");
    }
} 
