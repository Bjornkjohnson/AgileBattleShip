package com.bjorn;

import java.util.concurrent.TimeUnit;

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
    }
}
