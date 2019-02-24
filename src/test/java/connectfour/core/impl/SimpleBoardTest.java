package connectfour.core.impl;

import connectfour.core.Board;
import connectfour.core.Disc;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SimpleBoardTest {
    @Rule
    public final ExpectedException thrown = ExpectedException.none();

    @Test
    public void display() {
        {
            (new SimpleBoard()).display();
        }
        {
            Board board = new SimpleBoard(new int[3][2], 3, 2, 3);
            board.drop(Disc.GREEN, 0);
            board.drop(Disc.GREEN, 0);
            board.drop(Disc.RED, 1);
            board.drop(Disc.RED, 1);
            board.display();
        }
    }

    @Test
    public void drop() {
        {
            Board board = new SimpleBoard(new int[3][2], 3, 2, 2);
            Assert.assertEquals(2, board.drop(Disc.GREEN, 0));
            Assert.assertEquals(1, board.drop(Disc.GREEN, 0));
            Assert.assertEquals(0, board.drop(Disc.GREEN, 0));
            Assert.assertEquals(2, board.drop(Disc.RED, 1));
            Assert.assertEquals(1, board.drop(Disc.RED, 1));
            Assert.assertEquals(0, board.drop(Disc.RED, 1));
        }
        {
            Board board = new SimpleBoard(new int[2][1], 2, 1, 2);
            thrown.expect(IllegalArgumentException.class);
            board.drop(Disc.GREEN, 1);
        }
        {
            Board board = new SimpleBoard(new int[2][1], 2, 1, 2);
            Assert.assertTrue(board.isAvailable());

            board.drop(Disc.GREEN, 0);
            board.drop(Disc.GREEN, 0);
            Assert.assertFalse(board.isAvailable());

            thrown.expect(IllegalArgumentException.class);
            board.drop(Disc.GREEN, 0);
        }
    }
}