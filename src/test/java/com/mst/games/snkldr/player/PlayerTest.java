package com.mst.games.snkldr.player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mst.games.snkldr.board.Board;

class PlayerTest {

    private Player player = new Player();

    @Test
    void startPositionTest() {
        int pos = player.getPosition();
        Assertions.assertEquals(Board.START_POSITION, pos);
    }

    @Test
    void setPositionTest() {
        player.setPosition(45);
        Assertions.assertEquals(45, player.getPosition());
    }
}
