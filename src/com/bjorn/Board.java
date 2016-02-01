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


    public void upDateBoardState(int xCoordinate, int yCoordinate, String symbol) {
        int cellCoordinate = convertCoordinateToInt(xCoordinate, yCoordinate);
        boardState.put(cellCoordinate, symbol);
    }

    public void placeShip(Ship newShip) {
        HashMap<Integer, String> coordinates = newShip.getCoordinates();
        for (Integer key : coordinates.keySet()) {
            if (boardState.containsKey(key)) {
                throw new RuntimeException();
            }
        }
        boardState.putAll(coordinates);
    }

    private int convertCoordinateToInt(int xCoordinate, int yCoordinate) {
        return xCoordinate + yCoordinate*10;
    }

}
