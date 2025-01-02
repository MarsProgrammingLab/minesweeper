package minesweeper;

import java.util.Random;


public class Minefield {
    private final int rows;
    private final int cols;
    private final int mines;
    private static final char EMPTY = '.';
    private static final char MINE = 'X';
    private final char[][] field;

    public Minefield(int rows, int cols, int mines) {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
        this.field = new char[rows][cols];;

        setMinefield();
        placeMines();
        calculateMineCounts();
    }

    public void printField() {
        for (char[] row : field) {
            for (char cell : row) {
                System.out.print(cell);
            }
            System.out.println();
    }
}


    private void setMinefield() {
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.cols; j++) {
                this.field[i][j] = EMPTY;
            }
        }
    }

    private void placeMines() {
        Random rand = new Random();
        int placedMines = 0;

        while (placedMines < mines) {
            int row = rand.nextInt(this.rows);
            int col = rand.nextInt(this.cols);

            if (field[row][col] != MINE) {
                field[row][col] = MINE;
                placedMines++;
            }
        }
    }

    private void calculateMineCounts() {
        int size = field.length;

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (field[row][col] == MINE) {
                    continue;
                }

                int mineCounts = 0;

                // Check all adjacent cells

                // i and j range from -1 to 1, allowing the
                // program to look at all 8 possible neighbors
                // (top-left, top, top-right, left, right,
                // bottom-left, bottom, bottom-right), as well as the cell itself.
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        // Compute the coordinates of the adjacent cell.
                        int newRow = row + i;
                        int newCol = col + j;

                        if (isInBounds(newRow, newCol, size) && field[newRow][newCol] == MINE) {
                            mineCounts++;
                        }
                    }
                }

                if (mineCounts > 0) {
                    field[row][col] = (char) ('0' + mineCounts);
                }
            }
        }
    }

    private boolean isInBounds(int row, int col, int size) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

}
