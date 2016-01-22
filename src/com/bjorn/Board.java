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

    public String getCellState(int cellCoordinate) {
        return boardState.getOrDefault(cellCoordinate, "~");
    }


    public void upDateBoardState(int coordinates) {
        if (getCellState(coordinates) == "~"){
            boardState.put(coordinates,"M");
        }

    }
}
