package model;

public class Player {

    private String name;
    private final Piece piece;

    private Player(String name, Piece piece) {
        this.name = name;
        this.piece = piece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Piece getPiece() {
        return piece;
    }

    public static Player getPlayer(String name, Color color) {
        Piece piece = Piece.getPiece(color);
        if (piece==null) {
            return null;
        }
        else {
            return new Player(name, piece);
        }
    }
}
