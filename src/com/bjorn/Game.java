package com.bjorn;

import java.awt.*;
import java.util.Random;

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

    private void randomShipSetup() {
        Random r = new Random();
        int Low = 0;
        int High = 99;

        for (int i = 0; i < fleet.length; i++) {
           while (true) {
               int random = r.nextInt(High-Low) + Low;
               try {
                   fleet[i] = new Ship(2, 0, "S");
                   fleet[i].updatePosition(random);
                   opponentBoard.placeShip(fleet[i]);
                   break;
               } catch (RuntimeException e) {

               }

           }
        }
    }

    public void startGame() {
        //setUpComputerBoard();
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

    private void setUpComputerBoard() {
        for (int i = 0; i < 5; i++) {
            opponentBoard.placeShip(fleet[i]);
        }
    }

    private void fireOnBoard() {
        gameUI.promptForXCoordinate();
        int x = gameUI.getUserInput();
        gameUI.promptForYCoordinate();
        int y = gameUI.getUserInput();

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
