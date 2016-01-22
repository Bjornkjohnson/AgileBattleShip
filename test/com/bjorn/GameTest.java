package com.bjorn;


import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
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
        verify(mockUI, times(1)).printBoard(mockBoard);
    }
}
