package com.bjorn;

import java.util.concurrent.TimeUnit;

public class Game {
    public void printWelcome(){
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_CLS = "\033[2J";
        String ANSI_HOME = "\u001b[H";
        String title = "" +
                "██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗    ████████╗ ██████╗ \n" +
                "██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝    ╚══██╔══╝██╔═══██╗\n" +
                "██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗         ██║   ██║   ██║\n" +
                "██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝         ██║   ██║   ██║\n" +
                "╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗       ██║   ╚██████╔╝\n" +
                " ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝       ╚═╝    ╚═════╝ \n" +
                "                                                                                    \n" +
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

    public void printBoard(Board boardState) {
        printYAxisNumbers();
        for (int xCoordinate = 0; xCoordinate < 10; xCoordinate++) {
            printXAxis(xCoordinate);
            for (int yCoordinate = 0; yCoordinate < 10; yCoordinate++) {
                printCellState(boardState, xCoordinate, yCoordinate);
            }
            System.out.print("\n");
        }
    }

    private void printCellState(Board boardState, int xCoordinate, int yCoordinate) {
        int cellNumber = xCoordinate*10 + yCoordinate;
        System.out.print("_");
        System.out.print(boardState.getCellState(cellNumber));
        System.out.print("_|");
    }

    private void printYAxisNumbers() {
        System.out.print("  ");
        String yAxisNumbers = " %-2d ";
        for (int i = 0; i< 10; i++){
            System.out.format(yAxisNumbers, i);
        }
        System.out.print("\n");
    }

    private void printXAxis(int xAxisNumber){
        System.out.print(xAxisNumber);
        System.out.print("|");
    }
}
