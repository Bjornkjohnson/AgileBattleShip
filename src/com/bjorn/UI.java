package com.bjorn;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UI {

    public String getUserInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public void printWelcome(){
        System.out.print(GameConstants.ANSI_CLS_HOME);
        for (int i = 0; i < 20; i++) {
            printTitleAndWait(GameConstants.ANSI_RED+GameConstants.title+GameConstants.ANSI_RESET);
            printTitleAndWait(GameConstants.title);
        }
    }

    private void printTitleAndWait(String title) {
        System.out.print(title);
        try {
            TimeUnit.MILLISECONDS.sleep(50);
            System.out.print(GameConstants.ANSI_CLS_HOME);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void printBoard(Board boardState) {
        System.out.print(GameConstants.ANSI_CLS_HOME);
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
        System.out.print(convertNumberToLetter(yAxisNumber));
        System.out.print("|");
    }

    private String convertNumberToLetter(int num) {
        return String.valueOf((char)(num + 'a'));
    }

    public void promptForCoordinates() {
        System.out.print("Please Enter Coordinates: ");
    }

    public void printSunk() {
        System.out.print(GameConstants.ANSI_CLS_HOME);
        for (int i = 0; i < 20; i++) {
            printTitleAndWait(GameConstants.ANSI_RED+GameConstants.shipSunk+GameConstants.ANSI_RESET);
            printTitleAndWait(GameConstants.shipSunk);
        }
    }

    public void printGameOver() {
        System.out.print(GameConstants.ANSI_CLS_HOME);
        for (int i = 0; i < 20; i++) {
            printTitleAndWait(GameConstants.ANSI_RED+GameConstants.gameOver+GameConstants.ANSI_RESET);
            printTitleAndWait(GameConstants.gameOver);
        }
    }

    public void printInvalidInput() {
        System.out.print(GameConstants.ANSI_CLS_HOME);
        for (int i = 0; i < 20; i++) {
            printTitleAndWait(GameConstants.ANSI_RED+GameConstants.invalidInput+GameConstants.ANSI_RESET);
            printTitleAndWait(GameConstants.invalidInput);
        }
    }
}
