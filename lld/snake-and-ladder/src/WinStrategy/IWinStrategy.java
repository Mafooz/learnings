package WinStrategy;

import model.Board;

public interface IWinStrategy {
    boolean isWinner(Board board, int[] newLocation);
    void setBoard(Board board);
}
