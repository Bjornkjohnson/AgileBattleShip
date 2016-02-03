package com.bjorn;

import static java.lang.Character.getNumericValue;
import static java.lang.Character.toLowerCase;

public class Game {
    UI gameUI;
    Board opponentBoard;
    Ship fleet[] = new Ship[5];

    Game(UI gameUI, Board opponentBoard, BoardSetup newSetup) {
        this.gameUI = gameUI;
        this.opponentBoard = opponentBoard;
        fleet[0] = new Ship(2, 0, "S");
        fleet[1] = new Ship(3, 0, "S");
        fleet[2] = new Ship(3, 0, "S");
        fleet[3] = new Ship(4, 0, "S");
        fleet[4] = new Ship(5, 0, "S");
        newSetup.randomBoard(fleet,opponentBoard);
    }

    public void startGame() {
        gameUI.printWelcome();
        gameLoop();
        gameUI.printGameOver();
    }

    private void gameLoop () {
        for (int i = 0; i < 100; i++) {
            gameUI.printBoard(opponentBoard);
            fireOnBoard();
            if (gameOver()){
                break;
            }
        }
        gameUI.printBoard(opponentBoard);
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
        gameUI.promptForCoordinates();
        String coordinates = gameUI.getUserInput();

        char yChar = coordinates.charAt(0);
        yChar = toLowerCase(yChar);
        int y = yChar - 'a';
        int x = getNumericValue(coordinates.charAt(1));
        checkFleetForHit(x,y);

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
