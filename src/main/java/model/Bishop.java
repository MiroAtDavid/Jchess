package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

public class Bishop extends Piece {

    // Constructor -----------------------------------------------------------------------------------------------------
    public Bishop(String pieceName, int pieceValue, Square currentPositionSquare, ImageView imageView, Image image) throws BoardException {
        super(pieceName, pieceValue, currentPositionSquare, imageView, image);
    }

    public Bishop(String pieceName, int pieceValue, Square currentPositionSquare) throws BoardException {
        super(pieceName, pieceValue,currentPositionSquare);
    }

    // Methods ---------------------------------------------------------------------------------------------------------
    @Override
    public ArrayList<Square> possiblePos(){
        ArrayList<Square> possibleMoves = new ArrayList<>();
        possibleMoves.clear();
        possibleMoves.addAll(possibleNorthWest());
        possibleMoves.addAll(possibleNorthEast());
        possibleMoves.addAll(possibleSouthWest());
        possibleMoves.addAll(possibleSouthEast());
        return possibleMoves;
    }
    public ArrayList<Square> possibleNorthWest(){
        ArrayList<Square> northWestList = new ArrayList<>();
        int counter = 1;
        for (Square square : Board.getSquares()){
            if (square.getCol() - counter == getCurrentPositionSquare().getCol() && square.getRow() + counter == getCurrentPositionSquare().getRow()) {
                if (!square.isOccupied())
                    northWestList.add(square);
                else
                    break;
                }
            counter++;
        }
        return northWestList;
    }
    public ArrayList<Square> possibleNorthEast(){
        ArrayList<Square> northEastList = new ArrayList<>();
        int counter = 1;
        for (Square square : Board.getSquares()){
            if (square.getCol() + counter == getCurrentPositionSquare().getCol() && square.getRow() + counter == getCurrentPositionSquare().getRow()) {
                if (!square.isOccupied())
                    northEastList.add(square);
                else
                    break;
            }
            counter++;
        }
        return northEastList;
    }

    public ArrayList<Square> possibleSouthWest(){
        ArrayList<Square> southWestList = new ArrayList<>();
        int counter = 1;
        for (Square square : Board.getSquares()){
            if (square.getCol() - counter == getCurrentPositionSquare().getCol() && square.getRow() - counter == getCurrentPositionSquare().getRow()) {
                if (!square.isOccupied())
                    southWestList.add(square);
                else
                    break;
            }
            counter++;
        }
        return southWestList;
    }
    public ArrayList<Square> possibleSouthEast(){
        ArrayList<Square> southEastList = new ArrayList<>();
        int counter = 1;
        for (Square square : Board.getSquares()){
            if (square.getCol() + counter == getCurrentPositionSquare().getCol() && square.getRow() - counter == getCurrentPositionSquare().getRow()) {
                if (!square.isOccupied())
                    southEastList.add(square);
                else
                    break;
            }
            counter++;
        }
        return southEastList;
    }

}