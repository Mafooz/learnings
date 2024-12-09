package org.example.WinStrategy;

import org.example.Model.Game;
import org.example.Model.Player;

public interface IWinStrategy {
    public Player getWinner(Game game, int row, int col);
}
