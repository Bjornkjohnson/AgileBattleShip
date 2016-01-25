package com.bjorn;

public class Game {
    UI gameUI;
    Board opponentBoard;

    Game(UI gameUI, Board opponentBoard) {
        this.gameUI = gameUI;
        this.opponentBoard = opponentBoard;
    }

    public void startGame() {
        setUpComputerBoard();
        gameUI.printWelcome();
        for (int i = 0; i < 5; i++){
            gameUI.printBoard(opponentBoard);
            fireOnBoard();
        }
        gameUI.printBoard(opponentBoard);
    }

    private void setUpComputerBoard() {
        opponentBoard.placeShip(0,0, "S");
    }

    public void fireOnBoard() {
        gameUI.promptForXCoordinate();
        int x = gameUI.getUserInput();
        gameUI.promptForYCoordinate();
        int y = gameUI.getUserInput();
        opponentBoard.upDateBoardState(x,y);
    }
}
