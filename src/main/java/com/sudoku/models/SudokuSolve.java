package com.sudoku.models;

import java.util.ArrayList;
import java.util.List;

public class SudokuSolve {
    

    public static boolean estaNumeroEnFila(int[][] tablero, int numero, int fila) {
        for (int i = 0; i < 9; i++) {
            if (tablero[fila][i] == numero) {
                return true;
            }
        }
        return false;
    }

    public static boolean estaNumeroEnColumna(int[][] tablero, int numero, int columna) {
        for (int i = 0; i < 9; i++) {
            if (tablero[i][columna] == numero) {
                return true;
            }
        }
        return false;
    }

    private static boolean estaNumeroEnCuadrante(int[][] sudoku, int num, int fila, int columna) {
        int localCuadranteFila = fila - fila % 3;
        int localCuadranteColumna = columna - columna % 3;
        for (int i = localCuadranteFila; i < localCuadranteFila + 3; i++) {
            for (int j = localCuadranteColumna; j < localCuadranteColumna + 3; j++) {
                if (sudoku[i][j] == num) {
                    return true;
                }
            }
        }
        return false;
    }

    
    private static boolean LugarDelSudoku(int[][] sudoku, int num, int fila, int columna) {
        return !estaNumeroEnFila(sudoku, num, fila) &&
               !estaNumeroEnColumna(sudoku, num, columna) &&
               !estaNumeroEnCuadrante(sudoku, num, fila, columna);
    }

    public boolean analizadorSudoku(int[][] sudoku) {
        List<int[]> vacios = new ArrayList<>();

        for (int fila = 0; fila < 9; fila++) {
            for (int columna = 0; columna < 9; columna++) {
                if (sudoku[fila][columna] == 0) {
                    vacios.add(new int[]{fila, columna});// Agregar a la lista las posiciones que quedan vacias
                }
            }
        }

        return resolverSudokuConBacktracking(sudoku, vacios, 0);
    }

    private static boolean resolverSudokuConBacktracking(int[][] sudoku, List<int[]> vacios, int indice) {
        if (indice == vacios.size()) {//si no hay vacios quiere decir que esta resuelto
            return true;
        }

        int[] celda = vacios.get(indice);//selecciona la celda de la lista de vacios
        int fila = celda[0];
        int columna = celda[1];

        for (int num = 1; num <= 9; num++) {
            if (LugarDelSudoku(sudoku, num, fila, columna)) {//chequea si el numero es valido en la celda

                sudoku[fila][columna] = num;//pone el numero en la celda

                if (resolverSudokuConBacktracking(sudoku, vacios, indice + 1)) {//se llama a si misma para resolver la siguiente celda
                    return true;
                }

                sudoku[fila][columna] = 0;//si no se resuelve el siguiente numero se vuelve a poner el 0 en la celda
            }
        }

        return false;
    }

}
