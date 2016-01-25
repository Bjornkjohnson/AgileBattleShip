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

    @Test
    public void getEmptyCell() {
        assertEquals("~", newBoard.getCellState(0,1));
    }

    @Test
    public void getMissCell() {
        newBoard.upDateBoardState(0,1);
        assertEquals("M", newBoard.getCellState(0,1));
    }
}
