package com.bjorn;

public class Game {
    public void printBoard(Board newBoard) {
        System.out.print("  ");
        String topNumber = " %-2d ";
        for (int i = 0; i< 10; i++){
            System.out.format(topNumber, i);
        }
        System.out.print("\n");
        for (int i = 0; i < 10; i++) {
            System.out.print(i);
            System.out.print("|_");
            for (int j = 1; j < 10; j++){
                System.out.print("~");
                System.out.print("_|_");
            }
            System.out.print("~");
            System.out.print("_|\n");
        }

    }
}
