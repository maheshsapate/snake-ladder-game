package com.mst.games.snkldr.board;

import java.security.InvalidParameterException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoardItemTest {

    @Test
    void belowStartPositionTest() {
        Assertions.assertThrows(InvalidParameterException.class, () -> new Snake(0, 14));
        Assertions.assertThrows(InvalidParameterException.class, () -> new Ladder(0, 10));
    }

    @Test
    void aboveEndPositionTest() {
        Assertions.assertThrows(InvalidParameterException.class, () -> new Snake(1000, 14));
        Assertions.assertThrows(InvalidParameterException.class, () -> new Ladder(1000, 10010));
    }

    @Test
    void snakeValidationTest() {
        Assertions.assertThrows(InvalidParameterException.class, () -> new Snake(10, 14));
    }

    @Test
    void ladderValidationTest() {
        Assertions.assertThrows(InvalidParameterException.class, () -> new Ladder(14, 10));
    }
}
