package com.mst.games.snkldr.board.item;

public final class Ladder extends BoardItem {

    public Ladder(int bottom, int top) {
        super(bottom, top);
    }

    @Override
    protected void validateStartEnd(int bottom, int top) {
        if (bottom >= top) {
            throwException("bottom position is greater than top position");
        }
    }
}
