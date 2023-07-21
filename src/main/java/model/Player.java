package model;

import java.util.ArrayList;

public class Player {
    private String name;
    private static ArrayList<Piece> pieces;
    private int strength;
    private String color;

    // Konstruktor -----------------------------------------------------------------------------------------------------

    public Player(String name, ArrayList<Piece> pieces, String color) {
        this.name = name;
        this.pieces = pieces;
        this.strength = strength;
        this.color = color;
    }

    // Getter ----------------------------------------------------------------------------------------------------------

    public String getName() {
        return name;
    }
    public int getStrength() {
        return strength;
    }
    public String getColor() {
        return color;
    }
    public static ArrayList<Piece> getPieces() {
        return pieces;
    }

    // Setter ----------------------------------------------------------------------------------------------------------
    public void setPieces(ArrayList<Piece> pieces) {
        this.pieces = pieces;
    }
    public void setName(String name) throws BoardException {
        if (name != null)
            this.name = name;
        else
            throw new BoardException("Player - setName: null");
    }
    public void setStrength(int strength) throws BoardException {
        if (strength > Integer.MIN_VALUE && strength < Integer.MAX_VALUE) {
            for (Piece p : Player.getPieces()) {
                strength += p.getPieceValue();
            }
            this.strength = strength;
        } else {
            throw new BoardException("Player - setName(): int value");
        }

    }
    public void setColor(String color) throws BoardException {
        if (color != null)
            this.color = color;
        else
            throw new BoardException("Player - setColor(): String null");
    }

    // Other -----------------------------------------------------------------------------------------------------------

}

