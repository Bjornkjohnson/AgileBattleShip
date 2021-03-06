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
        newBoard.upDateBoardState(0,1, "M");
        assertEquals("M", newBoard.getCellState(0,1));
    }

    @Test
    public void testUpdateWithHit() {
        Ship newShip = new Ship(2, 0, "S");
        newBoard.placeShip(newShip);
        newBoard.upDateBoardState(0,0, "H");
        assertEquals("H", newBoard.getCellState(0,0));
    }

    @Test(expected = RuntimeException.class)
    public void shouldNotOverlapShips() {
        Ship newShip1 = new Ship(2, 0, "S");
        Ship newShip2 = new Ship(2, 0, "S");
        newBoard.placeShip(newShip1);
        newBoard.placeShip(newShip2);
    }

    @Test(expected = RuntimeException.class)
    public void shipShouldNotExtendOffBoardVertically() throws Exception {
        Ship newShip1 = new Ship(2, 1, "S");
        newShip1.updatePosition(99);
        newBoard.placeShip(newShip1);
    }

    @Test(expected = RuntimeException.class)
    public void shipShouldNotExtendOffBoardHorizontally() throws Exception {
        Ship newShip1 = new Ship(2, 0, "S");
        newShip1.updatePosition(99);
        newBoard.placeShip(newShip1);
    }

    @Test(expected = RuntimeException.class)
    public void shipShouldNotWrapAroundVoard() throws Exception {
        Ship newShip1 = new Ship(5, 0, "S");
        newShip1.updatePosition(8);
        newBoard.placeShip(newShip1);
    }

}
