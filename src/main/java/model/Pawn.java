package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import static model.TestBoard.*;

public class Pawn extends Piece {

    private boolean enPassant;
    private Square enPassantSquare;

    // Konstruktor -----------------------------------------------------------------------------------------------------
    public Pawn(String pieceName, int pieceValue, Square currentPositionSquare, ImageView imageView, Image image) throws BoardException {
        super(pieceName, pieceValue, currentPositionSquare, imageView, image);
        setEnPassant(false);
        setEnPassantSquare(enPassantSquare);
    }

    public Pawn(String pieceName, int pieceValue, Square currentPositionSquare, String color) throws BoardException {
        super(pieceName, pieceValue,currentPositionSquare, color);
        setEnPassant(false);
    }
    // Getter ----------------------------------------------------------------------------------------------------------
    public boolean isEnPassant() {
        return enPassant;
    }

    public Square getEnPassantSquare() {
        return enPassantSquare;
    }

    // Setter ----------------------------------------------------------------------------------------------------------
    public void setEnPassant(boolean enPassant) {
        this.enPassant = enPassant;
    }

    public void setEnPassantSquare(Square enPassantSquare) {
        this.enPassantSquare = enPassantSquare;
    }

    // Methods ---------------------------------------------------------------------------------------------------------
    @Override
    public ArrayList<Square> possiblePos(Board board) {
        ArrayList<Square> possibleMoves = new ArrayList<>();
        if (!this.getColor().equals("black"))
            possibleMoves.addAll(possibleNorth(board));
        if (this.getColor().equals("black"))
            possibleMoves.addAll(possibleSouth(board));
        return possibleMoves;
    }

    public ArrayList<Square> possibleNorth(Board board) {
        boolean thirdRowOccupied = false;
        ArrayList<Square> northList = new ArrayList<>();
        for (Square sq : board.getSquares()){
            if (sq.getCol() == getCurrentPositionSquare().getCol()) {
                if (sq.isOccupied() && sq.getRow() == 3) {
                    thirdRowOccupied = true;
                }
            }
        }
        for (Square square : board.getSquares()){
                if (square.getCol() == getCurrentPositionSquare().getCol()) {
                    if (!square.isOccupied()) {
                        if (square.getRow() == getCurrentPositionSquare().getRow() + 1) {
                        northList.add(square);
                    }
                    if (square.getRow() == getCurrentPositionSquare().getRow() + 2 && getCurrentPositionSquare().getRow() == 2 && !thirdRowOccupied) {
                        northList.add(square);
                    }
                }
            } else if (square.getPiece() != null) {
                if (square.isOccupied() && !square.getPiece().getColor().equals(this.getColor())) {
                    if (square.getRow() == getCurrentPositionSquare().getRow() + 1 && square.getCol() == getCurrentPositionSquare().getCol() + 1)
                        northList.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() + 1 && square.getCol() == getCurrentPositionSquare().getCol() - 1)
                        northList.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() && getCurrentPositionSquare().getRow() == 5 && square.getCol() == getCurrentPositionSquare().getCol() - 1) {
                        Piece p = (Piece) board.recordMove.keySet().toArray()[0];
                        Collection<ArrayList<Square>> squaresArray = board.recordMove.values();
                        ArrayList<Square> first = squaresArray.iterator().next();
                        if (p.equals(square.getPiece()) && square.equals(first.get(1)) && first.get(0).getRow() == square.getRow() + 2) {
                            for (Square s : board.getSquares()) {
                                if (first.get(1).getRow() + 1 == s.getRow() && first.get(1).getCol() == s.getCol()) {
                                    setEnPassant(true);
                                    northList.add(s);
                                    setEnPassantSquare(s);
                                }
                            }
                        }
                    }
                    if (square.getRow() == getCurrentPositionSquare().getRow() && getCurrentPositionSquare().getRow() == 5 && square.getCol() == getCurrentPositionSquare().getCol() + 1) {
                        Piece p = (Piece) board.recordMove.keySet().toArray()[0];
                        Collection<ArrayList<Square>> squaresArray = board.recordMove.values();
                        ArrayList<Square> first = squaresArray.iterator().next();
                        if (p.equals(square.getPiece()) && square.equals(first.get(1)) && first.get(0).getRow() == square.getRow() + 2) {
                            for (Square s : board.getSquares()) {
                                if (first.get(1).getRow() + 1 == s.getRow() && first.get(1).getCol() == s.getCol()) {
                                    setEnPassant(true);
                                    northList.add(s);
                                    setEnPassantSquare(s);
                                }
                            }
                        }
                    }
                }
            }
        }
        return northList;
    }

    public ArrayList<Square> possibleSouth(Board board){
        boolean sixthRowOccupied = false;
        ArrayList<Square> southList = new ArrayList<>();
        for (Square sq : board.getSquares()){
            if (sq.getCol() == getCurrentPositionSquare().getCol()) {
                if (sq.isOccupied() && sq.getRow() == 6) {
                    sixthRowOccupied = true;
                }
            }
        }
        for (Square square : board.getSquares()){
            if (!square.isOccupied()) {
                if (square.getCol() == getCurrentPositionSquare().getCol()) {
                    if (square.getRow() == getCurrentPositionSquare().getRow() - 1) {
                        southList.add(square);
                    }
                    if (square.getRow() == getCurrentPositionSquare().getRow() - 2 && getCurrentPositionSquare().getRow() == 7 && !sixthRowOccupied) {
                        southList.add(square);
                    }
                }
            } else if (square.getPiece() != null) {
                if (square.isOccupied() && !square.getPiece().getColor().equals(this.getColor())) {
                    if (square.getRow() == getCurrentPositionSquare().getRow() - 1 && square.getCol() == getCurrentPositionSquare().getCol() + 1)
                        southList.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() - 1 && square.getCol() == getCurrentPositionSquare().getCol() - 1)
                        southList.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() && getCurrentPositionSquare().getRow() == 4 && square.getCol() == getCurrentPositionSquare().getCol() + 1) {
                        Piece p = (Piece) board.recordMove.keySet().toArray()[0];
                        Collection<ArrayList<Square>> squaresArray = board.recordMove.values();
                        ArrayList<Square> first = squaresArray.iterator().next();
                        if (p.equals(square.getPiece()) && square.equals(first.get(1)) && first.get(0).getRow() == square.getRow() - 2) {
                            for (Square s : board.getSquares()) {
                                if (first.get(1).getRow() - 1 == s.getRow() && first.get(1).getCol() == s.getCol()) {
                                    setEnPassant(true);
                                    southList.add(s);
                                    setEnPassantSquare(s);
                                }
                            }
                        }
                    }
                    if (square.getRow() == getCurrentPositionSquare().getRow() && getCurrentPositionSquare().getRow() == 4 && square.getCol() == getCurrentPositionSquare().getCol() - 1) {
                        Piece p = (Piece) board.recordMove.keySet().toArray()[0];
                        Collection<ArrayList<Square>> squaresArray = board.recordMove.values();
                        ArrayList<Square> first = squaresArray.iterator().next();
                        if (p.equals(square.getPiece()) && square.equals(first.get(1)) && first.get(0).getRow() == square.getRow() - 2) {
                            for (Square s : board.getSquares()) {
                                if (first.get(1).getRow() - 1 == s.getRow() && first.get(1).getCol() == s.getCol()) {
                                    setEnPassant(true);
                                    southList.add(s);
                                    setEnPassantSquare(s);
                                }
                            }
                        }
                    }
                }
            }
        }
        return southList;
    }

    public void checkEnPassant(Board board, Square sq) throws BoardException {
        sq.setOccupied(true);
        Collection<ArrayList<Square>> squaresArray = board.recordMove.values();
        ArrayList<Square> first = squaresArray.iterator().next();
        for (Square square : board.getSquares()){
            if (square.equals(first.get(1)) && first.get(0).getRow() == square.getRow() + 2) {
                setEnPassant(false);
                captureLogic(board, square, square.getPiece());
                setEnPassantSquare(null);
            } else if (square.equals(first.get(1)) && first.get(0).getRow() == square.getRow() - 2) {
                setEnPassant(false);
                captureLogic(board, square, square.getPiece());
                setEnPassantSquare(null);
            }
        }
    }

    private static void captureLogic(Board board, Square newPositionSquare, Piece piece) throws BoardException {
        for (Player player : board.getPlayers()) {
            player.getPieces().remove(piece);
            newPositionSquare.removePiece(piece);
            newPositionSquare.setOccupied(false);
        }
    }

    public void pawnTransformationWhite(Square transformationSquare) throws BoardException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Q for ♛ - R for ♜ - B for ♝ - K for ♞: ");
        String transformationPiece = sc.nextLine();
        switch (transformationPiece) {
            case "Q" -> transformationSquare.setPiece(new Qeen(ANSI_WHITE_QUEEN, 8, transformationSquare, "white"));
            case "R" -> transformationSquare.setPiece(new Qeen(ANSI_WHITE_ROOK, 4, transformationSquare, "white"));
            case "B" -> transformationSquare.setPiece(new Qeen(ANSI_WHITE_BISHOP, 3, transformationSquare, "white"));
            case "K" -> transformationSquare.setPiece(new Qeen(ANSI_WHITE_KNIGHT, 3, transformationSquare, "white"));
        }
        transformationSquare.setOccupied(true);
    }

    public void pawnTransformationBlack(Square transformationSquare) throws BoardException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Q for ♕ - R for ♖ - B for ♗ - K for ♘: ");
        String transformationPiece = sc.nextLine();
        switch (transformationPiece) {
            case "Q" -> transformationSquare.setPiece(new Qeen(ANSI_BLACK_QUEEN, 8, transformationSquare, "black"));
            case "R" -> transformationSquare.setPiece(new Qeen(ANSI_BLACK_ROOK, 4, transformationSquare, "black"));
            case "B" -> transformationSquare.setPiece(new Qeen(ANSI_BLACK_BISHOP, 3, transformationSquare, "black"));
            case "K" -> transformationSquare.setPiece(new Qeen(ANSI_BLACK_KNIGHT, 3, transformationSquare, "black"));
        }
        transformationSquare.setOccupied(true);
    }
}