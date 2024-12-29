package minesweeper;

import java.util.Random;

public class Main {
    private static final int MAX_SIZE = 9;
    private static final int MAX_MINES = 10;

    private static void printField(char[][] field) {
        for (char[] row : field) {
            for (char col : row) {
                System.out.println(col + " ");
            }
        }
    }

    private static void setMinefield(char[][] field) {
        for (int i = 0; i < field.length; i++) {
            for(int j = 0; j < field[i].length; j++) {
                field[i][j] = '.';
            }
        }
    }

    private static void placeMines(char[][] field, int mines) {
        Random rand = new Random();
        int placedMines = 0;

        while (placedMines < mines) {
            int row = rand.nextInt(MAX_SIZE);
            int col = rand.nextInt(MAX_SIZE);

            if (field[row][col] == '.') {
                field[row][col] = 'X';
                placedMines++;
            }
        }

    }

    public static void main(String[] args) {
        char[][] minefield = new char[MAX_SIZE][MAX_SIZE];

        setMinefield(minefield);
        placeMines(minefield, MAX_MINES);
        printField(minefield);
    }
}
