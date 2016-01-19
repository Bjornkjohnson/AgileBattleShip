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
}
