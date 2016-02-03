package com.bjorn;

public class Driver {
    public static void main(String [] args){
        UI newUI = new UI();
        Board newBoard = new Board();
        BoardSetup newSetup = new BoardSetup();
        Game newGame = new Game(newUI, newBoard, newSetup);
        newGame.startGame();
    }
}
