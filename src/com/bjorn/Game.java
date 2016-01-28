package com.bjorn;

public class Game {
    UI gameUI;
    Board opponentBoard;
    Ship battleship;

    Game(UI gameUI, Board opponentBoard) {
        this.gameUI = gameUI;
        this.opponentBoard = opponentBoard;
        battleship = new Ship(4, 0, 0, "S");
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
        opponentBoard.placeShip(battleship);
    }

    private void fireOnBoard() {
        gameUI.promptForXCoordinate();
        int x = gameUI.getUserInput();
        gameUI.promptForYCoordinate();
        int y = gameUI.getUserInput();

        if (battleship.checkHit(x + y*10)) {
            opponentBoard.upDateBoardState(x,y, "H");
            if (battleship.isSunk()) {
                battleship.updateSunkSymbol(opponentBoard);
                gameUI.printSunk();
            }
        } else {
            opponentBoard.upDateBoardState(x,y, "M");
        }

    }
}
