package com.bjorn;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class BoardTest {
    private Board newBoard;
    private HashMap<Integer, String> boardState;

    @Before
    public void setUp() {
        newBoard = new Board();
        boardState = new HashMap<>();
    }

    @Test
    public void getNewEmptyBoard() throws Exception {
        assertEquals(boardState, newBoard.getBoardState());
    }
}
