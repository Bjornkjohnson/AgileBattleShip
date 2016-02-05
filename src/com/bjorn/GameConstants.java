package com.bjorn;

public class GameConstants {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_CLS_HOME = "\033[2J\u001B[H";
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
    public static final String emptyUserBoard = ANSI_CLS_HOME +
            "\tYour Board\n" +
            "   0   1   2   3   4   5   6   7   8   9  \n" +
            "a|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "b|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "c|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "d|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "e|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "f|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "g|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "h|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "i|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "j|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n";
    public static final String emptyComputerBoard = "\tOpponent Board\n" +
            "   0   1   2   3   4   5   6   7   8   9  \n" +
            "a|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "b|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "c|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "d|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "e|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "f|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "g|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "h|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "i|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "j|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n";
    public static final String singleMissBoard = "\tOpponent Board\n" +
            "   0   1   2   3   4   5   6   7   8   9  \n" +
            "a|_M_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "b|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "c|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "d|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "e|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "f|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "g|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "h|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "i|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "j|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n";
    public static final String middleMissBoard = "\tOpponent Board\n" +
            "   0   1   2   3   4   5   6   7   8   9  \n" +
            "a|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "b|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "c|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "d|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "e|_~_|_~_|_~_|_~_|_~_|_M_|_~_|_~_|_~_|_~_|\n" +
            "f|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "g|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "h|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "i|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "j|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n";
    public static final String printedBoard = "\tOpponent Board\n" +
            "   0   1   2   3   4   5   6   7   8   9  \n" +
            "a|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "b|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "c|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "d|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "e|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "f|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "g|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "h|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "i|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "j|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n";
    public static final String showShipBoard = ANSI_CLS_HOME +
            "\tYour Board\n" +
            "   0   1   2   3   4   5   6   7   8   9  \n" +
            "a|_S_|_S_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "b|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "c|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "d|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "e|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "f|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "g|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "h|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "i|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n" +
            "j|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|_~_|\n";
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
