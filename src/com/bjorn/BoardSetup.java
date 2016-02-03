package com.bjorn;

import java.util.Random;

public class BoardSetup {
    public Board randomBoard(Ship fleet[], Board newBoard) {
        for (int i = 0; i < fleet.length; i++) {
            while (true) {
                try {
                    fleet[i] = new Ship(2, 0, "S");
                    fleet[i].updatePosition(getRandomNumber());
                    newBoard.placeShip(fleet[i]);
                    break;
                } catch (RuntimeException e) {
                }
            }
        }
        return newBoard;
    }

    private int getRandomNumber() {
        Random r = new Random();
        int Low = 0;
        int High = 99;
        return r.nextInt(High-Low) + Low;
    }

}
