package com.bjorn;

public class Game {
    public void printBoard(Board newBoard) {
        System.out.print("\t  1\t  2\t  3\t  4\t  5\t  6\t  7\t  8\t  9\t  10 \n");
        for (int i = 1; i < 11; i++) {
            System.out.print(i);
            System.out.print("\t|_");
            for (int j = 1; j < 10; j++){
                System.out.print("~");
                System.out.print("_|_");
            }
            System.out.print("~");
            System.out.print("_|\n");

        }
    }
}
