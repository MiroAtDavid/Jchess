package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Pawn extends Piece {

    // Konstruktor -----------------------------------------------------------------------------------------------------
    public Pawn(String pieceName, int pieceValue, Square currentPositionSquare, ImageView imageView, Image image) throws BoardException {
        super(pieceName, pieceValue, currentPositionSquare, imageView, image);
    }

    public Pawn(String pieceName, int pieceValue, Square currentPositionSquare, String color) throws BoardException {
        super(pieceName, pieceValue,currentPositionSquare, color);
    }

    // Methods ---------------------------------------------------------------------------------------------------------
    @Override
    public ArrayList<Square> possiblePos() {
        ArrayList<Square> possibleMoves = new ArrayList<>();
        if (!this.getColor().equals("black"))
            possibleMoves.addAll(possibleNorth());
        if (this.getColor().equals("black"))
            possibleMoves.addAll(possibleSouth());
        return possibleMoves;
    }
    public ArrayList<Square> possibleNorth() {
        ArrayList<Square> northList = new ArrayList<>();
        for (Square square : Board.getSquares()) {
            if (!square.isOccupied()) {
                if (square.getCol() == getCurrentPositionSquare().getCol()) {
                    if (square.getRow() == getCurrentPositionSquare().getRow() + 1) {
                        northList.add(square);
                    }
                    if (square.getRow() == getCurrentPositionSquare().getRow() + 2 && getCurrentPositionSquare().getRow() == 2) {
                        northList.add(square);
                    }
                }
            } else if (square.isOccupied() && !square.getPiece().getColor().equals(this.getColor())) {
                if (square.getRow() == getCurrentPositionSquare().getRow() + 1 && square.getCol() == getCurrentPositionSquare().getCol() + 1)
                    northList.add(square);
                if (square.getRow() == getCurrentPositionSquare().getRow() + 1 && square.getCol() == getCurrentPositionSquare().getCol() - 1)
                    northList.add(square);
            }
        }
        return northList;
    }
    public ArrayList<Square> possibleSouth(){
        ArrayList<Square> southList = new ArrayList<>();
        for (Square square : Board.getSquares()){
            if (!square.isOccupied()) {
                if (square.getCol() == getCurrentPositionSquare().getCol()) {
                    if (square.getRow() == getCurrentPositionSquare().getRow() - 1) {
                        southList.add(square);
                    }
                    if (square.getRow() == getCurrentPositionSquare().getRow() - 2 && getCurrentPositionSquare().getRow() == 7) {
                        southList.add(square);
                    }
                }
            } else if (square.isOccupied() && !square.getPiece().getColor().equals(this.getColor())) {
                if (square.getRow() == getCurrentPositionSquare().getRow() - 1 && square.getCol() == getCurrentPositionSquare().getCol() + 1)
                    southList.add(square);
                if (square.getRow() == getCurrentPositionSquare().getRow() - 1 && square.getCol() == getCurrentPositionSquare().getCol() - 1)
                    southList.add(square);
            }
        }
        return southList;
    }




}
