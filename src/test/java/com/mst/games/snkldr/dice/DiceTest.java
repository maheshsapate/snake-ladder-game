package com.mst.games.snkldr.dice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class DiceTest {

    private Dice dice = new Dice();

    @Test
    public void rollDiceTest() {
        int result = dice.roll();
        Assertions.assertTrue(result >= Dice.MIN_NUMBER);
        Assertions.assertTrue(result <= Dice.MAX_NUMBER);
    }
}
