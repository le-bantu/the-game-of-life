package com.example.game_of_life.service;

import com.example.game_of_life.model.Grid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private ConsoleDisplay consoleDisplay;

    private Grid grid;
    private int generation;

    public void initializeGame() {
        grid = new Grid();
        grid.initializeWithBlinker();
        generation = 0;
        
        consoleDisplay.displayGridWithInfo(grid, generation);
    }

    public void nextGeneration() {
        grid.nextGeneration();
        generation++;
        
        consoleDisplay.displayGridWithInfo(grid, generation);
    }

    public Grid getGrid() {
        return grid;
    }

    public int getGeneration() {
        return generation;
    }
}