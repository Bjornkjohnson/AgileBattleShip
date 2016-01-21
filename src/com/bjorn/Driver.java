package com.bjorn;

public class Driver {
    public static void main(String [] args){
        Board newBoard = new Board();
        Game newGame = new Game();
        newGame.printWelcome();
        newGame.printBoard(newBoard);

    }
}
