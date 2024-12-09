package org.example;

import org.example.Model.Game;
import org.example.Model.Player;
import org.example.Model.Token;
import org.example.WinStrategy.BasicWinStrategy;

import java.util.ArrayList;
import java.util.List;

public class Starter {

    public static void main(String[] args) {
        Player p1 = new Player("Mahfooz", 21, Token.X);
        Player p2 = new Player("Zainab", 32, Token.O);
        List<Player> playerList = new ArrayList<>();
        playerList.add(p1);
        playerList.add(p2);
        Game game = new Game(3, playerList, new BasicWinStrategy());
        Player winner = game.start();
        System.out.println(winner!=null?winner.getName()+" Won!!!":"Draw");
    }
}
