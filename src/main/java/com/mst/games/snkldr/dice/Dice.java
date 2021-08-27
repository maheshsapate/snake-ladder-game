package com.mst.games.snkldr.dice;

public class Dice {

    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 6;

    private RollingStrategy rollingStrategy;

    public Dice(RollingStrategy rollingStrategy) {
        this.rollingStrategy = rollingStrategy;
    }

    public int roll() {
        int move = rollingStrategy.roll();
        if (isInLimit(move)) {
            return move;
        }
        throw new IllegalStateException("Invalid roll " + move + " from dice");
    }

    private boolean isInLimit(int move) {
        return MIN_NUMBER <= move && move <= MAX_NUMBER;
    }

}
