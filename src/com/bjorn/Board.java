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
        int shipWraps = 0;
        for (Integer key : coordinates.keySet()) {
            if (key%10 == 9 || key%10 == 0) {
                shipWraps++;
            }
            if (invalidPosition(key, shipWraps)) {
                throw new RuntimeException();
            }
        }
        boardState.putAll(coordinates);
    }

    private boolean invalidPosition(int key, int shipWraps) {

        return boardState.containsKey(key) || key > 99 || shipWraps>1;
    }

    private int convertCoordinateToInt(int xCoordinate, int yCoordinate) {
        return xCoordinate + yCoordinate*10;
    }

}
