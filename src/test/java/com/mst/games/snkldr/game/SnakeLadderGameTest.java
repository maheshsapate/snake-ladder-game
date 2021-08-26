package com.mst.games.snkldr.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.mst.games.snkldr.board.Board;
import com.mst.games.snkldr.dice.Dice;

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
}
