package model;

import java.util.ArrayList;
import java.util.List;

public class Piece {
    private Color color;
    private int currRow;
    private int currCol;

    private static final List<Piece> pieceList = new ArrayList<>();

    private Piece(Color color) {
        this.currRow = 0;
        this.currCol = 0;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getCurrRow() {
        return currRow;
    }

    public int getCurrCol() {
        return currCol;
    }

    public void setCurrRow(int currRow) {
        this.currRow = currRow;
    }

    public void setCurrCol(int currCol) {
        this.currCol = currCol;
    }

    public static Piece getPiece(Color color) {
        for (Piece piece: pieceList) {
            if (piece.color == color) {
                return null;
            }
        }
        Piece piece = new Piece(color);
        pieceList.add(piece);
        return piece;
    }
}
