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
import com.mst.games.snkldr.player.Player;

class SnakeLadderGameTest {

    @Mock
    private Board board;
    @Mock
    private Dice dice;

    private Player player = new Player();
    private SnakeLadderGame game;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        game = new SnakeLadderGame(board, dice, player);
    }

    @Test
    void onDiceRollChangePlayerPositionTest() {
        int playerPosition = player.getPosition();
        int diceMove = 5;
        Mockito.when(dice.roll()).thenReturn(diceMove);
        Mockito.when(board.getNextPosition(ArgumentMatchers.anyInt())).thenReturn(diceMove + playerPosition);
        game.rollDice();
        Assertions.assertTrue(player.getPosition() > Player.INITIAL_POSITION);
        Assertions.assertEquals(diceMove + playerPosition, player.getPosition());
    }
}
