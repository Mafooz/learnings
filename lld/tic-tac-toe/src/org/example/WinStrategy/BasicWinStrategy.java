package org.example.WinStrategy;

import org.example.Model.Box;
import org.example.Model.Game;
import org.example.Model.Player;
import org.example.Model.Token;

import java.util.ArrayList;
import java.util.List;

public class BasicWinStrategy implements IWinStrategy {
    @Override
    public Player getWinner(Game game, int row, int col) {
        ArrayList<ArrayList<Box>> grid = game.getGrid().getGrid();
        List<Player> playerList = game.getPlayerList();
        Player winner=null;
        if (calc(row, col, grid)) {
            winner =  getPlayer(grid.get(row).get(col).getToken(), playerList);
        }
        return winner;
    }

    private boolean calc(int i, int j, ArrayList<ArrayList<Box>> grid) {
        int size = grid.size();
        Token currToken = grid.get(i).get(j).getToken();
        if (currToken==null) {
            return false;
        }
        if (i>=2 && grid.get(i-1).get(j).getToken()==currToken && grid.get(i-2).get(j).getToken()==currToken) {
            return true;
        }
        if (j>=2 && i>=2 && grid.get(i-1).get(j-1).getToken()==currToken && grid.get(i-2).get(j-2).getToken()==currToken) {
            return true;
        }
        if (j>=2 && grid.get(i).get(j-1).getToken()==currToken && grid.get(i).get(j-2).getToken()==currToken) {
            return true;
        }
        if (i>=2 && j<size-2 && grid.get(i-1).get(j+1).getToken()==currToken && grid.get(i-2).get(j+2).getToken()==currToken) {
            return true;
        }
        if (j<size-2 && grid.get(i).get(j+1).getToken()==currToken && grid.get(i).get(j+2).getToken()==currToken) {
            return true;
        }
        if (i<size-2 && j<size-2 && grid.get(i+1).get(j+1).getToken()==currToken && grid.get(i+2).get(j+2).getToken()==currToken) {
            return true;
        }
        if (i<size-2 && grid.get(i+1).get(j).getToken()==currToken && grid.get(i+2).get(j).getToken()==currToken) {
            return true;
        }
        if (j>=2 && i<size-2 && grid.get(i+1).get(j-1).getToken()==currToken && grid.get(i+2).get(j-2).getToken()==currToken) {
            return true;
        }
        return false;
    }

    private Player getPlayer(Token token, List<Player> playerList) {
        Player playerWithToken = null;
        for (Player player: playerList) {
            if (player.getToken() == token) {
                playerWithToken = player;
            }
        }
        return playerWithToken;
    }
}
