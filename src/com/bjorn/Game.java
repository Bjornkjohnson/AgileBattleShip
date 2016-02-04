package com.bjorn;

import jdk.nashorn.internal.ir.WhileNode;
import jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType;

import static java.lang.Character.getNumericValue;
import static java.lang.Character.toLowerCase;

public class Game {
    UI gameUI;
    Board opponentBoard;
    Board playerBoard;
    Ship fleet[] = new Ship[5];

    Game(UI gameUI, Board opponentBoard, Board playerBoard, BoardSetup newSetup) {
        this.gameUI = gameUI;
        this.opponentBoard = opponentBoard;
        this.playerBoard = playerBoard;
        fleet[0] = new Ship(2, 0, "S");
        fleet[1] = new Ship(3, 1, "S");
        fleet[2] = new Ship(3, 0, "S");
        fleet[3] = new Ship(4, 1, "S");
        fleet[4] = new Ship(5, 0, "S");
        newSetup.randomBoard(fleet,opponentBoard);
    }

    public void startGame() {
        gameUI.printWelcome();
        gameLoop();
        gameUI.printYouWin();
        gameUI.printGameOver();
    }

    private void gameLoop () {
        for (int i = 0; i < 100; i++) {
            gameUI.printBoard(opponentBoard, false);
            fireOnBoard();
            if (gameOver()){
                break;
            }
        }
        gameUI.printBoard(opponentBoard, false);
    }

    private boolean gameOver() {
        for (int i = 0; i < fleet.length; i++) {
            if (!fleet[i].isSunk()) {
                return false;
            }
        }
        return true;
    }


    private void fireOnBoard() {
        String coordinates = getValidatedInput();
        int y = changeCharToInt(coordinates.charAt(0));
        int x = getNumericValue(coordinates.charAt(1));
        checkFleetForHit(x,y);
    }

    private int changeCharToInt(char letter) {
        letter = toLowerCase(letter);
        int number = letter - 'a';
        return number;
    }

    private String getValidatedInput() {
        gameUI.promptForCoordinates();
        String coordinates = gameUI.getUserInput();
        while (!coordinates.matches("^([a-jA-J]\\p{Digit})$")) {
            gameUI.printInvalidInput();
            gameUI.printBoard(opponentBoard, false);
            gameUI.promptForCoordinates();
            coordinates = gameUI.getUserInput();
        }
        return coordinates;
    }

    private void checkFleetForHit (int x, int y) {
        for (int i = 0; i < fleet.length; i++) {
            if (fleet[i].checkHit(x + y*10)) {
                opponentBoard.upDateBoardState(x,y, "H");
                if (fleet[i].isSunk()) {
                    fleet[i].updateSunkSymbol(opponentBoard);
                    gameUI.printSunk();
                }
                break;
            } else {
                opponentBoard.upDateBoardState(x,y, "M");
            }
        }
    }
}
