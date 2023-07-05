package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Knight extends Piece{

    // Konstruktor -----------------------------------------------------------------------------------------------------
    public Knight(String pieceName, int pieceValue, Square currentPositionSquare, ImageView imageView, Image image) throws BoardException {
        super(pieceName, pieceValue, currentPositionSquare, imageView, image);
    }

    public Knight(String pieceName, int pieceValue, Square currentPositionSquare) throws BoardException {
        super(pieceName, pieceValue,currentPositionSquare);
    }

    // Methods ---------------------------------------------------------------------------------------------------------
    @Override
    public ArrayList<Square> possiblePos(){
        ArrayList<Square> possibleMoves = new ArrayList<>();
        for (Square square : Board.getSquares()){
            if (!square.isOccupied()) {
                if (square.getRow() == getCurrentPositionSquare().getRow() + 2 && square.getCol() == getCurrentPositionSquare().getCol() - 1) {
                    //setPos(square);
                    possibleMoves.add(square);
                }
                if (square.getRow() == getCurrentPositionSquare().getRow() + 2 && square.getCol() == getCurrentPositionSquare().getCol() + 1) {
                    //setPos(square);
                    possibleMoves.add(square);
                }
                if (square.getRow() == getCurrentPositionSquare().getRow() - 2 && square.getCol() == getCurrentPositionSquare().getCol() + 1) {
                    //setPos(square);
                    possibleMoves.add(square);
                }
                if (square.getRow() == getCurrentPositionSquare().getRow() - 2 && square.getCol() == getCurrentPositionSquare().getCol() - 1) {
                    //setPos(square);
                    possibleMoves.add(square);
                }
                if (square.getRow() == getCurrentPositionSquare().getRow() + 1 && square.getCol() == getCurrentPositionSquare().getCol() - 2) {
                    //setPos(square);
                    possibleMoves.add(square);
                }
                if (square.getRow() == getCurrentPositionSquare().getRow() + 1 && square.getCol() == getCurrentPositionSquare().getCol() + 2) {
                    //setPos(square);
                    possibleMoves.add(square);
                }
                if (square.getRow() == getCurrentPositionSquare().getRow() - 1 && square.getCol() == getCurrentPositionSquare().getCol() + 2) {
                    //setPos(square);
                    possibleMoves.add(square);
                }
                if (square.getRow() == getCurrentPositionSquare().getRow() - 1 && square.getCol() == getCurrentPositionSquare().getCol() - 2) {
                    //setPos(square);
                    possibleMoves.add(square);
                }
            }

        }
        return possibleMoves;
    }




}
