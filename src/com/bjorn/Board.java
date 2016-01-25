package com.bjorn;

import java.util.HashMap;

public class Board {
    HashMap<Integer,String> boardState;

    public Board() {
        boardState = new HashMap<>();
    }

    public HashMap<Integer,String> getBoardState() {
        return boardState;
    }

    public String getCellState(int xCoordinate, int yCoordinate) {
        int cellCoordinate = convertCoordinateToInt(xCoordinate, yCoordinate);
        return boardState.getOrDefault(cellCoordinate, "~");
    }


    public void upDateBoardState(int xCoordinate, int yCoordinate) {
        int cellCoordinate = convertCoordinateToInt(xCoordinate, yCoordinate);
        if (getCellState(xCoordinate, yCoordinate) == "~"){
            boardState.put(cellCoordinate,"M");
        } else {
            boardState.put(cellCoordinate,"H");
        }

    }

    public void placeShip(int xCoordinate, int yCoordinate, String symbol) {
        int cellCoordinate = convertCoordinateToInt(xCoordinate, yCoordinate);
        boardState.put(cellCoordinate, symbol);
    }

    private int convertCoordinateToInt(int xCoordinate, int yCoordinate) {
        return xCoordinate + yCoordinate*10;
    }

}
