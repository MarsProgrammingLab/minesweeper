package minesweeper;

import java.util.Scanner;

public class Game {
    private final int ROWS = 9;
    private final int COLS = ROWS;


    public void start() {
        Scanner scan = new Scanner(System.in);

        System.out.print("How many mines do you want on the field? ");
        int mines = scan.nextInt();

        Minefield field = new Minefield(ROWS, COLS, mines);
        field.printField();
    }
}
