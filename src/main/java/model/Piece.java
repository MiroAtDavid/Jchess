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
    public abstract  ArrayList<Square> possiblePos(Board board) throws BoardException;
    public Square move(Board board) throws BoardException {
        getCurrentPositionSquare().setOccupied(false);
        Random random = new Random();
        int randomWithinPossibleMove;
        if (possiblePos(board).size() > 0)
            randomWithinPossibleMove = random.nextInt(0, possiblePos(board).size());
        else {
            System.out.println("No position possible for piece");
            return null;
        }
        Square newPositionSquare = possiblePos(board).get(randomWithinPossibleMove);
        if (newPositionSquare.isOccupied()){
            captureLogic(board, newPositionSquare, newPositionSquare.getPiece());
        }
        newPositionSquare.setPiece(this);
        setCurrentPositionSquare(newPositionSquare);
        return newPositionSquare;
    }
    private void captureLogic(Board board, Square newPositionSquare, Piece piece) throws BoardException {
        for (Player player : board.getPlayers()) {
            player.getPieces().remove(piece);
            newPositionSquare.removePiece(piece);
        }
    }

    public Square userMove(Board board, String userCurrentPosition, String userTargetPosition) throws BoardException {
        for (Square s : board.getSquares()){
            if (s.getSquareName().equals(userCurrentPosition)){
                Piece p = s.getPiece();
                s.setOccupied(false);
                s.removePiece(p);
                if (p.possiblePos(board).size() > 0) {
                    p.possiblePos(board).removeIf(sq -> !sq.getSquareName().equals(userTargetPosition));
                    for (Square newPositionSquare : possiblePos(board)) {
                        if (newPositionSquare.getSquareName().equals(userTargetPosition)) {
                            if (newPositionSquare.isOccupied()) {
                                captureLogic(board, newPositionSquare, newPositionSquare.getPiece());
                            }
                            if (p instanceof Pawn pawn) {
                                if (pawn.isEnPassant()){
                                    if (pawn.getEnPassantSquare().equals(newPositionSquare)){
                                        pawn.checkEnPassant(board, newPositionSquare);
                                    }
                                }
                                if (newPositionSquare.getRow() == 8) {
                                    pawn.pawnTransformationWhite(newPositionSquare);
                                    board.recordMoves(newPositionSquare.getPiece(), s, newPositionSquare);
                                    return newPositionSquare;
                                }
                                if (newPositionSquare.getRow() == 1) {
                                    pawn.pawnTransformationBlack(newPositionSquare);
                                    board.recordMoves(newPositionSquare.getPiece(), s, newPositionSquare);
                                    return newPositionSquare;
                                }
                            }
                            setCurrentPositionSquare(newPositionSquare);
                            newPositionSquare.setPiece(p);
                            board.recordMoves(newPositionSquare.getPiece(), s, newPositionSquare);
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