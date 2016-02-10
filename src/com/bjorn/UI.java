package com.bjorn;

import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class UI {
    private HashMap<String, String> symbols = new HashMap<>();

    UI() {
        symbols.put("~", GameConstants.blueWater);
        symbols.put("H", GameConstants.hit);
        symbols.put("M", GameConstants.miss);
        symbols.put("X", GameConstants.sunk);
        symbols.put("D", GameConstants.destroyer);
        symbols.put("A", GameConstants.aircraftCarrier);
        symbols.put("B", GameConstants.battleship);
        symbols.put("S", GameConstants.submarine);
        symbols.put("C", GameConstants.cruiser);

    }

    public String getUserInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine().trim();
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
    public void printBoard(Board boardState, boolean showShip) {
        if (showShip == true) {
            System.out.print(GameConstants.ANSI_CLS_HOME);
            System.out.println("\tYour Board");
        } else {
            System.out.println("\tOpponent Board");
        }
        printXAxisNumbers();
        for (int yCoordinate = 0; yCoordinate < 10; yCoordinate++) {
            printYAxisNumbers(yCoordinate);
            for (int xCoordinate = 0; xCoordinate < 10; xCoordinate++) {
                if (showShip == false) {
                    printCellState(boardState, xCoordinate, yCoordinate);
                } else {
                    printVisibleShipCellState(boardState, xCoordinate, yCoordinate);
                }
            }
            System.out.print("\n");
        }
    }

    private void printCellState(Board boardState, int xCoordinate, int yCoordinate) {
        String cellState = boardState.getCellState(xCoordinate, yCoordinate);
        System.out.print("_");
        if (shouldHide(cellState) || cellState == "~"){
            System.out.print(GameConstants.blueWater);
        } else {
            System.out.print(symbols.get(cellState));
        }
        System.out.print("_|");
    }

    private boolean shouldHide(String symbol) {
        if (symbol == "A" ||
            symbol == "B" ||
            symbol == "S" ||
            symbol == "C" ||
            symbol == "D") {
            return true;
        }
        return false;
    }

    private void printVisibleShipCellState(Board boardState, int xCoordinate, int yCoordinate) {
        String cellState = boardState.getCellState(xCoordinate, yCoordinate);
        System.out.print("_");
        System.out.print(symbols.get(cellState));
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
        printFlashingMessage(GameConstants.shipSunk);
    }

    public void printGameOver() {
        printFlashingMessage(GameConstants.gameOver);
    }

    public void printInvalidInput() {
        printFlashingMessage(GameConstants.invalidInput);
    }

    public void printYouWin() {
        printFlashingMessage(GameConstants.youWin);
    }

    private void printFlashingMessage(String message) {
        System.out.print(GameConstants.ANSI_CLS_HOME);
        for (int i = 0; i < 20; i++) {
            printTitleAndWait(GameConstants.ANSI_RED+message+GameConstants.ANSI_RESET);
            printTitleAndWait(message);
        }
    }

    public void printComputerThinking() {
        System.out.print("Computer Thinking...");
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
