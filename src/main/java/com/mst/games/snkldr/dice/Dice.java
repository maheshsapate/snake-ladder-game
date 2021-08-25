package com.mst.games.snkldr.dice;

import java.util.Random;

public class Dice {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 6;

    private static final Random RANDOM = new Random();

    public int roll() {
        return RANDOM.ints(MIN_NUMBER, MAX_NUMBER + 1)
            .findFirst()
            .getAsInt();
    }

}
