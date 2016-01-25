package com.bjorn;


import org.junit.Test;
import org.mockito.Mockito;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GameTest {

    @Test
    public void checkIfWelcomeIsCalled() {
        UI mockUI = Mockito.mock(UI.class);
        Board mockBoard = Mockito.mock(Board.class);
        Game newGame = new Game(mockUI, mockBoard);
        newGame.startGame();
        verify(mockUI, atLeastOnce()).printWelcome();
    }

    @Test
    public void checkIfPrintBoardIsCalled() {
        UI mockUI = Mockito.mock(UI.class);
        Board mockBoard = Mockito.mock(Board.class);
        Game newGame = new Game(mockUI, mockBoard);
        newGame.startGame();
        verify(mockUI, atLeastOnce()).printBoard(mockBoard);
    }

    @Test
    public void checkIfPromptForXCoordinateIsCalled() {
        UI mockUI = Mockito.mock(UI.class);
        Board mockBoard = Mockito.mock(Board.class);
        Game newGame = new Game(mockUI, mockBoard);
        newGame.startGame();
        verify(mockUI, atLeastOnce()).promptForXCoordinate();
    }

    @Test
    public void checkIfPromptForYCoordinateIsCalled() {
        UI mockUI = Mockito.mock(UI.class);
        Board mockBoard = Mockito.mock(Board.class);
        Game newGame = new Game(mockUI, mockBoard);
        newGame.startGame();
        verify(mockUI, atLeastOnce()).promptForYCoordinate();
    }

    @Test
    public void checkIfGetUserInputIsCalled() {
        UI mockUI = Mockito.mock(UI.class);
        Board mockBoard = Mockito.mock(Board.class);
        Game newGame = new Game(mockUI, mockBoard);
        newGame.startGame();
        verify(mockUI, atLeastOnce()).getUserInput();
    }

    @Test
    public void checkIfUpdateBoardStateIsCalled() {
        UI mockUI = Mockito.mock(UI.class);
        Board mockBoard = Mockito.mock(Board.class);
        Game newGame = new Game(mockUI, mockBoard);
        newGame.startGame();
        verify(mockBoard, atLeastOnce()).upDateBoardState(0, 0, "H");
    }

    @Test
    public void testComputerShipPlacement() {
        HashMap<Integer, String> testBoardState  = new HashMap<>();
        testBoardState.put(0, "H");
        testBoardState.put(1, "S");
        testBoardState.put(2, "S");
        testBoardState.put(3, "S");
        UI mockUI = Mockito.mock(UI.class);
        Board testBoard = new Board();
        Game newGame = new Game(mockUI, testBoard);
        newGame.startGame();
        assertEquals(testBoardState, testBoard.getBoardState());
    }
}
