package model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Scanner;


public class TestBoard {

    public static final String ANSI_BLACK_PAWN = "\u2659";
    public static final String ANSI_BLACK_ROOK = "\u2656";
    public static final String ANSI_BLACK_KNIGHT = "\u2658";
    public static final String ANSI_BLACK_BISHOP = "\u2657";
    public static final String ANSI_BLACK_QUEEN = "\u2655";
    public static final String ANSI_BLACK_KING = "\u2654";

    public static final String ANSI_WHITE_PAWN = "\u265F";
    public static final String ANSI_WHITE_ROOK = "\u265C";
    public static final String ANSI_WHITE_KNIGHT = "\u265E";
    public static final String ANSI_WHITE_BISHOP = "\u265D";
    public static final String ANSI_WHITE_QUEEN = "\u265B";
    public static final String ANSI_WHITE_KING = "\u265A";
    public static void main(String[] args) {
        try {
            initBoard();
        } catch (BoardException e) {
            throw new RuntimeException(e);
        }
    }

    public static Board initBoard() throws BoardException {

        // Init Board
        Board chessBoard = new Board();

        // Squares
        Square h8 = chessBoard.addSquare("h8", 8, 8, Color.valueOf("sienna"));
        Square g8 = chessBoard.addSquare("g8", 8, 7, Color.valueOf("beige"));
        Square f8 = chessBoard.addSquare("f8", 8, 6, Color.valueOf("sienna"));
        Square e8 = chessBoard.addSquare("e8", 8, 5, Color.valueOf("beige"));
        Square d8 = chessBoard.addSquare("d8", 8, 4, Color.valueOf("sienna"));
        Square c8 = chessBoard.addSquare("c8", 8, 3, Color.valueOf("beige"));
        Square b8 = chessBoard.addSquare("b8", 8, 2, Color.valueOf("sienna"));
        Square a8 = chessBoard.addSquare("a8", 8, 1, Color.valueOf("beige"));

        Square h7 = chessBoard.addSquare("h7", 7, 8, Color.valueOf("beige"));
        Square g7 = chessBoard.addSquare("g7", 7, 7, Color.valueOf("sienna"));
        Square f7 = chessBoard.addSquare("f7", 7, 6, Color.valueOf("beige"));
        Square e7 = chessBoard.addSquare("e7", 7, 5, Color.valueOf("sienna"));
        Square d7 = chessBoard.addSquare("d7", 7, 4, Color.valueOf("beige"));
        Square c7 = chessBoard.addSquare("c7", 7, 3, Color.valueOf("sienna"));
        Square b7 = chessBoard.addSquare("b7", 7, 2, Color.valueOf("beige"));
        Square a7 = chessBoard.addSquare("a7", 7, 1, Color.valueOf("sienna"));

        Square h6 = chessBoard.addSquare("h6", 6, 8, Color.valueOf("sienna"));
        Square g6 = chessBoard.addSquare("g6", 6, 7, Color.valueOf("beige"));
        Square f6 = chessBoard.addSquare("f6", 6, 6, Color.valueOf("sienna"));
        Square e6 = chessBoard.addSquare("e6", 6, 5, Color.valueOf("beige"));
        Square d6 = chessBoard.addSquare("d6", 6, 4, Color.valueOf("sienna"));
        Square c6 = chessBoard.addSquare("c6", 6, 3, Color.valueOf("beige"));
        Square b6 = chessBoard.addSquare("b6", 6, 2, Color.valueOf("sienna"));
        Square a6 = chessBoard.addSquare("a6", 6, 1, Color.valueOf("beige"));

        Square h5 = chessBoard.addSquare("h5", 5, 8, Color.valueOf("beige"));
        Square g5 = chessBoard.addSquare("g5", 5, 7, Color.valueOf("sienna"));
        Square f5 = chessBoard.addSquare("f5", 5, 6, Color.valueOf("beige"));
        Square e5 = chessBoard.addSquare("e5", 5, 5, Color.valueOf("sienna"));
        Square d5 = chessBoard.addSquare("d5", 5, 4, Color.valueOf("beige"));
        Square c5 = chessBoard.addSquare("c5", 5, 3, Color.valueOf("sienna"));
        Square b5 = chessBoard.addSquare("b5", 5, 2, Color.valueOf("beige"));
        Square a5 = chessBoard.addSquare("a5", 5, 1, Color.valueOf("sienna"));

        Square h4 = chessBoard.addSquare("h4", 4, 8, Color.valueOf("sienna"));
        Square g4 = chessBoard.addSquare("g4", 4, 7, Color.valueOf("beige"));
        Square f4 = chessBoard.addSquare("f4", 4, 6, Color.valueOf("sienna"));
        Square e4 = chessBoard.addSquare("e4", 4, 5, Color.valueOf("beige"));
        Square d4 = chessBoard.addSquare("d4", 4, 4, Color.valueOf("sienna"));
        Square c4 = chessBoard.addSquare("c4", 4, 3, Color.valueOf("beige"));
        Square b4 = chessBoard.addSquare("b4", 4, 2, Color.valueOf("sienna"));
        Square a4 = chessBoard.addSquare("a4", 4, 1, Color.valueOf("beige"));

        Square h3 = chessBoard.addSquare("h3", 3, 8, Color.valueOf("beige"));
        Square g3 = chessBoard.addSquare("g3", 3, 7, Color.valueOf("sienna"));
        Square f3 = chessBoard.addSquare("f3", 3, 6, Color.valueOf("beige"));
        Square e3 = chessBoard.addSquare("e3", 3, 5, Color.valueOf("sienna"));
        Square d3 = chessBoard.addSquare("d3", 3, 4, Color.valueOf("beige"));
        Square c3 = chessBoard.addSquare("c3", 3, 3, Color.valueOf("sienna"));
        Square b3 = chessBoard.addSquare("b3", 3, 2, Color.valueOf("beige"));
        Square a3 = chessBoard.addSquare("a3", 3, 1, Color.valueOf("sienna"));

        Square h2 = chessBoard.addSquare("h2", 2, 8, Color.valueOf("sienna"));
        Square g2 = chessBoard.addSquare("g2", 2, 7, Color.valueOf("beige"));
        Square f2 = chessBoard.addSquare("f2", 2, 6, Color.valueOf("sienna"));
        Square e2 = chessBoard.addSquare("e2", 2, 5, Color.valueOf("beige"));
        Square d2 = chessBoard.addSquare("d2", 2, 4, Color.valueOf("sienna"));
        Square c2 = chessBoard.addSquare("c2", 2, 3, Color.valueOf("beige"));
        Square b2 = chessBoard.addSquare("b2", 2, 2, Color.valueOf("sienna"));
        Square a2 = chessBoard.addSquare("a2", 2, 1, Color.valueOf("beige"));

        Square h1 = chessBoard.addSquare("h1", 1, 8, Color.valueOf("beige"));
        Square g1 = chessBoard.addSquare("g1", 1, 7, Color.valueOf("sienna"));
        Square f1 = chessBoard.addSquare("f1", 1, 6, Color.valueOf("beige"));
        Square e1 = chessBoard.addSquare("e1", 1, 5, Color.valueOf("sienna"));
        Square d1 = chessBoard.addSquare("d1", 1, 4, Color.valueOf("beige"));
        Square c1 = chessBoard.addSquare("c1", 1, 3, Color.valueOf("sienna"));
        Square b1 = chessBoard.addSquare("b1", 1, 2, Color.valueOf("beige"));
        Square a1 = chessBoard.addSquare("a1", 1, 1, Color.valueOf("sienna"));


        // Init Pieces White
        Pawn pawnW8 = new Pawn(ANSI_WHITE_PAWN, 1, Board.getSquares().get(48), "white");
        Pawn pawnW7 = new Pawn(ANSI_WHITE_PAWN, 1, Board.getSquares().get(49), "white");
        Pawn pawnW6 = new Pawn(ANSI_WHITE_PAWN, 1, Board.getSquares().get(50), "white");
        Pawn pawnW5 = new Pawn(ANSI_WHITE_PAWN, 1, Board.getSquares().get(51), "white");
        Pawn pawnW4 = new Pawn(ANSI_WHITE_PAWN, 1, Board.getSquares().get(52), "white");
        Pawn pawnW3 = new Pawn(ANSI_WHITE_PAWN, 1, Board.getSquares().get(53), "white");
        Pawn pawnW2 = new Pawn(ANSI_WHITE_PAWN, 1, Board.getSquares().get(54), "white");
        Pawn pawnW1 = new Pawn(ANSI_WHITE_PAWN, 1, Board.getSquares().get(55), "white");
        Rook rookw2 = new Rook(ANSI_WHITE_ROOK, 4, Board.getSquares().get(56), "white");
        Knight knightw2 = new Knight(ANSI_WHITE_KNIGHT, 3, Board.getSquares().get(57), "white");
        Bishop bishopw2 = new Bishop(ANSI_WHITE_BISHOP, 3, Board.getSquares().get(58), "white");
        King kingw = new King(ANSI_WHITE_KING, 100, Board.getSquares().get(59), "white");
        Qeen queenw = new Qeen(ANSI_WHITE_QUEEN, 8, Board.getSquares().get(60), "white");
        Bishop bishopw = new Bishop(ANSI_WHITE_BISHOP, 3, Board.getSquares().get(61), "white");
        Knight knightw = new Knight(ANSI_WHITE_KNIGHT, 3, Board.getSquares().get(62), "white");
        Rook rookw = new Rook(ANSI_WHITE_ROOK, 4, Board.getSquares().get(63), "white");

        // Init Pieces Black
        Rook rookB2 = new Rook(ANSI_BLACK_ROOK, 4, Board.getSquares().get(0), "black");
        Knight knightB2 = new Knight(ANSI_BLACK_KNIGHT, 3, Board.getSquares().get(1), "black");
        Bishop bishopB2 = new Bishop(ANSI_BLACK_BISHOP, 3, Board.getSquares().get(2), "black");
        King kingB = new King(ANSI_BLACK_KING, 100, Board.getSquares().get(3), "black");
        Qeen queenB = new Qeen(ANSI_BLACK_QUEEN, 8, Board.getSquares().get(4), "black");
        Bishop bishopB = new Bishop(ANSI_BLACK_BISHOP, 3, Board.getSquares().get(5), "black");
        Knight knightB = new Knight(ANSI_BLACK_KNIGHT, 3, Board.getSquares().get(6), "black");
        Rook rookB = new Rook(ANSI_BLACK_ROOK, 4, Board.getSquares().get(7), "black");
        Pawn pawnB8 = new Pawn(ANSI_BLACK_PAWN, 1, Board.getSquares().get(8), "black");
        Pawn pawnB7 = new Pawn(ANSI_BLACK_PAWN, 1, Board.getSquares().get(9), "black");
        Pawn pawnB5 = new Pawn(ANSI_BLACK_PAWN, 1, Board.getSquares().get(11), "black");
        Pawn pawnB4 = new Pawn(ANSI_BLACK_PAWN, 1, Board.getSquares().get(12), "black");
        Pawn pawnB6 = new Pawn(ANSI_BLACK_PAWN, 1, Board.getSquares().get(10), "black");
        Pawn pawnB3 = new Pawn(ANSI_BLACK_PAWN, 1, Board.getSquares().get(13), "black");
        Pawn pawnB2 = new Pawn(ANSI_BLACK_PAWN, 1, Board.getSquares().get(14), "black");
        Pawn pawnB1 = new Pawn(ANSI_BLACK_PAWN, 1, Board.getSquares().get(15), "black");


        // Init Players and add Pieces
        ArrayList<Piece> playerOnePieces = new ArrayList<>();
        ArrayList<Piece> playerTwoPieces = new ArrayList<>();

        Player playerOne = new Player("PlayerOne", playerOnePieces, "White");
        Player playerTwo = new Player("PlayerTwo", playerTwoPieces, "Black");

        for (Square s : Board.getSquares()) {
            if (s.getPiece() != null) {
                if (s.getPiece().getColor().equals("white"))
                    playerOnePieces.add(s.getPiece());
            }
        }

        for (Square s : Board.getSquares()) {
            if (s.getPiece() != null) {
                if (s.getPiece().getColor().equals("black"))
                    playerTwoPieces.add(s.getPiece());
            }
        }

        // -------------------------------------------------------------------------------------------------------------


        int counter = 0;
        while (counter < 40) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Your move from: ");
            String userPieceSquare = sc.nextLine();
            System.out.println("Your move to: ");
            String userPieceTargetSquare = sc.nextLine();
            for (Square square : Board.getSquares()) {
                if (square.getPiece() != null) {
                    if (square.getPiece().equals(kingw) || square.getPiece().equals(kingB)) {
                        if (userPieceSquare.equals("e1") && userPieceTargetSquare.equals("g1") && !kingw.isActivated()) {
                            kingw.castleWhiteKingSide();
                        } else if (userPieceSquare.equals("e1") && userPieceTargetSquare.equals("c1") && !kingw.isActivated()) {
                            kingw.castleWhiteQueenSide();
                        } else if (userPieceSquare.equals("e8") && userPieceTargetSquare.equals("g8") && !kingB.isActivated()) {
                            kingB.castleBlackKingSide();
                        } else if (userPieceSquare.equals("e8") && userPieceTargetSquare.equals("c8") && !kingB.isActivated()) {
                            kingB.castleBlackQueenSide();
                        } else if (userPieceSquare.equals(square.getSquareName())) {
                            if (square.getPiece().equals(kingw)){
                                kingw.setActivated(true);
                            } else if (square.getPiece().equals(kingB)){
                                kingB.setActivated(true);
                            } else if (square.getPiece().equals(rookw)) {
                                rookw.setActivated(true);
                            } else if (square.getPiece().equals(rookw2)) {
                                rookw2.setActivated(true);
                            } else if (square.getPiece().equals(rookB)) {
                                rookB.setActivated(true);
                            } else if (square.getPiece().equals(rookB2)) {
                                rookB2.setActivated(true);
                            }
                            square.getPiece().userMove(userPieceSquare, userPieceTargetSquare);
                        }
                    } else if (userPieceSquare.equals(square.getSquareName())) {
                        if (square.getPiece().equals(kingw)){
                            kingw.setActivated(true);
                        } else if (square.getPiece().equals(kingB)){
                            kingB.setActivated(true);
                        } else if (square.getPiece().equals(rookw)) {
                            rookw.setActivated(true);
                        } else if (square.getPiece().equals(rookw2)) {
                            rookw2.setActivated(true);
                        } else if (square.getPiece().equals(rookB)) {
                            rookB.setActivated(true);
                        } else if (square.getPiece().equals(rookB2)) {
                            rookB2.setActivated(true);
                        }
                        square.getPiece().userMove(userPieceSquare, userPieceTargetSquare);
                    }
                }
            }
            chessBoard.print();
            counter++;
        }

            return chessBoard;

        }

}