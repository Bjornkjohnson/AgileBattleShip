package com.bjorn;


import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GameTest {

    @Test
    public void checkIfWelcomeIsCalled() {
        UI mockUI = Mockito.mock(UI.class);
        Board mockBoard = Mockito.mock(Board.class);
        Game newGame = new Game(mockUI, mockBoard);
        newGame.startGame();
        verify(mockUI, times(1)).printWelcome();
    }

    @Test
    public void checkIfPrintBoardIsCalled() {
        UI mockUI = Mockito.mock(UI.class);
        Board mockBoard = Mockito.mock(Board.class);
        Game newGame = new Game(mockUI, mockBoard);
        newGame.startGame();
        verify(mockUI, times(2)).printBoard(mockBoard);
    }

    @Test
    public void checkIfPromptForXCoordinateIsCalled() {
        UI mockUI = Mockito.mock(UI.class);
        Board mockBoard = Mockito.mock(Board.class);
        Game newGame = new Game(mockUI, mockBoard);
        newGame.startGame();
        verify(mockUI, times(1)).promptForXCoordinate();
    }

    @Test
    public void checkIfPromptForYCoordinateIsCalled() {
        UI mockUI = Mockito.mock(UI.class);
        Board mockBoard = Mockito.mock(Board.class);
        Game newGame = new Game(mockUI, mockBoard);
        newGame.startGame();
        verify(mockUI, times(1)).promptForYCoordinate();
    }

    @Test
    public void checkIfGetUserInputIsCalled() {
        UI mockUI = Mockito.mock(UI.class);
        Board mockBoard = Mockito.mock(Board.class);
        Game newGame = new Game(mockUI, mockBoard);
        newGame.startGame();
        verify(mockUI, times(2)).getUserInput();
    }

    @Test
    public void checkIfUpdateBoardStateIsCalled() {
        UI mockUI = Mockito.mock(UI.class);
        Board mockBoard = Mockito.mock(Board.class);
        Game newGame = new Game(mockUI, mockBoard);
        newGame.startGame();
        verify(mockBoard, times(1)).upDateBoardState(0, 0);
    }
}
