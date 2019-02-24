package connectfour.core;

/**
 * Represents a connect four game player.
 */
public interface Player {

    /**
     * Chooses next move, return true if player wins else game is still on.
     */
    boolean choose(Board board, Referee referee);

    String getDescription();

}
