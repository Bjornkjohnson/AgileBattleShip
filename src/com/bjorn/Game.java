package com.bjorn;

public class Game {
    UI gameUI;
    Board opponentBoard;
    Ship fleet[] = new Ship[5];

    Game(UI gameUI, Board opponentBoard) {
        this.gameUI = gameUI;
        this.opponentBoard = opponentBoard;
        fleet[0] = new Ship(2, 0, 0, "S");
        fleet[1] = new Ship(3, 10, 0, "S");
        fleet[2] = new Ship(3, 20, 0, "S");
        fleet[3] = new Ship(4, 30, 0, "S");
        fleet[4] = new Ship(5, 40, 0, "S");
    }

    public void startGame() {
        setUpComputerBoard();
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

        for (int i = 0; i < 5; i++) {
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
