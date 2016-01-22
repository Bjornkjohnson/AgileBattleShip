package com.bjorn;

import java.util.concurrent.TimeUnit;

public class UI {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_CLS = "\033[2J";
    private static final String ANSI_HOME = "\u001b[H";
    private static final String title = "" +
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
    public void printWelcome(){
        System.out.print(ANSI_CLS+ANSI_HOME);
        for (int i = 0; i < 20; i++) {
            printTitleAndWait(ANSI_RED+title+ANSI_RESET);
            printTitleAndWait(title);
        }
    }

    private void printTitleAndWait(String title) {
        System.out.print(title);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
            System.out.print(ANSI_CLS+ANSI_HOME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void printBoard(Board boardState) {
        printXAxisNumbers();
        for (int xCoordinate = 0; xCoordinate < 10; xCoordinate++) {
            printYAxisNumbers(xCoordinate);
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

    private void printXAxisNumbers() {
        System.out.print("  ");
        String xAxisNumbers = " %-2d ";
        for (int i = 0; i< 10; i++){
            System.out.format(xAxisNumbers, i);
        }
        System.out.print("\n");
    }

    private void printYAxisNumbers(int yAxisNumber){
        System.out.print(yAxisNumber);
        System.out.print("|");
    }
}
