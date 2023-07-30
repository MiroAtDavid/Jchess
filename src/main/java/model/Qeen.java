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
    public ArrayList<Square> possiblePos(Board board) {
        ArrayList<Square> possibleMoves = new ArrayList<>();
        possibleMoves.addAll(possibleNorth(board));
        possibleMoves.addAll(possibleSouth(board));
        possibleMoves.addAll(possibleEast(board));
        possibleMoves.addAll(possibleWest(board));
        possibleMoves.addAll(possibleNorthWest(board));
        possibleMoves.addAll(possibleNorthEast(board));
        possibleMoves.addAll(possibleSouthWest(board));
        possibleMoves.addAll(possibleSouthEast(board));
        return possibleMoves;
    }
    public ArrayList<Square> possibleNorth(Board board){
        ArrayList<Square> norhtList = new ArrayList<>();
        outerloop:
        for (int i = 1; i < 8; i++){
            for (Square square : board.getSquares()) {
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
    public ArrayList<Square> possibleSouth(Board board){
        ArrayList<Square> southList = new ArrayList<>();
        outerloop:
        for (int i = 1; i < 8; i++){
            for (Square square : board.getSquares()) {
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
    public ArrayList<Square> possibleEast(Board board){
        ArrayList<Square> eastList = new ArrayList<>();
        outerloop:
        for (int i = 1; i < 8; i++){
            for (Square square : board.getSquares()) {
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
    public ArrayList<Square> possibleWest(Board board){
        ArrayList<Square> westList = new ArrayList<>();
        outerloop:
        for (int i = 1; i < 8; i++){
            for (Square square : board.getSquares()) {
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
    public ArrayList<Square> possibleNorthWest(Board board){
        ArrayList<Square> northWestList = new ArrayList<>();
        outerloop:
        for (int i = 1; i < 8; i++) {
            for (Square square : board.getSquares()) {
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
    public ArrayList<Square> possibleNorthEast(Board board){
        ArrayList<Square> northEastList = new ArrayList<>();
        outerloop:
        for (int i = 1; i < 8; i++){
            for (Square square : board.getSquares()) {
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
    public ArrayList<Square> possibleSouthWest(Board board){
        ArrayList<Square> southWestList = new ArrayList<>();
        outerloop:
        for (int i = 1; i < 8; i++){
            for (Square square : board.getSquares()) {
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
    public ArrayList<Square> possibleSouthEast(Board board){
        ArrayList<Square> southEastList = new ArrayList<>();
        outerloop:
        for (int i = 1; i < 8; i++){
            for (Square square : board.getSquares()) {
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