package connectfour.core;

/**
 * Board for connect four game.
 */
public interface Board {
    int ROWS = 6;
    int COLUMNS = 7;
    int WIN_CONDITION = 4;

    /**
     * Drops a disc to the board on given column.
     *
     * @return fallen row of this disc.
     * @throws IllegalArgumentException if selected column is out of range or full.
     */
    int drop(Disc disc, int column);

    /**
     * Checks if available for new disc.
     */
    boolean isAvailable();

    void display();

    String showTips();

    int getColumns();

    int getRows();

    int getWinCondition();

    int getValue(int row, int column);

}