package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class Rook extends Piece {
    private boolean activated;

    // Konsturktor -----------------------------------------------------------------------------------------------------
    public Rook(String pieceName, int pieceValue, Square currentPositionSquare, ImageView imageView, Image image) throws BoardException {
        super(pieceName, pieceValue, currentPositionSquare, imageView, image);
        setActivated(false);
    }
    public Rook(String pieceName, int pieceValue, Square currentPositionSquare, String color) throws BoardException {
        super(pieceName, pieceValue,currentPositionSquare, color);
        setActivated(false);
    }

    // Getter ----------------------------------------------------------------------------------------------------------
    public boolean isActivated() {
        return activated;
    }

    // Setter ----------------------------------------------------------------------------------------------------------
    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    // Other Methods ---------------------------------------------------------------------------------------------------
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

    // Castling Logic --------------------------------------------------------------------------------------------------
    static void relocateRookCastleWhiteKingSide() throws BoardException {
        Rook rook = (Rook) Board.getSquares().get(56).getPiece();
        if (!rook.isActivated()) {
            for (Square square : Board.getSquares()) {
                if (square.getSquareName().equals("h1")) {
                    square.setOccupied(false);
                }
                if (square.getSquareName().equals("f1")) {
                    square.setPiece(rook);
                    square.setOccupied(true);
                }
            }
        }
    }
    static void relocateRookCastleWhiteQueenSide() throws BoardException {
        Rook rook = (Rook) Board.getSquares().get(63).getPiece();
        if (!rook.isActivated()) {
            for (Square square : Board.getSquares()) {
                if (Board.getSquares().get(63).equals(square)) {
                    square.setOccupied(false);
                }
                if (Board.getSquares().get(60).equals(square)) {
                    square.setPiece(rook);
                    square.setOccupied(true);
                }
            }
        }
    }
    static void relocateRookCastleBlackKingSide() throws BoardException {
        Rook rook = (Rook) Board.getSquares().get(0).getPiece();
        if (!rook.isActivated()) {
            for (Square square : Board.getSquares()) {
                if (square.getSquareName().equals("h8")) {
                    square.setOccupied(false);
                }
                if (square.getSquareName().equals("f8")) {
                    square.setPiece(rook);
                    square.setOccupied(true);
                }
            }
        }
    }
    static void relocateRookCastleBlackQueenSide() throws BoardException {
        Rook rook = (Rook) Board.getSquares().get(7).getPiece();
        if (!rook.isActivated()) {
            for (Square square : Board.getSquares()) {
                if (Board.getSquares().get(7).equals(square)) {
                    square.setOccupied(false);
                }
                if (Board.getSquares().get(4).equals(square)) {
                    square.setPiece(rook);
                    square.setOccupied(true);
                }
            }
        }
    }
}

