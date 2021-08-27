package com.mst.games.snkldr.board.item;

public final class Snake extends BoardItem {

    public Snake(int head, int tail) {
        super(head, tail);
    }

    @Override
    protected void validateStartEnd(int head, int tail) {
        if (head <= tail) {
            throwException("head position is smaller than tail position");
        }
    }

}
