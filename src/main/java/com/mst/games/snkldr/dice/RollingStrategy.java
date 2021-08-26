package com.mst.games.snkldr.dice;

import java.util.Random;

public interface RollingStrategy {

    static final Random RANDOM = new Random();

    int roll();

    static final RollingStrategy RANDOM_STRATEGY = () -> Dice.MIN_NUMBER + RANDOM.nextInt(Dice.MAX_NUMBER);

    static final RollingStrategy EVEN_STRATEGY = () -> 2 + RANDOM.nextInt(Dice.MAX_NUMBER / 2) * 2;

}
