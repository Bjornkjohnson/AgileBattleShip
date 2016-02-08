package com.bjorn;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BoardSetupTest {
    private Ship newFleet[];
    private Board testBoard;
    BoardSetup newPlacement;

    @Before
    public void setUp() throws Exception {
        newFleet = new Ship[1];
        newFleet[0] = new Ship(2,0,"S");
        testBoard = new Board();
        newPlacement = new BoardSetup();
    }

    @Test
    public void randomBoardShouldNotBeBlank() throws Exception {
        HashMap<Integer, String> blankBoard = new HashMap<>();
        Board randomBoard = newPlacement.randomBoard(newFleet, testBoard);
        assertNotEquals(blankBoard, randomBoard.getBoardState());
    }

    @Test
    public void testBoardWithOneSizeTwoShip() throws Exception {
        HashMap<Integer, String> boardState;
        Board randomBoard = newPlacement.randomBoard(newFleet, testBoard);
        boardState = randomBoard.getBoardState();
        assertEquals(2, boardState.size());
    }

    @Test
    public void testPlacingTwoUserShips() throws Exception {
        newFleet = new Ship[5];
        newFleet[0] = new Ship(2,0,"S");
        newFleet[1] = new Ship(3,0,"S");
        newFleet[2] = new Ship(3,0,"S");
        newFleet[3] = new Ship(4,0,"S");
        newFleet[4] = new Ship(5,0,"S");
        HashMap<Integer, String> boardState;
        Board userBoard = newPlacement.userSetup(newFleet, testBoard);
        boardState = userBoard.getBoardState();
        assertEquals(17, boardState.size());
    }

}
