package com.bjorn;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;

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
    public void testPrintEmptyGameBoard() throws Exception {
        newUI.printBoard(newBoard);
        assertEquals(GameConstants.emptyBoard, outContent.toString());
    }

    @Test
    public void testPrintOneMissGameBoard() throws Exception {
        Board oneMissBoard = new Board();
        oneMissBoard.upDateBoardState(0, 0, "M");
        newUI.printBoard(oneMissBoard);
        assertEquals(GameConstants.singleMissBoard, outContent.toString());
    }

    @Test
    public void testMissInMiddleOfBoard() throws Exception {
        Board oneMissBoard = new Board();
        oneMissBoard.upDateBoardState(5, 4, "M");
        newUI.printBoard(oneMissBoard);
        assertEquals(GameConstants.middleMissBoard, outContent.toString());
    }

    @Test
    public void testPrintWelcome() throws Exception {
        String testWelcome = buildMessage(GameConstants.title);
        newUI.printWelcome();
        assertEquals(testWelcome, outContent.toString());
    }

    @Test
    public void getCoordinatesFromUser() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        assertEquals(1, newUI.getUserInput());
    }

    @Test
    public void promptUserForXCoordinates() throws Exception {
        String prompt = "Please Enter X Coordinate: ";
        newUI.promptForXCoordinate();
        assertEquals(prompt, outContent.toString());
    }

    @Test
    public void promptUserForYCoordinates() throws Exception {
        String prompt = "Please Enter Y Coordinate: ";
        newUI.promptForYCoordinate();
        assertEquals(prompt, outContent.toString());
    }

    @Test
    public void shouldNotPrintShipOnOppenentBoard() throws Exception {
        Board oneShip = new Board();
        Ship newShip = new Ship(2, 0, "S");
        oneShip.placeShip(newShip);
        newUI.printBoard(oneShip);
        assertEquals(GameConstants.printedBoard, outContent.toString());
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
}
