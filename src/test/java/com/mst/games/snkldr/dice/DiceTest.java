package com.mst.games.snkldr.dice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DiceTest {

    private Dice dice;

    @Test
    void rollRandomStrategyDiceTest() {
        dice = new Dice(RollingStrategy.RANDOM_STRATEGY);
        int move = dice.roll();
        Assertions.assertTrue(move >= Dice.MIN_NUMBER);
        Assertions.assertTrue(move <= Dice.MAX_NUMBER);
    }

    @Test
    void rollEvenStrategyDiceTest() {
        dice = new Dice(RollingStrategy.EVEN_STRATEGY);
        int move = dice.roll();
        Assertions.assertTrue(move >= Dice.MIN_NUMBER);
        Assertions.assertTrue(move <= Dice.MAX_NUMBER);
        Assertions.assertEquals(0, move % 2);
    }
}
