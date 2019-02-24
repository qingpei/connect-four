package connectfour.core.impl;

import connectfour.core.Board;
import org.junit.Assert;
import org.junit.Test;

public class SimpleRefereeTest {

    @Test
    public void isHorizontal() {
        int[][] matrix = new int[Board.ROWS][Board.COLUMNS];
        Board board = new SimpleBoard(matrix, Board.ROWS, Board.COLUMNS, Board.WIN_CONDITION);
        matrix[0][1] = 1;
        matrix[0][2] = 1;
        matrix[0][3] = 1;
        matrix[0][4] = 1;
        int matchPoints = 0;
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                if (SimpleReferee.isHorizontal(board, i, j, 1)) {
                    matchPoints++;
                }
            }
        }
        Assert.assertEquals(4, matchPoints);
    }

    @Test
    public void isVertical() {
        int[][] matrix = new int[Board.ROWS][Board.COLUMNS];
        Board board = new SimpleBoard(matrix, Board.ROWS, Board.COLUMNS, Board.WIN_CONDITION);
        matrix[1][0] = 1;
        matrix[2][0] = 1;
        matrix[3][0] = 1;
        matrix[4][0] = 1;
        int matchPoints = 0;
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                if (SimpleReferee.isVertical(board, i, j, 1)) {
                    matchPoints++;
                }
            }
        }
        Assert.assertEquals(4, matchPoints);
    }

    @Test
    public void isDiagonal() {
        int[][] matrix = new int[Board.ROWS][Board.COLUMNS];
        Board board = new SimpleBoard(matrix, Board.ROWS, Board.COLUMNS, Board.WIN_CONDITION);
        matrix[0][6] = 1;
        matrix[1][5] = 1;
        matrix[2][4] = 1;
        matrix[3][3] = 1;
        matrix[1][2] = 1;
        matrix[2][3] = 1;
        matrix[3][4] = 1;
        matrix[4][5] = 1;
        int matchPoints = 0;
        for (int i = 0; i < Board.ROWS; i++) {
            for (int j = 0; j < Board.COLUMNS; j++) {
                if (SimpleReferee.isDiagonal(board, i, j, 1)) {
                    matchPoints++;
                }
            }
        }
        Assert.assertEquals(8, matchPoints);
    }
}