package connectfour.core.impl;

import connectfour.core.Board;
import connectfour.core.Disc;
import connectfour.core.Player;
import connectfour.core.Referee;

import java.util.Iterator;

public class DefaultPlayer implements Player {

    private final Disc disc;
    private final String description;
    private final Iterator<String> choices;

    public DefaultPlayer(String name, Disc disc, Iterator<String> choices) {
        this.disc = disc;
        this.description = String.format("%s [%s]", name, disc);
        this.choices = choices;
    }

    protected String nextChoice() {
        return choices.next().trim();
    }

    @Override
    public boolean choose(Board board, Referee referee) {
        // Try until a successful move
        for (; ; ) {
            System.out.print(String.format("%s - %s: ", this.description, board.showTips()));
            String choice = nextChoice();
            try {
                int column;
                try {
                    column = Integer.parseInt(choice) - 1;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("invalid number");
                }
                int row = board.drop(this.disc, column);
                // Referee checks if current player wins the game
                return referee.judge(board, row, column);
            } catch (IllegalArgumentException e) {
                System.out.println(String.format("%s - %s!", this.description, e.getMessage()));
            }
        }
    }

    @Override
    public String getDescription() {
        return this.description;
    }
}
