package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class King extends Piece{

    // Konstruktor -----------------------------------------------------------------------------------------------------
    public King(String pieceName, int pieceValue, Square currentPositionSquare, ImageView imageView, Image image) throws BoardException {
        super(pieceName, pieceValue, currentPositionSquare, imageView, image);
    }

    public King(String pieceName, int pieceValue, Square currentPositionSquare, String color) throws BoardException {
        super(pieceName, pieceValue,currentPositionSquare, color);
    }

    // Methods ---------------------------------------------------------------------------------------------------------
    @Override
    public ArrayList<Square> possiblePos(){
        ArrayList<Square> possibleMoves = new ArrayList<>();
        for (Square square : Board.getSquares()){
            for (int i = 1; i <= 1; i++) {
                if (!square.isOccupied()) {
                    if (square.getRow() == getCurrentPositionSquare().getRow() && square.getCol() == getCurrentPositionSquare().getCol())
                        continue;
                    if (square.getRow() == getCurrentPositionSquare().getRow() + i && square.getCol() == getCurrentPositionSquare().getCol() + i)
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() + i && square.getCol() == getCurrentPositionSquare().getCol() - i)
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() - i && square.getCol() == getCurrentPositionSquare().getCol() - i)
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() - i && square.getCol() == getCurrentPositionSquare().getCol() + i)
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() + i && square.getCol() == getCurrentPositionSquare().getCol())
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() - i && square.getCol() == getCurrentPositionSquare().getCol())
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() && square.getCol() == getCurrentPositionSquare().getCol() + i)
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() && square.getCol() == getCurrentPositionSquare().getCol() - i)
                        possibleMoves.add(square);
                } else if (square.isOccupied() && !square.getPiece().getColor().equals(this.getColor())) {
                    if (square.getRow() == getCurrentPositionSquare().getRow() + i && square.getCol() == getCurrentPositionSquare().getCol() + i)
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() + i && square.getCol() == getCurrentPositionSquare().getCol() - i)
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() - i && square.getCol() == getCurrentPositionSquare().getCol() - i)
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() - i && square.getCol() == getCurrentPositionSquare().getCol() + i)
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() + i && square.getCol() == getCurrentPositionSquare().getCol())
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() - i && square.getCol() == getCurrentPositionSquare().getCol())
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() && square.getCol() == getCurrentPositionSquare().getCol() + i)
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() && square.getCol() == getCurrentPositionSquare().getCol() - i)
                        possibleMoves.add(square);
                }
            }
        }
        return possibleMoves;
    }
}
