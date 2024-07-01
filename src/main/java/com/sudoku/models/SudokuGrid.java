package com.sudoku.models;

import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class SudokuGrid {
    private final TextField[][] cells = new TextField[9][9];

    public GridPane crearGridPane() {
        GridPane grid = new GridPane();
        grid.setHgap(5);
        grid.setVgap(5);

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                cells[row][col] = new TextField();
                cells[row][col].setPrefWidth(60);
                cells[row][col].setPrefHeight(60);
                cells[row][col].setStyle("-fx-font-size: 24px; -fx-alignment: center;"); // Ajuste del tamaño de la fuente y centrado

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

    public void actualizarGridConTablero(int[][] tablero) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (tablero[row][col] != 0) {
                    cells[row][col].setText(String.valueOf(tablero[row][col]));
                    cells[row][col].setEditable(false); // Hacer que las celdas con valores iniciales no sean editables
                } else {
                    cells[row][col].setText("");
                    cells[row][col].setEditable(true); // Las celdas vacías son editables
                }
            }
        }
    }
}

