package com.sudoku.models;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class SudokuButtons {
    private final SudokuGrid sudokuGrid;
    private final SudokuGenerator sudokuGenerator;

    public SudokuButtons(SudokuGrid sudokuGrid) {
        this.sudokuGrid = sudokuGrid;
        this.sudokuGenerator = new SudokuGenerator();
    }

    public void agregarButtonAlGrid(GridPane grid) {
        Button solveButton = new Button("Resolver Sudoku");
        solveButton.setStyle("-fx-font-size: 18px; -fx-padding: 10px 20px; -fx-background-color: #4CAF50; -fx-text-fill: white; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        solveButton.setOnAction(e -> {
            int[][] tablero = sudokuGenerator.getTablero();
            if (sudokuGenerator.resolverSudoku(tablero)) {
                actualizarGridConSolucion(tablero);
            } else {
                System.out.println("No se puede resolver el Sudoku.");
            }
        });

        Button exitButton = new Button("Salir");
        exitButton.setStyle("-fx-font-size: 18px; -fx-padding: 10px 20px; -fx-background-color: #FF0000; -fx-text-fill: white; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        exitButton.setOnAction(e -> System.exit(0));

        // Centrar los botones en un VBox
        VBox buttonBox = new VBox(10, solveButton, exitButton);
        buttonBox.setAlignment(Pos.CENTER);

        // Agregar el VBox con los botones a la cuadrícula, en la parte inferior
        GridPane.setRowIndex(buttonBox, 10);
        GridPane.setColumnSpan(buttonBox, 9);
        grid.add(buttonBox, 0, 9, 9, 1);
    }

    private void actualizarGridConSolucion(int[][] tablero) {
        sudokuGrid.actualizarGridConTablero(tablero);
    }
}
