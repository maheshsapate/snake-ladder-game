package com.mst.games.snkldr.board;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {

    private Board board = new Board();

    @Test
    public void boardSizeTest() {
        Assertions.assertEquals(100, Board.BOARD_SIZE);
    }

    @Test
    public void nextPositionTest() {
        int nextPosition = board.getNextPosition(20);
        Assertions.assertEquals(20, nextPosition);
    }

}
