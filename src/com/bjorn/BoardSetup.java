package com.bjorn;

import java.util.Random;

public class BoardSetup {
    public Board randomBoard(Ship fleet[], Board newBoard) {
        for (int i = 0; i < fleet.length; i++) {
            while (true) {
                try {
                    placeShip(fleet[i], newBoard, getRandomNumber());
                    break;
                } catch (RuntimeException e) {
                }
            }
        }
        return newBoard;
    }

    private void placeShip(Ship ship, Board board, int position) {
        ship.updatePosition(position);
        board.placeShip(ship);
    }

    private int getRandomNumber() {
        Random r = new Random();
        int Low = 0;
        int High = 99;
        return r.nextInt(High-Low) + Low;
    }

    public Board userSetup(Ship fleet[], Board newBoard) {
        for (int i = 0; i < fleet.length; i++) {
            while (true) {
                try {
                    placeShip(fleet[i], newBoard, i*10);
                    break;
                } catch (RuntimeException e) {
                }
            }
        }
        return newBoard;
    }
}
