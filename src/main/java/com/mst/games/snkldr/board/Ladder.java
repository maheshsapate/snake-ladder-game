package com.mst.games.snkldr.board;

public final class Ladder extends BoardItem {

    public Ladder(int startPosition, int endPosition) {
        super(startPosition, endPosition);
    }

    @Override
    protected void validateStartEnd(int startPosition, int endPosition) {
        if (startPosition >= endPosition) {
            throwException("StartPosition is greater than EndPosition");
        }
    }
}
