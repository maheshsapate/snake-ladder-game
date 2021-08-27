package com.mst.games.snkldr.app;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.common.collect.Sets;
import com.mst.games.snkldr.board.Board;
import com.mst.games.snkldr.board.item.BoardItem;
import com.mst.games.snkldr.board.item.Ladder;
import com.mst.games.snkldr.board.item.Snake;
import com.mst.games.snkldr.dice.Dice;
import com.mst.games.snkldr.dice.RollingStrategy;
import com.mst.games.snkldr.game.SnakeLadderGame;

@SpringBootApplication
public class MainApp implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(MainApp.class);

    public static void main(String[] args) {
        LOG.info("STARTING THE SNAKE LADDER GAME");
        SpringApplication.run(MainApp.class, args);
        LOG.info("GAME FINISHED");
    }

    @Override
    public void run(String... args) {
        Set<BoardItem> boardItems = Sets.newHashSet(new Snake(14, 7), new Ladder(15, 30), new Snake(47, 29), new Ladder(57, 80));
        SnakeLadderGame game = new SnakeLadderGame(new Board(boardItems), new Dice(RollingStrategy.RANDOM_STRATEGY));
        int turns = 0;
        while (!game.isGameOver()) {
            game.rollDice();
            LOG.info("Player at position ==> {}", game.getPlayerPosition());
            turns++;
        }
        LOG.info("Game finished in {} turns", turns);
    }
}
