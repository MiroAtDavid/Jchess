package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Qeen extends Piece{

    public Qeen(String pieceName, int pieceValue, Square currentPositionSquare, ImageView imageView, Image image) throws BoardException {
        super(pieceName, pieceValue, currentPositionSquare, imageView, image);
    }
    public Qeen(String pieceName, int pieceValue, Square currentPositionSquare, String color) throws BoardException {
        super(pieceName, pieceValue,currentPositionSquare, color);
    }

    @Override
    public ArrayList<Square> possiblePos() {
        ArrayList<Square> possibleMoves = new ArrayList<>();
        possibleMoves.addAll(possibleNorth());
        possibleMoves.addAll(possibleSouth());
        possibleMoves.addAll(possibleEast());
        possibleMoves.addAll(possibleWest());
        possibleMoves.addAll(possibleNorthWest());
        possibleMoves.addAll(possibleNorthEast());
        possibleMoves.addAll(possibleSouthWest());
        possibleMoves.addAll(possibleSouthEast());
        return possibleMoves;
    }
    public ArrayList<Square> possibleNorth(){
        ArrayList<Square> norhtList = new ArrayList<>();
        outerloop:
        for (int i = 1; i < 8; i++){
            for (Square square : Board.getSquares()) {
                if (square.getCol() == getCurrentPositionSquare().getCol()) {
                    if (square.getRow() + i == getCurrentPositionSquare().getRow()) {
                        if (!square.isOccupied()){
                            norhtList.add(square);
                        } else if(square.isOccupied() && !square.getPiece().getColor().equals(this.getColor())){
                            norhtList.add(square);
                            break outerloop;
                        } else if (square.isOccupied() && square.getPiece().getColor().equals(this.getColor())){
                            break outerloop;
                        }
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
                        if (!square.isOccupied()){
                            southList.add(square);
                        } else if(square.isOccupied() && !square.getPiece().getColor().equals(this.getColor())){
                            southList.add(square);
                            break outerloop;
                        } else if (square.isOccupied() && square.getPiece().getColor().equals(this.getColor())){
                            break outerloop;
                        }
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
                        if (!square.isOccupied()){
                            eastList.add(square);
                        } else if(square.isOccupied() && !square.getPiece().getColor().equals(this.getColor())){
                            eastList.add(square);
                            break outerloop;
                        } else if (square.isOccupied() && square.getPiece().getColor().equals(this.getColor())){
                            break outerloop;
                        }
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
                        if (!square.isOccupied()){
                            westList.add(square);
                        } else if(square.isOccupied() && !square.getPiece().getColor().equals(this.getColor())){
                            westList.add(square);
                            break outerloop;
                        } else if (square.isOccupied() && square.getPiece().getColor().equals(this.getColor())){
                            break outerloop;
                        }
                    }
                }
            }
        }
        return westList;
    }
    public ArrayList<Square> possibleNorthWest(){
        ArrayList<Square> northWestList = new ArrayList<>();
        outerloop:
        for (int i = 1; i < 8; i++) {
            for (Square square : Board.getSquares()) {
                if (square.getCol() == getCurrentPositionSquare().getCol() - i && square.getRow() == getCurrentPositionSquare().getRow() + i) {
                    if (!square.isOccupied()){
                        northWestList.add(square);
                    } else if(square.isOccupied() && !square.getPiece().getColor().equals(this.getColor())){
                        northWestList.add(square);
                        break outerloop;
                    } else if (square.isOccupied() && square.getPiece().getColor().equals(this.getColor())){
                        break outerloop;
                    }
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
                    if (!square.isOccupied()){
                        northEastList.add(square);
                    } else if(square.isOccupied() && !square.getPiece().getColor().equals(this.getColor())){
                        northEastList.add(square);
                        break outerloop;
                    } else if (square.isOccupied() && square.getPiece().getColor().equals(this.getColor())){
                        break outerloop;
                    }
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
                    if (!square.isOccupied()){
                        southWestList.add(square);
                    } else if(square.isOccupied() && !square.getPiece().getColor().equals(this.getColor())){
                        southWestList.add(square);
                        break outerloop;
                    } else if (square.isOccupied() && square.getPiece().getColor().equals(this.getColor())){
                        break outerloop;
                    }
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
                    if (!square.isOccupied()){
                        southEastList.add(square);
                    } else if(square.isOccupied() && !square.getPiece().getColor().equals(this.getColor())){
                        southEastList.add(square);
                        break outerloop;
                    } else if (square.isOccupied() && square.getPiece().getColor().equals(this.getColor())){
                        break outerloop;
                    }
                }
            }
        }
        return southEastList;
    }

}
