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
        setCell(1, 2, true);
        setCell(2, 2, true);
        setCell(3, 2, true);
    }
    
    public int countLiveNeighbors(int row, int col) {
        int count = 0;
        
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (x == 0 && y == 0) continue; 
                
                int ni = row + x; 
                int nj = col + y; 

                if (ni >= 0 && ni < ROWS && nj >= 0 && nj < COLS) {
                    if (cells[ni][nj]) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
    
    public String getGridState() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                sb.append(cells[i][j] ? "■ " : "□ ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}