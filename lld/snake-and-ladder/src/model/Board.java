package model;

public class Board {
    private final int size;
    private Box[][] board;

    public int getSize() {
        return size;
    }
    public Board(int size, int[][] ladder, int[][] snake) {
        this.size = size;
        board = new Box[size][size];
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                board[i][j]=new Box();
            }
        }
        for(int[] x: ladder) {
            int row = x[0];
            int col = x[1];
            int destRow = x[2];
            int destCol = x[3];
            board[row][col].setJump(destRow, destCol);
        }
        for(int[] x: snake) {
            int row = x[0];
            int col = x[1];
            int destRow = x[2];
            int destCol = x[3];
            board[row][col].setJump(destRow, destCol);
        }
    }
    private int[] jumpToNextLocation(int[] location) {
        Box currBox = board[location[0]][location[1]];
        if (currBox.getJmpRow()==-1) {
            return location;
        }
        else {
            int[] newLocation = new int[2];
            newLocation[0] = currBox.getJmpRow();
            newLocation[1] = currBox.getJmpCol();
            return newLocation;
        }
    }
    public int[] getNewLocation(int value, Piece piece) {
        int row = piece.getCurrRow();
        int col = piece.getCurrCol();
        int total = value + row*size + col;
        int[] newLocation = new int[2];
        newLocation[0] = total/size;
        newLocation[1] = total%size;
        return jumpToNextLocation(newLocation);
    }
}
