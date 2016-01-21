package com.bjorn;

public class Game {

    public void printBoard(Board newBoard) {
        System.out.print("  ");
        String topNumber = " %-2d ";
        for (int i = 0; i< 10; i++){
            System.out.format(topNumber, i);
        }
        System.out.print("\n");
        for (int i = 0; i < 100; i++) {
            if (i%10 == 0) {
                System.out.print(i/10);
                System.out.print("|_");
            }
            if (i%10 == 9){
                System.out.print("~");
                System.out.print("_|\n");
            } else  {
                System.out.print("~");
                System.out.print("_|_");
            }

        }

    }
}
