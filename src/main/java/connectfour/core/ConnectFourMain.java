package connectfour.core;

import connectfour.core.Disc;
import connectfour.core.Game;
import connectfour.core.Player;
import connectfour.core.impl.DefaultPlayer;

import java.util.Scanner;

class ConnectFourMain {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // 2 players read choices from console.
            Player player1 = new DefaultPlayer("Player 1", Disc.RED, scanner);
            Player player2 = new DefaultPlayer("Player 2", Disc.GREEN, scanner);
            (new Game(player1, player2)).play();
        }
    }
}
