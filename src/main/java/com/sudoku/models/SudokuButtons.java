package com.sudoku.models;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SudokuButtons {
    private final SudokuGrid sudokuGrid;
    private final SudokuGenerator sudokuGenerator;

    public SudokuButtons(SudokuGrid sudokuGrid) {
        this.sudokuGrid = sudokuGrid;
        this.sudokuGenerator = new SudokuGenerator();
    }

    public void addButtonsToGrid(GridPane grid) {
        Button solveButton = new Button("Resolver Sudoku");
        solveButton.setOnAction(e -> {
            int[][] tablero = sudokuGenerator.getTablero();
            if (sudokuGenerator.resolverSudoku(tablero)) {
                actualizarGridConSolucion(tablero);
            } else {
                System.out.println("No se puede resolver el Sudoku.");
            }
        });

        // Agregar el botón a la cuadrícula
        grid.add(solveButton, 9, 0, 1, 9);
    }

    private void actualizarGridConSolucion(int[][] tablero) {
        TextField[][] cells = sudokuGrid.getCells();
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                cells[row][col].setText(String.valueOf(tablero[row][col]));
            }
        }
    }
}
