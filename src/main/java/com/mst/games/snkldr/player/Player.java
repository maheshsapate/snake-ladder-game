package com.mst.games.snkldr.player;

import com.mst.games.snkldr.board.Board;

public class Player {

    private int position = Board.START_POSITION;

    public int getPosition() {
        return position;
    }

    public void setPosition(int nextPosition) {
        position = nextPosition;
    }

}
