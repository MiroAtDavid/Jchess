package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

public class Bishop extends Piece {

    // Constructor -----------------------------------------------------------------------------------------------------
    public Bishop(String pieceName, int pieceValue, Square currentPositionSquare, ImageView imageView, Image image) throws BoardException {
        super(pieceName, pieceValue, currentPositionSquare, imageView, image);
    }

    public Bishop(String pieceName, int pieceValue, Square currentPositionSquare, String color) throws BoardException {
        super(pieceName, pieceValue,currentPositionSquare, color);
    }

    // Methods ---------------------------------------------------------------------------------------------------------
    @Override
    public ArrayList<Square> possiblePos(){
        ArrayList<Square> possibleMoves = new ArrayList<>();
        possibleMoves.addAll(possibleNorthWest());
        possibleMoves.addAll(possibleNorthEast());
        possibleMoves.addAll(possibleSouthWest());
        possibleMoves.addAll(possibleSouthEast());
        return possibleMoves;
    }
    public ArrayList<Square> possibleNorthWest(){
        ArrayList<Square> northWestList = new ArrayList<>();
        outerloop:
        for (int i = 1; i < 8; i++) {
            for (Square square : Board.getSquares()) {
                if (square.getCol() == getCurrentPositionSquare().getCol() - i && square.getRow() == getCurrentPositionSquare().getRow() + i) {
                    if (!square.isOccupied())
                        northWestList.add(square);
                    else
                        break outerloop;
                }
            }
        }
        return northWestList;
    }
    public ArrayList<Square> possibleNorthEast(){
        ArrayList<Square> northEastList = new ArrayList<>();
        outerloop:
        for (int i = 1; i < 8; i++){
            for (Square square : Board.getSquares()) {
                if (square.getCol() == getCurrentPositionSquare().getCol() + i && square.getRow() == getCurrentPositionSquare().getRow() + i) {
                    if (!square.isOccupied())
                        northEastList.add(square);
                    else
                        break outerloop;
                }
            }
        }
        return northEastList;
    }

    public ArrayList<Square> possibleSouthWest(){
        ArrayList<Square> southWestList = new ArrayList<>();
        outerloop:
        for (int i = 1; i < 8; i++){
            for (Square square : Board.getSquares()) {
                if (square.getCol() == getCurrentPositionSquare().getCol() - i && square.getRow() == getCurrentPositionSquare().getRow() - i) {
                    if (!square.isOccupied())
                        southWestList.add(square);
                    else
                        break outerloop;
                }
            }
        }
        return southWestList;
    }
    public ArrayList<Square> possibleSouthEast(){
        ArrayList<Square> southEastList = new ArrayList<>();
        outerloop:
        for (int i = 1; i < 8; i++){
            for (Square square : Board.getSquares()) {
                if (square.getCol() == getCurrentPositionSquare().getCol() + i && square.getRow() == getCurrentPositionSquare().getRow() - i) {
                    if (!square.isOccupied())
                        southEastList.add(square);
                    else
                        break outerloop;
                }
            }
        }
        return southEastList;
    }

}
