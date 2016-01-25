package com.bjorn;

public class Game {
    UI gameUI;
    Board opponentBoard;

    Game(UI gameUI, Board opponentBoard) {
        this.gameUI = gameUI;
        this.opponentBoard = opponentBoard;
    }

    public void startGame() {
        gameUI.printWelcome();
        gameUI.printBoard(opponentBoard);
        fireOnBoard();
        gameUI.printBoard(opponentBoard);
    }

    public void fireOnBoard() {
        gameUI.promptForXCoordinate();
        int x = gameUI.getUserInput();
        gameUI.promptForYCoordinate();
        int y = gameUI.getUserInput();
        opponentBoard.upDateBoardState(x,y);
    }
}
