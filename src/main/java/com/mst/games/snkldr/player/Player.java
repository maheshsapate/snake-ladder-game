package com.mst.games.snkldr.player;

public class Player {

    public static final int INITIAL_POSITION = 1;

    private int position = INITIAL_POSITION;

    public int getPosition() {
        return position;
    }

    public void setPosition(int nextPosition) {
        position = nextPosition;
    }

}
