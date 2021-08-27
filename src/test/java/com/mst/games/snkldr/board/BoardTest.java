package com.mst.games.snkldr.board;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.mst.games.snkldr.board.item.BoardItem;
import com.mst.games.snkldr.board.item.Ladder;
import com.mst.games.snkldr.board.item.Snake;

class BoardTest {

    private Board board;

    @Test
    void boardSizeTest() {
        Assertions.assertEquals(100, Board.END_POSITION);
    }

    @Test
    void nextPositionTest() {
        board = new Board(new HashSet<BoardItem>());
        int nextPosition = board.getNextPosition(20);
        Assertions.assertEquals(20, nextPosition);
    }

    @Test
    void nextPositionWithSnakeTest() {
        Set<BoardItem> snakes = new HashSet<>();
        snakes.add(new Snake(14, 7));
        board = new Board(snakes);
        int nextPosition = board.getNextPosition(14);
        Assertions.assertEquals(7, nextPosition);
    }

    @Test
    void nextPositionWithLadderTest() {
        Set<BoardItem> ladders = new HashSet<>();
        ladders.add(new Ladder(7, 13));
        board = new Board(ladders);
        int nextPosition = board.getNextPosition(7);
        Assertions.assertEquals(13, nextPosition);
    }

}
