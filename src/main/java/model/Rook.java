package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Rook extends Piece {


    public Rook(String pieceName, int pieceValue, Square currentPositionSquare, ImageView imageView, Image image) throws BoardException {
        super(pieceName, pieceValue, currentPositionSquare, imageView, image);
    }

    public Rook(String pieceName, int pieceValue, Square currentPositionSquare, String color) throws BoardException {
        super(pieceName, pieceValue,currentPositionSquare, color);
    }

    @Override
    public ArrayList<Square> possiblePos() {
        ArrayList<Square> possibleMoves = new ArrayList<>();
        possibleMoves.addAll(possibleNorth());
        possibleMoves.addAll(possibleSouth());
        possibleMoves.addAll(possibleEast());
        possibleMoves.addAll(possibleWest());
        return possibleMoves;
    }

    public ArrayList<Square> possibleNorth(){
        ArrayList<Square> norhtList = new ArrayList<>();
        outerloop:
        for (int i = 1; i < 8; i++){
            for (Square square : Board.getSquares()) {
                if (square.getCol() == getCurrentPositionSquare().getCol()) {
                    if (square.getRow() + i == getCurrentPositionSquare().getRow()) {
                        if (!square.isOccupied())
                            norhtList.add(square);
                        else
                            break outerloop;
                    }
                }
            }
        }
        return norhtList;
    }

    public ArrayList<Square> possibleSouth(){
        ArrayList<Square> southList = new ArrayList<>();
        outerloop:
        for (int i = 1; i < 8; i++){
            for (Square square : Board.getSquares()) {
                if (square.getCol() == getCurrentPositionSquare().getCol()) {
                    if (square.getRow() - i == getCurrentPositionSquare().getRow()) {
                        if (!square.isOccupied())
                            southList.add(square);
                        else
                            break outerloop;
                    }
                }
            }
        }

        return southList;
    }

    public ArrayList<Square> possibleEast(){
        ArrayList<Square> eastList = new ArrayList<>();
        outerloop:
        for (int i = 1; i < 8; i++){
            for (Square square : Board.getSquares()) {
                if (square.getRow() == getCurrentPositionSquare().getRow()) {
                    if (square.getCol() + i == getCurrentPositionSquare().getCol()) {
                        if (!square.isOccupied())
                            eastList.add(square);
                        else
                            break outerloop;
                    }
                }
            }
        }
        return eastList;
    }

    public ArrayList<Square> possibleWest(){
        ArrayList<Square> westList = new ArrayList<>();
        outerloop:
        for (int i = 1; i < 8; i++){
            for (Square square : Board.getSquares()) {
                if (square.getRow() == getCurrentPositionSquare().getRow()) {
                    if (square.getCol() - i == getCurrentPositionSquare().getCol()) {
                        if (!square.isOccupied())
                            westList.add(square);
                        else
                            break outerloop;
                    }
                }
            }
        }
        return westList;
    }

}

