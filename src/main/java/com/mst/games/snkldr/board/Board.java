package com.mst.games.snkldr.board;

import java.util.Map;
import java.util.Set;

import com.google.common.collect.Maps;
import com.mst.games.snkldr.board.item.BoardItem;

public class Board {

    public static final int START_POSITION = 1;
    public static final int END_POSITION = 100;

    private final Map<Integer, BoardItem> snakesLadders = Maps.newHashMap();

    public Board(Set<BoardItem> boardItems) {
        boardItems.stream()
            .forEach(bf -> snakesLadders.put(bf.getStartPosition(), bf));
    }

    public int getNextPosition(int fromPosition) {
        if (snakesLadders.containsKey(fromPosition)) {
            return snakesLadders.get(fromPosition).getEndPosition();
        }
        return fromPosition;
    }

}
