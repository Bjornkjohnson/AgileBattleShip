package com.bjorn;

import java.util.concurrent.TimeUnit;

public class Game {
    public void printWelcome(){
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_CLS = "\033[2J";
        String ANSI_HOME = "\u001b[H";
        String title = "" +
                "██████╗  █████╗ ████████╗████████╗██╗     ███████╗███████╗██╗  ██╗██╗██████╗ \n" +
                "██╔══██╗██╔══██╗╚══██╔══╝╚══██╔══╝██║     ██╔════╝██╔════╝██║  ██║██║██╔══██╗\n" +
                "██████╔╝███████║   ██║      ██║   ██║     █████╗  ███████╗███████║██║██████╔╝\n" +
                "██╔══██╗██╔══██║   ██║      ██║   ██║     ██╔══╝  ╚════██║██╔══██║██║██╔═══╝ \n" +
                "██████╔╝██║  ██║   ██║      ██║   ███████╗███████╗███████║██║  ██║██║██║     \n" +
                "╚═════╝ ╚═╝  ╚═╝   ╚═╝      ╚═╝   ╚══════╝╚══════╝╚══════╝╚═╝  ╚═╝╚═╝╚═╝     \n";
        System.out.print(ANSI_CLS+ANSI_HOME);
        for (int i = 0; i < 10; i++) {
            System.out.print(ANSI_RED+title+ANSI_RESET);
            try {
                TimeUnit.MILLISECONDS.sleep(50);
                System.out.print(ANSI_CLS+ANSI_HOME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print(title);

            try {
                TimeUnit.MILLISECONDS.sleep(50);
                System.out.print(ANSI_CLS+ANSI_HOME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

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
