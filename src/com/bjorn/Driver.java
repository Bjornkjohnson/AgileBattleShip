package com.bjorn;

public class Driver {
    public static void main(String [] args){
        UI newUI = new UI();
        Board computerBoard = new Board();
        Board playerBoard = new Board();
        BoardSetup newSetup = new BoardSetup();
        Game newGame = new Game(newUI, computerBoard, playerBoard, newSetup);
        newGame.startGame();
    }
}
