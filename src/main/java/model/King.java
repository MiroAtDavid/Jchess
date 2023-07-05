package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class King extends Piece{

    // Konstruktor -----------------------------------------------------------------------------------------------------
    public King(String pieceName, int pieceValue, Square currentPositionSquare, ImageView imageView, Image image) throws BoardException {
        super(pieceName, pieceValue, currentPositionSquare, imageView, image);
    }

    public King(String pieceName, int pieceValue, Square currentPositionSquare) throws BoardException {
        super(pieceName, pieceValue,currentPositionSquare);
    }

    // Methods ---------------------------------------------------------------------------------------------------------
    @Override
    public ArrayList<Square> possiblePos(){
        ArrayList<Square> possibleMoves = new ArrayList<>();
        possibleMoves.clear();
        for (Square square : Board.getSquares()){
            for (int i = -1; i <= 1; i++) {
                if (!square.isOccupied()) {

                    if (square.getRow() == getCurrentPositionSquare().getRow() && square.getCol() == getCurrentPositionSquare().getCol()) {
                        continue;
                    }
                    if (square.getRow() == getCurrentPositionSquare().getRow() + i && square.getCol() == getCurrentPositionSquare().getCol() + i) {
                        //setPos(square);
                        possibleMoves.add(square);
                    }
                    if (square.getRow() == getCurrentPositionSquare().getRow() + i && square.getCol() == getCurrentPositionSquare().getCol() - i) {
                        //setPos(square);
                        possibleMoves.add(square);
                    }
                    if (square.getRow() == getCurrentPositionSquare().getRow() && square.getCol() == getCurrentPositionSquare().getCol()) {
                        continue;
                    }
                    if (square.getRow() == getCurrentPositionSquare().getRow() - i && square.getCol() == getCurrentPositionSquare().getCol() - i) {
                        //setPos(square);
                        possibleMoves.add(square);
                    }
                    if (square.getRow() == getCurrentPositionSquare().getRow() - i && square.getCol() == getCurrentPositionSquare().getCol() + i) {
                        //setPos(square);
                        possibleMoves.add(square);
                    }
                    if (square.getRow() == getCurrentPositionSquare().getRow() + i && square.getCol() == getCurrentPositionSquare().getCol()) {
                        //setPos(square);
                        possibleMoves.add(square);
                    }
                    if (square.getRow() == getCurrentPositionSquare().getRow() - i && square.getCol() == getCurrentPositionSquare().getCol()) {
                        //setPos(square);
                        possibleMoves.add(square);
                    }
                    if (square.getRow() == getCurrentPositionSquare().getRow() && square.getCol() == getCurrentPositionSquare().getCol() + i) {
                        //setPos(square);
                        possibleMoves.add(square);
                    }
                    if (square.getRow() == getCurrentPositionSquare().getRow() && square.getCol() == getCurrentPositionSquare().getCol() - 1) {
                        //setPos(square);
                        possibleMoves.add(square);
                    }
                }
            }

        }
        return possibleMoves;
    }



}
