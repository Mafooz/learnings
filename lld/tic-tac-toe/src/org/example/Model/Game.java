package org.example.Model;

import org.example.WinStrategy.IWinStrategy;

import java.util.List;
import java.util.Scanner;

public class Game {
    private Grid grid;
    private List<Player> playerList;
    private IWinStrategy winStrategy;

    public Game(int size, List<Player> playerList, IWinStrategy winStrategy) {
        this.grid = new Grid(size);
        this.playerList = playerList;
        this.winStrategy = winStrategy;
    }

    private boolean isComplete() {
        return this.getGrid().allFilled();
    }
    public List<Player> getPlayerList() {
        return playerList;
    }

    private Player getWinner(int row, int col) {
        return winStrategy.getWinner(this, row, col);
    }
    public Grid getGrid() {
        return this.grid;
    }

    public Player start() {
        int turn=0;
        Player winner=null;
        int totPlayer = playerList.size();
        int size = this.getGrid().getSize();
        while(!this.isComplete()) {
            System.out.println("Current board settings");
            this.getGrid().print();
            Player currPlayer = playerList.get(turn);
            System.out.println("Player " + playerList.get(turn).getName() + " turn, enter your position");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.valueOf(values[0]);
            int inputColumn = Integer.valueOf(values[1]);
            if (inputRow<size && inputColumn<size && this.getGrid().getGrid().get(inputRow).get(inputColumn).getToken()==null) {
                this.getGrid().getGrid().get(inputRow).get(inputColumn).setToken(currPlayer.getToken());
                winner = this.getWinner(inputRow, inputColumn);
                if (winner!=null) {
                    break;
                }
                turn = (turn+1)%totPlayer;
            }
            else {
                System.out.println("Already filled up. Please try again!!");
            }
        }
        return winner;
    }
}
