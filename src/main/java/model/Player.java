package model;

import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Piece> pieces;
    private int strength;
    private String color;
    private int valueStrength;

    // Konstruktor -----------------------------------------------------------------------------------------------------

    public Player(String name, ArrayList<Piece> pieces, int strength, String color) {
        this.name = name;
        this.pieces = pieces;
        this.strength = strength;
        this.color = color;
        this.valueStrength = getValueStrength();
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
    public ArrayList<Piece> getPieces() {
        return pieces;
    }
    public int getValueStrength(){
        return valueStrength;
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
        if (strength > Integer.MIN_VALUE && strength < Integer.MAX_VALUE)
            this.strength = strength;
        else
            throw new BoardException("Player - setName(): int value");
    }
    public void setColor(String color) throws BoardException {
        if (color != null)
            this.color = color;
        else
            throw new BoardException("Player - setColor(): String null");
    }
    public void setValueStrength(int valueStrength) throws BoardException {
        if (valueStrength > Integer.MIN_VALUE && valueStrength < Integer.MAX_VALUE){
            if (color.equals("white")) {
                for (Piece p : pieces) {
                    valueStrength =+ p.getPieceValue();
                }
            } else if (color.equals("black")) {
                for (Piece p : pieces) {
                    valueStrength =- p.getPieceValue();
                }
            }
        } else
            throw new BoardException("Player - setValueStrength(): int value min-max");

    }

}
