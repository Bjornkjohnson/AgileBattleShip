package com.bjorn;


import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class GameTest {
    UI mockUI;
    Board mockBoard;
    Game newGame;
    BoardSetup newSetup;

    @Before
    public void setUp() {
        mockUI = mock(UI.class);
        mockBoard = mock(Board.class);
        newSetup = new BoardSetup();
        newGame = new Game(mockUI, mockBoard, newSetup);
        stub(mockUI.getUserInput()).toReturn("a0");
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
    public void checkIfPromptForCoordinatesIsCalled() {
        verify(mockUI, atLeastOnce()).promptForCoordinates();
    }

    @Test
    public void checkIfGetUserInputIsCalled() {
        verify(mockUI, atLeastOnce()).getUserInput();
    }

    @Test
    public void checkIfUpdateBoardStateIsCalled() {
        verify(mockBoard, atLeastOnce()).upDateBoardState(0, 0, "M");
    }

}
