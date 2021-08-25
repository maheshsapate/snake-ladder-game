package com.mst.games.snkldr.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private Player player = new Player();

    @Test
    public void startPositionTest() {
        int pos = player.getPosition();
        Assertions.assertEquals(0, pos);
    }
}
