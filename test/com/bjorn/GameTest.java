package com.bjorn;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

public class GameTest {
    UI mockUI;
    Board mockBoard;
    Game newGame;
    BoardSetup newSetup;

    @Before
    public void setUp() {
        mockUI = Mockito.mock(UI.class);
        mockBoard = Mockito.mock(Board.class);
        newSetup = new BoardSetup();
        newGame = new Game(mockUI, mockBoard, newSetup);
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
        verify(mockBoard, atLeastOnce()).upDateBoardState(0, 0, "M");
    }

}
