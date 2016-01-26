package com.bjorn;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GameTest {
    UI mockUI;
    Board mockBoard;
    Game newGame;

    @Before
    public void setUp() {
        mockUI = Mockito.mock(UI.class);
        mockBoard = Mockito.mock(Board.class);
        newGame = new Game(mockUI, mockBoard);
        newGame.startGame();

    }

    @Test
    public void checkIfWelcomeIsCalled() {
        verify(mockUI, times(1)).printWelcome();
    }

    @Test
    public void checkIfPrintBoardIsCalled() {
        verify(mockUI, atLeastOnce()).printBoard(mockBoard);
    }

    @Test
    public void checkIfPromptForXCoordinateIsCalled() {
        verify(mockUI, atLeastOnce()).promptForXCoordinate();
    }

    @Test
    public void checkIfPromptForYCoordinateIsCalled() {
        verify(mockUI, atLeastOnce()).promptForYCoordinate();
    }

    @Test
    public void checkIfGetUserInputIsCalled() {
        verify(mockUI, atLeastOnce()).getUserInput();
    }

    @Test
    public void checkIfUpdateBoardStateIsCalled() {
        verify(mockBoard, atLeastOnce()).upDateBoardState(0, 0, "H");
    }

    @Test
    public void testComputerShipPlacement() {
        HashMap<Integer, String> testBoardState  = new HashMap<>();
        testBoardState.put(0, "H");
        testBoardState.put(1, "S");
        testBoardState.put(2, "S");
        testBoardState.put(3, "S");
        Board testBoard = new Board();
        Game newGame = new Game(mockUI, testBoard);
        newGame.startGame();
        assertEquals(testBoardState, testBoard.getBoardState());
    }
}
