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
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_CLS_HOME = "\033[2J\u001B[H";
    private static final String testTitle = "" +
            "██╗    ██╗███████╗██╗      ██████╗ ██████╗ ███╗   ███╗███████╗    ████████╗ ██████╗ \n" +
            "██║    ██║██╔════╝██║     ██╔════╝██╔═══██╗████╗ ████║██╔════╝    ╚══██╔══╝██╔═══██╗\n" +
            "██║ █╗ ██║█████╗  ██║     ██║     ██║   ██║██╔████╔██║█████╗         ██║   ██║   ██║\n" +
            "██║███╗██║██╔══╝  ██║     ██║     ██║   ██║██║╚██╔╝██║██╔══╝         ██║   ██║   ██║\n" +
            "╚███╔███╔╝███████╗███████╗╚██████╗╚██████╔╝██║ ╚═╝ ██║███████╗       ██║   ╚██████╔╝\n" +
            " ╚══╝╚══╝ ╚══════╝╚══════╝ ╚═════╝ ╚═════╝ ╚═╝     ╚═╝╚══════╝       ╚═╝    ╚═════╝ \n" +
            "                                                                                    \n" +
            "██████╗  █████╗ ████████╗████████╗██╗     ███████╗███████╗██╗  ██╗██╗██████╗ \n" +
            "██╔══██╗██╔══██╗╚══██╔══╝╚══██╔══╝██║     ██╔════╝██╔════╝██║  ██║██║██╔══██╗\n" +
            "██████╔╝███████║   ██║      ██║   ██║     █████╗  ███████╗███████║██║██████╔╝\n" +
            "██╔══██╗██╔══██║   ██║      ██║   ██║     ██╔══╝  ╚════██║██╔══██║██║██╔═══╝ \n" +
            "██████╔╝██║  ██║   ██║      ██║   ███████╗███████╗███████║██║  ██║██║██║     \n" +
            "╚═════╝ ╚═╝  ╚═╝   ╚═╝      ╚═╝   ╚══════╝╚══════╝╚══════╝╚═╝  ╚═╝╚═╝╚═╝     \n";
    private static final String emptyBoard = ANSI_CLS_HOME +
            "   0   1   2   3   4   5   6   7   8   9  \n" +
            "0|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "1|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "2|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "3|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "4|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "5|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "6|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "7|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "8|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "9|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n";
    private static final String singleMissBoard = ANSI_CLS_HOME +
            "   0   1   2   3   4   5   6   7   8   9  \n" +
            "0|_M_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "1|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "2|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "3|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "4|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "5|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "6|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "7|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "8|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "9|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n";
    private static final String middleMissBoard = ANSI_CLS_HOME +
            "   0   1   2   3   4   5   6   7   8   9  \n" +
            "0|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "1|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "2|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "3|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "4|_~_|_~_|_~_|_~_|_~_|_M_|_~_|_~_|_~_|_~_|\n" +
            "5|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "6|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "7|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "8|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "9|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n";
    private static final String printedBoard = ANSI_CLS_HOME +
            "   0   1   2   3   4   5   6   7   8   9  \n" +
            "0|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "1|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "2|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "3|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "4|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "5|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "6|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "7|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "8|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "9|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n";
    private static final String shipSunk = "" +
            "███████╗██╗  ██╗██╗██████╗     ███████╗██╗   ██╗███╗   ██╗██╗  ██╗██╗\n" +
            "██╔════╝██║  ██║██║██╔══██╗    ██╔════╝██║   ██║████╗  ██║██║ ██╔╝██║\n" +
            "███████╗███████║██║██████╔╝    ███████╗██║   ██║██╔██╗ ██║█████╔╝ ██║\n" +
            "╚════██║██╔══██║██║██╔═══╝     ╚════██║██║   ██║██║╚██╗██║██╔═██╗ ╚═╝\n" +
            "███████║██║  ██║██║██║         ███████║╚██████╔╝██║ ╚████║██║  ██╗██╗\n" +
            "╚══════╝╚═╝  ╚═╝╚═╝╚═╝         ╚══════╝ ╚═════╝ ╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝\n" +
            "                                                                     \n";


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
        assertEquals(emptyBoard, outContent.toString());
    }

    @Test
    public void testPrintOneMissGameBoard() throws Exception {
        Board oneMissBoard = new Board();
        oneMissBoard.upDateBoardState(0, 0, "M");
        newUI.printBoard(oneMissBoard);
        assertEquals(singleMissBoard, outContent.toString());
    }

    @Test
    public void testMissInMiddleOfBoard() throws Exception {
        Board oneMissBoard = new Board();
        oneMissBoard.upDateBoardState(5, 4, "M");
        newUI.printBoard(oneMissBoard);
        assertEquals(middleMissBoard, outContent.toString());
    }

    @Test
    public void testPrintWelcome() throws Exception {
        String testWelcome = buildTitleString();
        newUI.printWelcome();
        assertEquals(testWelcome, outContent.toString());
    }

    private String buildTitleString() {
        String testWelcome = "";
        testWelcome += ANSI_CLS_HOME;
        for (int i = 0; i < 20; i++) {
            testWelcome += ANSI_RED+testTitle+ANSI_RESET;
            testWelcome += ANSI_CLS_HOME;
            testWelcome += testTitle;
            testWelcome += ANSI_CLS_HOME;
        }
        return testWelcome;
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
        oneShip.placeShip(0,0, "S");
        newUI.printBoard(oneShip);
        assertEquals(printedBoard, outContent.toString());
    }

    @Test
    public void testShipSunkMessage() throws Exception {
        String testSunkMessage = "";
        testSunkMessage += ANSI_CLS_HOME;
        for (int i = 0; i < 20; i++) {
            testSunkMessage += ANSI_RED+shipSunk+ANSI_RESET;
            testSunkMessage += ANSI_CLS_HOME;
            testSunkMessage += shipSunk;
            testSunkMessage += ANSI_CLS_HOME;
        }
        newUI.printSunk();
        assertEquals(testSunkMessage, outContent.toString());
    }

}
