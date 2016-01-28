package com.bjorn;

import java.util.HashMap;

/**
 * Created by bjornjohnson on 1/12/16.
 */
public class Ship {
    private int length;
    private boolean sunk = false;
    private int position;
    private int orientationIterator;
    private int endOfShip;
    private String symbol;
    private HashMap<Integer, Boolean> hits;

    public Ship(int length, int startingCoordinate, int orientation, String symbol) {
        this.length = length;
        position = startingCoordinate;
        setOrientationIterator(orientation);
        endOfShip = position + length*orientationIterator;
        this.symbol = symbol;
        hits = new HashMap<>();
    }

    private void setOrientationIterator(int orientation) {
        if (orientation == 0) {
            orientationIterator = 1;
        } else  {
            orientationIterator = 10;
        }
    }

    public int getLength() {
        return length;
    }


    public boolean checkHit(int coordinate) {
        for (int i = position; i < endOfShip; i += orientationIterator) {
            if (i == coordinate){
                incrementHits(coordinate);
                return true;
            }
        }
        return false;
    }

    private void incrementHits(int coordinate) {
        hits.put(coordinate, true);
        if (hits.size() == length) {
            sunk = true;
        }
    }

    public int getHits() {
        return hits.size();
    }

    public boolean isSunk() {
        return sunk;
    }

    public String getSymbol() {
        return symbol;
    }

    public void updateSunkSymbol(Board newBoard) {
        for (int i = position; i < endOfShip; i += orientationIterator) {
            newBoard.upDateBoardState(i%10, i/10, "X");
        }
    }

    public HashMap<Integer,String> getCoodinates() {
        HashMap<Integer, String> coordinates = new HashMap<>();
        for (int i = position; i < endOfShip; i += orientationIterator) {
            coordinates.put(i, symbol);
        }
        return coordinates;
    }
}
