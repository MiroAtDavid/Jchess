package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;

public class Square {

    private String squareName;
    private int row;
    private int col;
    private Color color;
    private Rectangle rectangle;
    private Piece piece;
    private boolean occupied;

    // Konstruktor -----------------------------------------------------------------------------------------------------

    public Square(String squareName, int row, int col, Color color, Rectangle rectangle ) throws BoardException {
        setSquareName(squareName);
        setRow(row);
        setCol(col);
        setColor(color);
        setRectangle(rectangle);

    }

    // Getter ----------------------------------------------------------------------------------------------------------
    public String getSquareName(){
        return squareName;
    }
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    public Color getColor() {
        return color;
    }
    public Rectangle getRectangle() {
        return rectangle;
    }
    public Piece getPiece() {
        return piece;
    }
    public boolean isOccupied() {
        return this.occupied;
    }


    // Setter ----------------------------------------------------------------------------------------------------------
    public void setSquareName(String squareName) throws BoardException {
        if (squareName != null)
            this.squareName = squareName;
        else
            throw new BoardException("Square - setSquareName(): name null");
    }
    public void setRow(int row) throws BoardException {
        if (row > 0 && row < 9)
            this.row = row;
        else
            throw new BoardException("Square - setrow(): row 0-8");
    }
    public void setCol(int col) throws BoardException {
        if (col > 0 && col < 9)
            this.col = col;
        else
            throw new BoardException("Square - setcol(): col 0-8");
    }
    public void setColor(Color color) throws BoardException {
        if (color != null)
            this.color = color;
        else
            throw new BoardException("Piece - setColor(): null");
    }
    public void setRectangle(Rectangle rectangle) {
            this.rectangle = rectangle;
    }
    public void setPiece(Piece piece) throws BoardException {
            if (piece != null)
                this.piece = piece;
            else
                throw new BoardException("Square - setPiece(): null");
    }
    public void setOccupied(boolean occupied) {
            this.occupied = occupied;
    }

    // Other -----------------------------------------------------------------------------------------------------------

    // toString---------------------------------------------------------------------------------------------------------
    public String toString(boolean showWeight) {
        return "";
    }
    public void print(){
        System.out.println(toString(true));
    }


}
