package com.bjorn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.junit.Assert.assertEquals;

public class UITest {
    private Board newBoard;
    private UI newUI;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws UnsupportedEncodingException {
        System.setOut(new PrintStream(outContent));
        newBoard = new Board();
        newUI = new UI();
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }

    @Test
    public void testPrintEmptyComputerGameBoard() throws Exception {
        newUI.printBoard(newBoard, false);
        assertEquals(GameConstants.emptyComputerBoard, outContent.toString());
    }

    @Test
    public void testPrintEmptyUserGameBoard() throws Exception {
        newUI.printBoard(newBoard, true);
        assertEquals(GameConstants.emptyUserBoard, outContent.toString());
    }

    @Test
    public void testPrintOneMissGameBoard() throws Exception {
        Board oneMissBoard = new Board();
        oneMissBoard.upDateBoardState(0, 0, "M");
        newUI.printBoard(oneMissBoard, false);
        assertThat(outContent.toString(), containsString("a|_"+GameConstants.miss +"_|"));
    }

    @Test
    public void testMissInMiddleOfBoard() throws Exception {
        Board oneMissBoard = new Board();
        oneMissBoard.upDateBoardState(5, 4, "M");
        newUI.printBoard(oneMissBoard, false);
        assertThat(outContent.toString(), containsString(GameConstants.middleMissBoard));
    }

    @Test
    public void testPrintWelcome() throws Exception {
        String testWelcome = buildMessage(GameConstants.title);
        newUI.printWelcome();
        assertEquals(testWelcome, outContent.toString());
    }

    @Test
    public void getCoordinatesFromUser() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("a1".getBytes());
        System.setIn(in);
        assertEquals("a1", newUI.getUserInput());
    }

    @Test
    public void promptUserForCoordinates() throws Exception {
        String prompt = "Please Enter Coordinates: ";
        newUI.promptForCoordinates();
        assertEquals(prompt, outContent.toString());
    }

    @Test
    public void shouldNotPrintShipOnOppenentBoard() throws Exception {
        Board oneShip = new Board();
        Ship newShip = new Ship(2, 0, GameConstants.submarine);
        oneShip.placeShip(newShip);
        newUI.printBoard(oneShip, false);
        assertThat(outContent.toString(), not(containsString(GameConstants.submarine)));
    }

    @Test
    public void testShipSunkMessage() throws Exception {
        String testSunkMessage = buildMessage(GameConstants.shipSunk);
        newUI.printSunk();
        assertEquals(testSunkMessage, outContent.toString());
    }

    @Test
    public void testGameOverMessage() throws Exception {
        String testGameOverMessage = buildMessage(GameConstants.gameOver);
        newUI.printGameOver();
        assertEquals(testGameOverMessage, outContent.toString());
    }

    @Test
    public void testInvalidInputMessage() throws Exception {
        String testInvalidInputMessage = buildMessage(GameConstants.invalidInput);
        newUI.printInvalidInput();
        assertEquals(testInvalidInputMessage, outContent.toString());
    }

    @Test
    public void testYouWinMessage() throws Exception {
        String testYouWinMessage = buildMessage(GameConstants.youWin);
        newUI.printYouWin();
        assertEquals(testYouWinMessage, outContent.toString());
    }

    private String buildMessage(String message) {
        String builtString = "";
        builtString += GameConstants.ANSI_CLS_HOME;
        for (int i = 0; i < 20; i++) {
            builtString += GameConstants.ANSI_RED+message+GameConstants.ANSI_RESET;
            builtString += GameConstants.ANSI_CLS_HOME;
            builtString += message;
            builtString += GameConstants.ANSI_CLS_HOME;
        }
        return builtString;
    }

    @Test
    public void testPrintBoardShowingShips() throws Exception {
        Ship newShip = new Ship(2, 0, "S");
        newBoard.placeShip(newShip);
        newUI.printBoard(newBoard, true);
        assertThat(outContent.toString(), containsString("a|_"+GameConstants.submarine+"_|_"+GameConstants.submarine+"_|_"));
    }

}
