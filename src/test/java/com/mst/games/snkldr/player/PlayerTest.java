package com.mst.games.snkldr.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlayerTest {

    private Player player = new Player();

    @Test
    public void startPositionTest() {
        int pos = player.getPosition();
        Assertions.assertEquals(Player.INITIAL_POSITION, pos);
    }

    @Test
    public void setPositionTest() {
        player.setPosition(45);
        Assertions.assertEquals(45, player.getPosition());
    }
}
