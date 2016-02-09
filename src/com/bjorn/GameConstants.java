package com.bjorn;

public class GameConstants {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_CLS_HOME = "\033[2J\u001B[H";
    public static final String destroyer = ANSI_RED + "D" + ANSI_RESET;
    public static final String cruiser = ANSI_RED + "C" + ANSI_RESET;
    public static final String submarine = ANSI_RED + "S" + ANSI_RESET;
    public static final String battleship = ANSI_RED + "B" + ANSI_RESET;
    public static final String aircraftCarrier = ANSI_RED + "A" + ANSI_RESET;
    public static final String blueWater = ANSI_BLUE + "~" + ANSI_RESET;
    public static final String title = "" +
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
    public static final String emptyUserBoard = ANSI_CLS_HOME + "\tYour Board\n" + blankBoard();

    public static final String emptyComputerBoard = "\tOpponent Board\n" + blankBoard();

    private static String blankBoard() {
        String board = "   0   1   2   3   4   5   6   7   8   9  \n";
        for (int i = 0; i < 10; i++) {
            board += convertNumberToLetter(i) + "|"+ emptyWaterLine();
        }

        return  board;

    }

    private static String emptyWaterLine() {
        String line = "";
        for (int i=0; i <10; i++) {
            line += "_"+blueWater+"_|";
        }
        return line + "\n";
    }

    private static String convertNumberToLetter(int num) {
        return String.valueOf((char)(num + 'a'));
    }

    public static final String middleMissBoard = "e|_"+blueWater+"_|_"+blueWater+"_|_"+blueWater+
                                                    "_|_"+blueWater+"_|_"+blueWater+"_|_M_|";


    public static final String shipSunk = "" +
            "███████╗██╗  ██╗██╗██████╗     ███████╗██╗   ██╗███╗   ██╗██╗  ██╗██╗\n" +
            "██╔════╝██║  ██║██║██╔══██╗    ██╔════╝██║   ██║████╗  ██║██║ ██╔╝██║\n" +
            "███████╗███████║██║██████╔╝    ███████╗██║   ██║██╔██╗ ██║█████╔╝ ██║\n" +
            "╚════██║██╔══██║██║██╔═══╝     ╚════██║██║   ██║██║╚██╗██║██╔═██╗ ╚═╝\n" +
            "███████║██║  ██║██║██║         ███████║╚██████╔╝██║ ╚████║██║  ██╗██╗\n" +
            "╚══════╝╚═╝  ╚═╝╚═╝╚═╝         ╚══════╝ ╚═════╝ ╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝\n" +
            "                                                                     \n";
    public static final String gameOver = "" +
            " ██████╗  █████╗ ███╗   ███╗███████╗     ██████╗ ██╗   ██╗███████╗██████╗ \n" +
            "██╔════╝ ██╔══██╗████╗ ████║██╔════╝    ██╔═══██╗██║   ██║██╔════╝██╔══██╗\n" +
            "██║  ███╗███████║██╔████╔██║█████╗      ██║   ██║██║   ██║█████╗  ██████╔╝\n" +
            "██║   ██║██╔══██║██║╚██╔╝██║██╔══╝      ██║   ██║╚██╗ ██╔╝██╔══╝  ██╔══██╗\n" +
            "╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗    ╚██████╔╝ ╚████╔╝ ███████╗██║  ██║\n" +
            " ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝     ╚═════╝   ╚═══╝  ╚══════╝╚═╝  ╚═╝\n";

    public static final String invalidInput = "" +
            "██╗███╗   ██╗██╗   ██╗ █████╗ ██╗     ██╗██████╗     ██╗███╗   ██╗██████╗ ██╗   ██╗████████╗██╗\n"+
            "██║████╗  ██║██║   ██║██╔══██╗██║     ██║██╔══██╗    ██║████╗  ██║██╔══██╗██║   ██║╚══██╔══╝██║\n"+
            "██║██╔██╗ ██║██║   ██║███████║██║     ██║██║  ██║    ██║██╔██╗ ██║██████╔╝██║   ██║   ██║   ██║\n"+
            "██║██║╚██╗██║╚██╗ ██╔╝██╔══██║██║     ██║██║  ██║    ██║██║╚██╗██║██╔═══╝ ██║   ██║   ██║   ╚═╝\n"+
            "██║██║ ╚████║ ╚████╔╝ ██║  ██║███████╗██║██████╔╝    ██║██║ ╚████║██║     ╚██████╔╝   ██║   ██╗\n"+
            "╚═╝╚═╝  ╚═══╝  ╚═══╝  ╚═╝  ╚═╝╚══════╝╚═╝╚═════╝     ╚═╝╚═╝  ╚═══╝╚═╝      ╚═════╝    ╚═╝   ╚═╝\n";

    public static final String youWin = "" +
            "██╗   ██╗ ██████╗ ██╗   ██╗    ██╗    ██╗██╗███╗   ██╗██╗\n" +
            "╚██╗ ██╔╝██╔═══██╗██║   ██║    ██║    ██║██║████╗  ██║██║\n" +
            " ╚████╔╝ ██║   ██║██║   ██║    ██║ █╗ ██║██║██╔██╗ ██║██║\n" +
            "  ╚██╔╝  ██║   ██║██║   ██║    ██║███╗██║██║██║╚██╗██║╚═╝\n" +
            "   ██║   ╚██████╔╝╚██████╔╝    ╚███╔███╔╝██║██║ ╚████║██╗\n" +
            "   ╚═╝    ╚═════╝  ╚═════╝      ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝╚═╝\n";

}
