package com.bjorn;


import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class GameTest {
    UI mockUI;
    Board mockComputerBoard;
    Board mockPlayerBoard;
    Game newGame;
    BoardSetup newSetup;

    @Before
    public void setUp() {
        mockUI = mock(UI.class);
        mockComputerBoard = mock(Board.class);
        mockPlayerBoard = mock(Board.class);
        newSetup = new BoardSetup();
        newGame = new Game(mockUI, mockComputerBoard, mockPlayerBoard, newSetup);
        stub(mockUI.getUserInput()).toReturn("a0");
        newGame.startGame();

    }

    @Test
    public void checkIfWelcomeIsCalled() {
        verify(mockUI, times(1)).printWelcome();
    }

    @Test
    public void checkIfPrintBoardIsCalled() {
        verify(mockUI, atLeastOnce()).printBoard(mockComputerBoard, false);
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
        verify(mockComputerBoard, atLeastOnce()).upDateBoardState(0, 0, "M");
    }

}
