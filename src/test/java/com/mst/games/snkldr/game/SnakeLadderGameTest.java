package com.mst.games.snkldr.game;

import java.time.Duration;
import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.google.common.collect.Sets;
import com.mst.games.snkldr.board.Board;
import com.mst.games.snkldr.board.item.BoardItem;
import com.mst.games.snkldr.board.item.Ladder;
import com.mst.games.snkldr.board.item.Snake;
import com.mst.games.snkldr.dice.Dice;
import com.mst.games.snkldr.dice.RollingStrategy;

class SnakeLadderGameTest {

    @Mock
    private Board board;
    @Mock
    private Dice dice;

    private SnakeLadderGame game;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        game = new SnakeLadderGame(board, dice);
    }

    @Test
    void onDiceRollChangePlayerPositionTest() {
        int playerPosition = game.getPlayerPosition();
        int diceMove = 5;
        Mockito.when(dice.roll()).thenReturn(diceMove);
        Mockito.when(board.getNextPosition(ArgumentMatchers.anyInt())).thenReturn(diceMove + playerPosition);
        game.rollDice();
        Assertions.assertTrue(game.getPlayerPosition() > Board.START_POSITION);
        Assertions.assertEquals(diceMove + playerPosition, game.getPlayerPosition());
    }

    @Test
    void onDiceRollPlayerPositionUnchangedTest() {
        int diceMove = 5;
        Mockito.when(dice.roll()).thenReturn(diceMove, diceMove);
        Mockito.when(board.getNextPosition(ArgumentMatchers.anyInt())).thenReturn(Board.END_POSITION);
        game.rollDice();
        int playerPosition = game.getPlayerPosition();
        game.rollDice();

        Assertions.assertEquals(playerPosition, game.getPlayerPosition());
        Mockito.verify(dice, Mockito.atMost(2)).roll();
        Mockito.verify(board, Mockito.atMostOnce()).getNextPosition(ArgumentMatchers.anyInt());
    }

    @Test
    void gameEndToEndTest() {
        Set<BoardItem> boardItems = Sets.newHashSet(new Snake(14, 7), new Ladder(15, 30), new Snake(47, 29), new Ladder(57, 80));
        SnakeLadderGame game = new SnakeLadderGame(new Board(boardItems), new Dice(RollingStrategy.RANDOM_STRATEGY));

        Assertions.assertTimeout(Duration.ofSeconds(3), () -> {
            while (!game.isGameOver()) {
                game.rollDice();
            }
        });
        Assertions.assertEquals(Board.END_POSITION, game.getPlayerPosition());
    }
}
