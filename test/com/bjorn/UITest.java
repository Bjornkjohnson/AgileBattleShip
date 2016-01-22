package com.bjorn;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

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
    public void testPrintEmptyGameBoard() {


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
        newUI.printBoard(newBoard);
        assertEquals(printedBoard, outContent.toString());
    }

    @Test
    public void testPrintWelcome(){
        String ANSI_RESET = "\u001B[0m";
        String ANSI_RED = "\u001B[31m";
        String ANSI_CLS = "\033[2J";
        String ANSI_HOME = "\u001b[H";
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
        testWelcome += ANSI_CLS+ANSI_HOME;
        for (int i = 0; i < 20; i++) {
            testWelcome += ANSI_RED+testTitle+ANSI_RESET;
            testWelcome += ANSI_CLS+ANSI_HOME;
            testWelcome += testTitle;
            testWelcome += ANSI_CLS+ANSI_HOME;

        }
        newUI.printWelcome();
        assertEquals(testWelcome, outContent.toString());
    }


}
