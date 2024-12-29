package minesweeper;

import java.util.Random;

public class Minefield {
    private final int rows;
    private final int cols;
    private final char[][] field;
    private final int mines;

    public Minefield(int rows, int cols, int mines) {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
        this.field = new char[rows][cols];
        setMinefield();
        placeMines();
    }

    public void printField() {
        for (int i = 0; i < this.field.length; i++) {
            for (int j = 0; j < this.field[i].length; j++) {
                System.out.print(this.field[i][j]);
            }
            System.out.println();
        }
    }

    private void setMinefield() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.field[i][j] = '.';
            }
        }
    }

    private void placeMines() {
        Random rand = new Random();
        int placedMines = 0;

        while (placedMines < mines) {
            int row = rand.nextInt(this.rows);
            int col = rand.nextInt(this.cols);

            if (field[row][col] == '.') {
                field[row][col] = 'X';
                placedMines++;
            }
        }
    }
}
