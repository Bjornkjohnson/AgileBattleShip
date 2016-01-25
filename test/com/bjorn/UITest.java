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


        String printedBoard = ANSI_CLS_HOME +
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
        newUI.printBoard(newBoard);
        assertEquals(printedBoard, outContent.toString());
    }

    @Test
    public void testPrintOneMissGameBoard() throws Exception {

        Board oneMissBoard = new Board();
        oneMissBoard.upDateBoardState(0, 0, "M");
        String printedBoard = ANSI_CLS_HOME +
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
        newUI.printBoard(oneMissBoard);
        assertEquals(printedBoard, outContent.toString());
    }

    @Test
    public void testMissInMiddleOfBoard() throws Exception {

        Board oneMissBoard = new Board();
        oneMissBoard.upDateBoardState(5, 4, "M");
        String printedBoard = ANSI_CLS_HOME +
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
        newUI.printBoard(oneMissBoard);
        assertEquals(printedBoard, outContent.toString());
    }

    @Test
    public void testPrintWelcome() throws Exception {
        String testWelcome = "";
        String testTitle = "" +
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
        testWelcome += ANSI_CLS_HOME;
        for (int i = 0; i < 20; i++) {
            testWelcome += ANSI_RED+testTitle+ANSI_RESET;
            testWelcome += ANSI_CLS_HOME;
            testWelcome += testTitle;
            testWelcome += ANSI_CLS_HOME;

        }
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
        oneShip.placeShip(0,0, "S");
        String printedBoard = ANSI_CLS_HOME +
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
        newUI.printBoard(oneShip);
        assertEquals(printedBoard, outContent.toString());
    }

}
