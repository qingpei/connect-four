package connectfour.core;

import org.junit.Test;
import connectfour.core.impl.DefaultPlayer;
import connectfour.core.impl.SimpleBoard;
import connectfour.core.impl.SimpleReferee;

import java.util.Arrays;
import java.util.Iterator;


public class GameTest {

    @Test
    public void sampleRun() {
        {
            // Replicates sample run.
            // Player 1 Red chooses "4", "5", "3", "6" .
            // Player 2 Green chooses  "4", "5", "2" .
            Player player1 = new PredefinedPlayer("Player 1", Disc.RED, Arrays.asList("4", "5", "3", "6").iterator());
            Player player2 = new PredefinedPlayer("Player 2", Disc.GREEN, Arrays.asList("4", "5", "2").iterator());
            (new Game(player1, player2)).play();
        }

    }

    @Test
    public void drawGame() {
        Board board = new SimpleBoard(new int[3][2], 3, 2, 3);
        Player player1 = new PredefinedPlayer("Player 1", Disc.RED, Arrays.asList("0", "9", "d", "1", "1", "1", "2").iterator());
        Player player2 = new PredefinedPlayer("Player 2", Disc.GREEN, Arrays.asList("1", "1", "2", "2").iterator());
        (new Game(board, new SimpleReferee(), Arrays.asList(player1, player2))).play();
    }

    private static class PredefinedPlayer extends DefaultPlayer {

        PredefinedPlayer(String name, Disc disc, Iterator<String> choices) {
            super(name, disc, choices);
        }

        @Override
        protected String nextChoice() {
            String choice = super.nextChoice();
            System.out.println(choice);
            return choice;
        }
    }

}
