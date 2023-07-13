package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.*;

public class Board {
    private static ArrayList<Square> square;

    // Konstruktor -----------------------------------------------------------------------------------------------------
    public Board(){
        square = new ArrayList<>();
    }
    // Getter ---- -----------------------------------------------------------------------------------------------------
    public static ArrayList<Square> getSquares(){
        return square;
    }

    // Other Methods ---------------------------------------------------------------------------------------------------
    public Square addSquare(String squareName, int row, int col, Color color) throws BoardException {
        Square squareNeu = new Square(squareName, row, col, color , new Rectangle(90,90));
        square.add(squareNeu);
        return squareNeu;
    }

    // toString --------------------------------------------------------------------------------------------------------
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("\n");
        sb.append("---------------------------------\n");
        for (int row = 1; row < 9; row ++){
            for (Square s : Board.getSquares()) {
                if (s.getRow() == row) {
                    if (!s.isOccupied())
                        sb.append("| " + "  ");
                    else
                        sb.append("| ").append(s.getPiece().getPieceName()).append(" ");

                }
            }
            sb.append("|");
            sb.append("\n---------------------------------\n");
        }

        return sb.toString();
    }
    public void print(){
        System.out.println(this);
    }
}
