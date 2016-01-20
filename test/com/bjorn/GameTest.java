package com.bjorn;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import static org.junit.Assert.assertEquals;

public class GameTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws UnsupportedEncodingException {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUp() {
        System.setOut(null);
    }

    @Test
    public void testPrintEmptyGameBoard() {
        Board newBoard = new Board();
        Game newGame = new Game();

        String printedBoard = "" +
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
        newGame.printBoard(newBoard);
        assertEquals(printedBoard, outContent.toString());
    }




}
