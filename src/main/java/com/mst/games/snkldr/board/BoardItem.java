package com.mst.games.snkldr.board;

import java.security.InvalidParameterException;

abstract class BoardItem {

    private final int start;
    private final int end;

    BoardItem(int startPosition, int endPosition) {
        validate(startPosition, endPosition);
        this.start = startPosition;
        this.end = endPosition;
    }

    abstract void validateStartEnd(int startPosition, int endPosition);

    public int getStartPosition() {
        return start;
    }

    public int getEndPosition() {
        return end;
    }

    private void validate(int startPosition, int endPosition) {
        validateStartPosition(startPosition);
        validateEndPosition(endPosition);
        validateStartEnd(startPosition, endPosition);
    }

    private void validateStartPosition(int startPosition) {
        if (isNotValid(startPosition)) {
            String message = String.format("StartPosition %d is invalid", startPosition);
            throwException(message);
        }
    }

    private void validateEndPosition(int endPosition) {
        if (isNotValid(endPosition)) {
            String message = String.format("EndPosition %d is invalid", endPosition);
            throwException(message);
        }
    }

    private boolean isNotValid(int position) {
        return position < Board.START_POSITION || position > Board.END_POSITION;
    }

    protected void throwException(String message) {
        throw new InvalidParameterException(message);
    }

}
