package com.example.game_of_life.model;

public class Grid {
    private static final int ROWS = 5;
    private static final int COLS = 5;
    private boolean[][] cells;
    
    public Grid() {
        this.cells = new boolean[ROWS][COLS];
    }
    
    public void setCell(int row, int col, boolean state) {
        if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
            cells[row][col] = state;
        }
    }
    
    public boolean getCell(int row, int col) {
        if (row >= 0 && row < ROWS && col >= 0 && col < COLS) {
            return cells[row][col];
        }
        return false;
    }
    
    public int getRows() {
        return ROWS;
    }
    
    public int getCols() {
        return COLS;
    }
    
    public void clearGrid() {
        this.cells = new boolean[ROWS][COLS];
    }
    
    public void initializeWithBlinker() {
        clearGrid();
        // Pattern blinker horizontal
        setCell(1, 2, true);
        setCell(2, 2, true);
        setCell(3, 2, true);
    }
}