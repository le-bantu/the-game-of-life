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
    private boolean running;
    private long startTime;
    private Thread simulationThread;

    public void initializeGame() {
        grid = new Grid();
        grid.initializeWithBlinker();
        generation = 0;
        running = false;
        startTime = System.currentTimeMillis();
        
        consoleDisplay.displayGridWithInfo(grid, generation);
    }

    public void nextGeneration() {
        grid.nextGeneration();
        generation++;
        consoleDisplay.displayGridWithInfo(grid, generation);
    }

    public void startSimulation(int delayMs) {
        if (running) return;
        
        running = true;
        simulationThread = new Thread(() -> {
            while (running && !Thread.currentThread().isInterrupted()) {
                nextGeneration();
                try {
                    Thread.sleep(delayMs);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
            running = false;
        });
        simulationThread.start();
    }

    public void stopSimulation() {
        running = false;
        if (simulationThread != null && simulationThread.isAlive()) {
            simulationThread.interrupt();
        }
    }

    public void runGenerations(int count, int delayMs) {
        for (int i = 0; i < count && !Thread.currentThread().isInterrupted(); i++) {
            nextGeneration();
            if (delayMs > 0) {
                try {
                    Thread.sleep(delayMs);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
    }

    public long getElapsedTime() {
        return System.currentTimeMillis() - startTime;
    }

    public Grid getGrid() {
        return grid;
    }

    public int getGeneration() {
        return generation;
    }

    public boolean isRunning() {
        return running;
    }
}