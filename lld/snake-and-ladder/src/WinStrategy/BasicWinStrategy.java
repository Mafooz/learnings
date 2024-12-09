package WinStrategy;

import model.Board;

public class BasicWinStrategy implements IWinStrategy{
    Board board;

    public BasicWinStrategy() {
        board = null;
    }
    public BasicWinStrategy(Board board) {
        this.board = board;
    }
    public boolean isWinner(Board board, int[] newLocation){
        int size = this.board.getSize();
        if (size*size<=newLocation[0]*size+newLocation[1]) {
            return true;
        }
        return false;
    }
    public void setBoard(Board board) {
        this.board = board;
    }
}
