package com.sudoku.models;

public class SudokuGenerator {

    private final int[][] tablero;

    public SudokuGenerator() {
        this.tablero = generarTablero();
    }

    public int[][] getTablero() {
        return tablero;
    }

    private int[][] generarTablero() {
        int[][] tablero = {
            {0, 0, 0, 4, 0, 0, 5, 0, 0},
            {0, 7, 0, 0, 0, 3, 0, 0, 0},
            {0, 0, 4, 2, 1, 0, 0, 6, 0},
            {0, 3, 0, 0, 8, 0, 1, 0, 0},
            {8, 0, 0, 7, 0, 0, 0, 0, 6},
            {9, 5, 0, 3, 0, 0, 0, 0, 0},
            {0, 0, 0, 9, 0, 0, 0, 0, 1},
            {0, 6, 0, 0, 0, 0, 0, 2, 0},
            {0, 0, 3, 0, 0, 6, 0, 8, 4}
        };
        return tablero;
    }

    public boolean resolverSudoku(int[][] tablero) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (tablero[row][col] == 0) {
                    for (int num = 1; num <= 9; num++) {
                        if (esValido(tablero, row, col, num)) {
                            tablero[row][col] = num;
                            if (resolverSudoku(tablero)) {
                                return true;
                            } else {
                                tablero[row][col] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean esValido(int[][] tablero, int row, int col, int num) {
        for (int i = 0; i < 9; i++) {
            if (tablero[row][i] == num || tablero[i][col] == num || 
                tablero[row - row % 3 + i / 3][col - col % 3 + i % 3] == num) {
                return false;
            }
        }
        return true;
    }
}
