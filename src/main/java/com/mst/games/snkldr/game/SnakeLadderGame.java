package com.mst.games.snkldr.game;

import com.mst.games.snkldr.board.Board;
import com.mst.games.snkldr.dice.Dice;
import com.mst.games.snkldr.player.Player;

public class SnakeLadderGame {

    private final Board board;
    private final Dice dice;
    private final Player player;

    public SnakeLadderGame(Board board, Dice dice) {
        this.board = board;
        this.dice = dice;
        this.player = new Player();
    }

    public int getPlayerPosition() {
        return player.getPosition();
    }

    public void rollDice() {
        int move = dice.roll();
        updatePlayerPosition(move);
    }

    private void updatePlayerPosition(int move) {
        int probablePosition = player.getPosition() + move;
        if (isNotValidPosition(probablePosition)) {
            return;
        }
        int nextPosition = board.getNextPosition(probablePosition);
        player.setPosition(nextPosition);
    }

    private boolean isNotValidPosition(int nextPosition) {
        return nextPosition > Board.END_POSITION;
    }

}
