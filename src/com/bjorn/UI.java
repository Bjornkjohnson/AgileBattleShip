package com.bjorn;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UI {
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_CLS_HOME = "\033[2J\u001B[H";
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

    public int getUserInput() {
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public void printWelcome(){
        System.out.print(ANSI_CLS_HOME);
        for (int i = 0; i < 20; i++) {
            printTitleAndWait(ANSI_RED+title+ANSI_RESET);
            printTitleAndWait(title);
        }
    }

    private void printTitleAndWait(String title) {
        System.out.print(title);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
            System.out.print(ANSI_CLS_HOME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void printBoard(Board boardState) {
        System.out.print(ANSI_CLS_HOME);
        printXAxisNumbers();
        for (int yCoordinate = 0; yCoordinate < 10; yCoordinate++) {
            printYAxisNumbers(yCoordinate);
            for (int xCoordinate = 0; xCoordinate < 10; xCoordinate++) {
                printCellState(boardState, xCoordinate, yCoordinate);
            }
            System.out.print("\n");
        }
    }

    private void printCellState(Board boardState, int xCoordinate, int yCoordinate) {
        String cellState = boardState.getCellState(xCoordinate, yCoordinate);
        System.out.print("_");
        if (cellState != "S"){
            System.out.print(cellState);
        } else {
            System.out.print("~");
        }
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

    public void promptForXCoordinate() {
        System.out.print("Please Enter X Coordinate: ");
    }

    public void promptForYCoordinate() {
        System.out.print("Please Enter Y Coordinate: ");
    }
}
