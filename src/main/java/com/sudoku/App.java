package com.sudoku;

import com.sudoku.models.SudokuButtons;
import com.sudoku.models.SudokuGenerator;
import com.sudoku.models.SudokuGrid;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;

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
        primaryStage.setHeight(700); // Alto de la ventana

        // Crea la cuadrícula de Sudoku y los botones
        SudokuGenerator sudokuGenerator = new SudokuGenerator(); // Instancia la clase SudokuGenerator
        int[][] tablero = sudokuGenerator.getTablero(); // Obtiene el tablero generado
        SudokuGrid sudokuGrid = new SudokuGrid(); // Instancia la clase SudokuGrid
        GridPane grid = sudokuGrid.createGridPane(); // Crea la cuadrícula de Sudoku en un GridPane
        sudokuGrid.actualizarGridConTablero(tablero); // Actualiza la cuadrícula con los valores del tablero
        SudokuButtons sudokuButtons = new SudokuButtons(sudokuGrid); // Instancia la clase SudokuButtons pasando la cuadrícula de Sudoku
        sudokuButtons.addButtonsToGrid(grid); // Agrega los botones a la cuadrícula

        // Crear un VBox para contener la cuadrícula y los botones
        VBox vbox = new VBox(20, grid);
        vbox.setPadding(new Insets(20));
        vbox.setBackground(new Background(new BackgroundFill(Color.LIGHTBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

        // Crea la escena y muestra la ventana principal
        Scene scene = new Scene(vbox, 600, 700); // Crea una nueva escena con el VBox
        primaryStage.setScene(scene); // Establece la escena en la ventana principal
        primaryStage.show(); // Muestra la ventana
    }
}
