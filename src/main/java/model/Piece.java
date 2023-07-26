package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Random;


public abstract class Piece {
    private String pieceName;
    private int pieceValue;
    private Square currentPositionSquare;
    private String color;
    private Image image;
    private ImageView imageView;

    // Knostruktor -----------------------------------------------------------------------------------------------------
    public Piece(String pieceName, int pieceValue, Square currentPositionSquare, ImageView imageView, Image image) throws BoardException {
        setPieceName(pieceName);
        setPieceValue(pieceValue);
        setCurrentPositionSquare(currentPositionSquare);
        setImage(image);
        setImageView(imageView);
    }

    public Piece(String pieceName, int pieceValue, Square currentPositionSquare, String color) throws BoardException {
        setPieceName(pieceName);
        setPieceValue(pieceValue);
        setCurrentPositionSquare(currentPositionSquare);
        setColor(color);
    }

    // Getter ----------------------------------------------------------------------------------------------------------

    public String getColor() {
        return color;
    }
    public String getPieceName() {
        return pieceName;
    }
    public int getPieceValue() {
        return pieceValue;
    }
    public Square getCurrentPositionSquare() {
        return currentPositionSquare;
    }
    public Image getImage(){
        return image;
    }
    public ImageView getImageView(){
        return imageView;
    }

    // Setter ----------------------------------------------------------------------------------------------------------

    public void setColor(String color) {
        this.color = color;
    }
    public void setPieceName(String pieceName) throws BoardException {
        if (pieceName != null)
            this.pieceName = pieceName;
        else
            throw new BoardException("Piece - setName: null");
    }
    public void setPieceValue(int pieceValue) throws BoardException {
        if (pieceValue > Integer.MIN_VALUE & pieceValue < Integer.MAX_VALUE)
            this.pieceValue = pieceValue;
        else
            throw new BoardException("Piece - setValue(): int range");
    }
    public void setCurrentPositionSquare(Square currentPositionSquare) throws BoardException {
        if (currentPositionSquare != null) {
            currentPositionSquare.setPiece(this);
            currentPositionSquare.setOccupied(true);
            this.currentPositionSquare = currentPositionSquare;
        } else
            throw new BoardException("Piece - setPos(): position square null");
    }
    public void setImage(Image image) throws BoardException {
        if (image != null)
            this.image = image;
        else
            throw new BoardException("Piece setImage()");
    }
    public void setImageView(ImageView imageView) throws BoardException {
        if (imageView != null)
            this.imageView = imageView;
        else
            throw new BoardException("Piece - setImageView(): imageView null");
    }


    // Others ----------------------------------------------------------------------------------------------------------
    public abstract  ArrayList<Square> possiblePos() throws BoardException;
    public Square move() throws BoardException {
        getCurrentPositionSquare().setOccupied(false);
        Random random = new Random();
        int randomWithinPossibleMove;
        if (possiblePos().size() > 0)
            randomWithinPossibleMove = random.nextInt(0, possiblePos().size());
        else {
            System.out.println("No position possible for piece");
            return null;
        }

        Square newPositionSquare = possiblePos().get(randomWithinPossibleMove);


        if (newPositionSquare.isOccupied()){
            captureLogic(newPositionSquare);
        }
        newPositionSquare.setPiece(this);

        setCurrentPositionSquare(newPositionSquare);
        return newPositionSquare;
    }
    private void captureLogic(Square newPositionSquare) throws BoardException {
        Player.getPieces().remove(newPositionSquare.getPiece());
        newPositionSquare.removePiece(newPositionSquare.getPiece());

    }
    public Square userMove(String userCurrentPosition, String userTargetPosition) throws BoardException {
        for (Square s : Board.getSquares()){
            if (s.getSquareName().equals(userCurrentPosition)){
                Piece p = s.getPiece();
                s.setOccupied(false);
                s.removePiece(p);
                if (p.possiblePos().size() > 0) {
                    p.possiblePos().removeIf(sq -> !sq.getSquareName().equals(userTargetPosition));
                    for (Square newPositionSquare : possiblePos()) {
                        if (newPositionSquare.getSquareName().equals(userTargetPosition)) {
                            if (newPositionSquare.isOccupied()) {
                                captureLogic(newPositionSquare);
                            }
                            if (p instanceof Pawn pawn) {
                                if (pawn.isEnPassant()){
                                    if (pawn.getEnPassantSquare().equals(newPositionSquare)){
                                        pawn.checkEnPassant(newPositionSquare);
                                    }
                                }
                            }
                            setCurrentPositionSquare(newPositionSquare);
                            newPositionSquare.setPiece(p);
                            Board.recordMoves(newPositionSquare.getPiece(), s, newPositionSquare);
                            return newPositionSquare;
                        }
                    }
                } else {
                    System.out.println("No position possible for piece");
                }
            }
        }
        return null;
    }



}
