package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.Collections;
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
    public abstract  ArrayList<Square> possiblePos();

    public Square move() throws BoardException {
        getCurrentPositionSquare().setOccupied(false);
        Random random = new Random();
        int randomWithinPossibleMove = 0;
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
        this.setCurrentPositionSquare(newPositionSquare);
        return newPositionSquare;
    }

    private void captureLogic(Square newPositionSquare) throws BoardException {
        if (!this.getColor().equals(newPositionSquare.getPiece().getColor())){
            newPositionSquare.removePiece();
            Player.getPieces().remove(newPositionSquare.getPiece());
        } else {
            throw new BoardException("captureLogic(): Can't capture pieces of same color!");
        }

    }

    public Square userMove(String userTargetPosition) throws BoardException {
        // TODO - moving a piece to a not allowed square doesn't throw an error !!!!!!!!!!!!!!
        // TODO - move after,  the piece is still at the same place !!!!!!!!!!!!!!!!
        // TODO - capture logic doesn't differentiate between piece color
        // TODO - neither does it remove the piece from the player pieces array
        // TODO - capture logic only implemetented on both north bishop movement
        // TODO - no need to go further until the current bugs are sorted out

        this.getCurrentPositionSquare().setOccupied(false);
        if (this.possiblePos().size() > 0) {
            for (Square newPositionSquare : possiblePos()) {
                if (newPositionSquare.getSquareName().equals(userTargetPosition)) {
                    this.setCurrentPositionSquare(newPositionSquare);
                    newPositionSquare.setPiece(this);
                    return newPositionSquare;
                }
            }
        } else {
            System.out.println("No position possible for piece");
        }
        return null;
    }

}
