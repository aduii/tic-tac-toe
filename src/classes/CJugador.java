package classes;

public class CJugador {
    private String name;
    private boolean turn;
    private int color;

    private char piece;

    public CJugador() {
        this.name = "\0";
        this.turn = false;
        this.color = 0;
        this.piece = '\0';
    }

    public CJugador(String name, boolean turn, int color, char piece) {
        this.name = name;
        this.turn = turn;
        this.color = color;
        this.piece = piece;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public char getPiece() {
        return piece;
    }

    public void setPiece(char piece) {
        this.piece = piece;
    }
}
