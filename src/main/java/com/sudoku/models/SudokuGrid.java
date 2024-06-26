package com.sudoku.models;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SudokuGrid {
    private final TextField[][] cells = new TextField[9][9];

    public GridPane createGridPane() {
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                cells[row][col] = new TextField();
                cells[row][col].setPrefWidth(40);
                cells[row][col].setPrefHeight(40);

                // Estilo para los bordes
                StringBuilder style = new StringBuilder();
                style.append("-fx-border-color: black;");
                style.append("-fx-border-width: ");
                style.append((row % 3 == 0) ? "2" : "1").append(" "); // Borde superior
                style.append((col % 3 == 2) ? "2" : "1").append(" "); // Borde derecho
                style.append((row % 3 == 2) ? "2" : "1").append(" "); // Borde inferior
                style.append((col % 3 == 0) ? "2" : "1").append(" "); // Borde izquierdo
                style.append(";");

                cells[row][col].setStyle(style.toString());

                grid.add(cells[row][col], col, row);
            }
        }

        return grid;
    }

    public TextField[][] getCells() {
        return cells;
    }
}
