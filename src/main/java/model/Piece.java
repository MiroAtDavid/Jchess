package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;
import java.util.Random;

public abstract class Piece {
    private String pieceName;
    private int pieceValue;
    private Square currentPositionSquare;
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

    public Piece(String pieceName, int pieceValue, Square currentPositionSquare) throws BoardException {
        setPieceName(pieceName);
        setPieceValue(pieceValue);
        setCurrentPositionSquare(currentPositionSquare);
    }

    // Getter ----------------------------------------------------------------------------------------------------------
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
        newPositionSquare.setPiece(this);
        this.setCurrentPositionSquare(newPositionSquare);
        return newPositionSquare;
    }

}