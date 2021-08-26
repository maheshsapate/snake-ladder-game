package com.mst.games.snkldr.board;

public final class Snake extends BoardItem {

    public Snake(int startPosition, int endPosition) {
        super(startPosition, endPosition);
    }

    @Override
    protected void validateStartEnd(int startPosition, int endPosition) {
        if (startPosition <= endPosition) {
            throwException("StartPosition is smaller than EndPosition");
        }
    }

}
