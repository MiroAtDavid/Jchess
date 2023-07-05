package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Rook extends Piece {


    public Rook(String pieceName, int pieceValue, Square currentPositionSquare, ImageView imageView, Image image) throws BoardException {
        super(pieceName, pieceValue, currentPositionSquare, imageView, image);
    }

    public Rook(String pieceName, int pieceValue, Square currentPositionSquare) throws BoardException {
        super(pieceName, pieceValue, currentPositionSquare);
    }

    @Override
    public ArrayList<Square> possiblePos() {
        ArrayList<Square> possibleMoves = new ArrayList<>();
        possibleMoves.clear();
        possibleMoves.addAll(possibleNorth());
        possibleMoves.addAll(possibleSouth());
        possibleMoves.addAll(possibleEast());
        possibleMoves.addAll(possibleWest());
        return possibleMoves;
    }

    public ArrayList<Square> possibleNorth(){
        ArrayList<Square> norhtList = new ArrayList<>();
        int counter = 1;
        for (Square square : Board.getSquares()){
            if (square.getCol() == getCurrentPositionSquare().getCol()) {
                if (square.getRow() + counter == getCurrentPositionSquare().getRow()) {
                    if (!square.isOccupied())
                        norhtList.add(square);
                    else
                        break;
                }
            }
            counter++;
        }
        return norhtList;
    }

    public ArrayList<Square> possibleSouth(){
        ArrayList<Square> southList = new ArrayList<>();
        int counter = 1;
        for (Square square : Board.getSquares()){
            if (square.getCol() == getCurrentPositionSquare().getCol()) {
                if (square.getRow() - counter == getCurrentPositionSquare().getRow()) {
                    if (!square.isOccupied())
                        southList.add(square);
                    else
                        break;
                }
            }
            counter++;
        }

        return southList;
    }

    public ArrayList<Square> possibleEast(){
        ArrayList<Square> eastList = new ArrayList<>();
        int counter = 1;
        for (Square square : Board.getSquares()){
            if (square.getRow() == getCurrentPositionSquare().getRow()) {
                if (square.getCol() + counter == getCurrentPositionSquare().getCol()) {
                    if (!square.isOccupied())
                        eastList.add(square);
                    else
                        break;
                }
            }
            counter++;
        }
        return eastList;
    }

    public ArrayList<Square> possibleWest(){
        ArrayList<Square> westList = new ArrayList<>();
        int counter = 1;
        for (Square square : Board.getSquares()){
            if (square.getRow() == getCurrentPositionSquare().getRow()) {
                if (square.getCol() - counter == getCurrentPositionSquare().getCol()) {
                    if (!square.isOccupied())
                        westList.add(square);
                    else
                        break;
                }
            }
            counter++;
        }
        return westList;
    }

}

