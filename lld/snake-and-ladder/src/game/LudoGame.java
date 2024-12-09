package game;

import model.Board;
import model.Dices;
import model.Piece;
import model.Player;
import WinStrategy.IWinStrategy;
import java.util.Queue;

public class LudoGame {
    Queue<Player> players;
    Board board;
    Dices dices;
    IWinStrategy iWinStrategy;
    public LudoGame(Queue<Player> players, int size, int totalDice, int[][] ladders, int[][] snakes, IWinStrategy iWinStrategy) {
        this.players = players;
        board = new Board(size, ladders, snakes);
        this.iWinStrategy = iWinStrategy;
        this.iWinStrategy.setBoard(board);
        this.dices = new Dices(totalDice);
    }

    public void initializeGame() {
        while(true) {
            Player player = players.peek();
            players.remove();
            int currRollValue = this.dices.getRollValue();
            Piece currPiece = player.getPiece();
            int [] newLocation = board.getNewLocation(currRollValue, currPiece);
            currPiece.setCurrRow(newLocation[0]);
            currPiece.setCurrCol(newLocation[1]);
            if (iWinStrategy.isWinner(this.board, newLocation)) {
                System.out.println("Player " + player.getName() + " with piece color " + player.getPiece().getColor().name());
                break;
            }
            players.add(player);
        }
    }
}
