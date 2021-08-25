package com.mst.games.snkldr.board;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BoardTest {

    private Board board = new Board();

    @Test
    public void boardSizeTest() {
        Assertions.assertEquals(100, board.getSize());
    }

}
