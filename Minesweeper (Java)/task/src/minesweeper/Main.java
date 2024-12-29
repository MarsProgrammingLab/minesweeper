package minesweeper;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Minefield field = new Minefield(4, 4, 4);
        field.printField();
    }
}
