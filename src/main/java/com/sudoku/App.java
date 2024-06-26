package com.sudoku;

import com.sudoku.models.SudokuButtons;
import com.sudoku.models.SudokuGrid;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args); // Lanza la aplicación JavaFX
    }

    // Método de inicio de la aplicación
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Sudoku Solver - UTN"); // Título de la ventana
        primaryStage.setResizable(false); // No permite modificar el tamaño de la ventana
        primaryStage.setWidth(600); // Ancho de la ventana
        primaryStage.setHeight(600); // Alto de la ventana

        // Crea la cuadrícula de Sudoku y los botones
        SudokuGrid sudokuGrid = new SudokuGrid(); // Instancia la clase SudokuGrid
        GridPane grid = sudokuGrid.createGridPane(); // Crea la cuadrícula de Sudoku en un GridPane
        SudokuButtons sudokuButtons = new SudokuButtons(sudokuGrid); // Instancia la clase SudokuButtons pasando la cuadrícula de Sudoku
        sudokuButtons.addButtonsToGrid(grid); // Agrega los botones a la cuadrícula

        // Crea la escena y muestra la ventana principal
        Scene scene = new Scene(grid, 600, 600); // Crea una nueva escena con la cuadrícula
        primaryStage.setScene(scene); // Establece la escena en la ventana principal
        primaryStage.show(); // Muestra la ventana
    }
}
