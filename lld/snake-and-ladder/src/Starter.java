import WinStrategy.BasicWinStrategy;
import game.LudoGame;
import model.Color;
import model.Player;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Starter {
    public static void main(String[] args) {
        Player player1 = Player.getPlayer("Mahfooz", Color.YELLOW);
        Player player2 = Player.getPlayer("Mahfooz", Color.RED);
        Queue<Player> players = new LinkedList<>();
        if (player1!=null) {
            players.add(player1);
        }
        if (player2!=null) {
            players.add(player2);
        }
        int size = 8;
        int [][] ladders = new int[5][4];
        int [][] snakes = new int[5][4];
        LudoGame ludoGame = new LudoGame(players, size, 2, ladders,  snakes,  new BasicWinStrategy());
    }
}
