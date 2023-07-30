package model;

import javafx.scene.paint.Color;

import java.util.*;
import java.util.stream.Collectors;


public class TestBoard {

    public static final String ANSI_BLACK_PAWN = "♙";
    public static final String ANSI_BLACK_ROOK = "♖";
    public static final String ANSI_BLACK_KNIGHT = "♘";
    public static final String ANSI_BLACK_BISHOP = "♗";
    public static final String ANSI_BLACK_QUEEN = "♕";
    public static final String ANSI_BLACK_KING = "♔";

    public static final String ANSI_WHITE_PAWN = "♟";
    public static final String ANSI_WHITE_ROOK = "♜";
    public static final String ANSI_WHITE_KNIGHT = "♞";
    public static final String ANSI_WHITE_BISHOP = "♝";
    public static final String ANSI_WHITE_QUEEN = "♛";
    public static final String ANSI_WHITE_KING = "♚";
    public static void main(String[] args) {
        try {
            initBoard();
        } catch (BoardException e) {
            throw new RuntimeException(e);
        }
    }

    public static Board initBoard() throws BoardException {


        ArrayList<Piece> playerOnePieces = new ArrayList<>();
        Player playerOne = new Player("PlayerOne", playerOnePieces, "White");
        // Init Board
        ArrayList<Piece> playerTwoPieces = new ArrayList<>();
        Player playerTwo =  new Player("PlayerTwo", playerTwoPieces, "Black");

        Board chessBoard = new Board();

        chessBoard.addPlayer(playerOne);
        chessBoard.addPlayer(playerTwo);

        List<String> rowLetters = new ArrayList<>(
                List.of("a", "b", "c", "d", "e", "f", "g", "h")
        );
        List<String> colNumbers = new ArrayList<>(
                List.of("1", "2", "3", "4", "5", "6", "7", "8")
        );

        for (int i = 7; i >= 0; i--){
            for (int j = 7; j >= 0; j--){
                if (j % 2 != 0) {
                    chessBoard.addSquare(rowLetters.get(j) + colNumbers.get(i), i + 1, j + 1, Color.valueOf("beige"));
                } else {
                    chessBoard.addSquare(rowLetters.get(j) + colNumbers.get(i), i + 1, j + 1, Color.valueOf("sienna"));
                }
            }
        }


        // Init Pieces White
        Pawn pawnW8 = new Pawn(ANSI_WHITE_PAWN, 1, chessBoard.getSquares().get(48), "white");
        Pawn pawnW7 = new Pawn(ANSI_WHITE_PAWN, 1, chessBoard.getSquares().get(49), "white");
        Pawn pawnW6 = new Pawn(ANSI_WHITE_PAWN, 1, chessBoard.getSquares().get(50), "white");
        Pawn pawnW5 = new Pawn(ANSI_WHITE_PAWN, 1, chessBoard.getSquares().get(51), "white");
        Pawn pawnW4 = new Pawn(ANSI_WHITE_PAWN, 1, chessBoard.getSquares().get(52), "white");
        Pawn pawnW3 = new Pawn(ANSI_WHITE_PAWN, 1, chessBoard.getSquares().get(53), "white");
        Pawn pawnW2 = new Pawn(ANSI_WHITE_PAWN, 1, chessBoard.getSquares().get(54), "white");
        Pawn pawnW1 = new Pawn(ANSI_WHITE_PAWN, 1, chessBoard.getSquares().get(55), "white");
        Rook rookw2 = new Rook(ANSI_WHITE_ROOK, 4, chessBoard.getSquares().get(56), "white");
        Knight knightw2 = new Knight(ANSI_WHITE_KNIGHT, 3, chessBoard.getSquares().get(57), "white");
        Bishop bishopw2 = new Bishop(ANSI_WHITE_BISHOP, 3, chessBoard.getSquares().get(58), "white");
        King kingw = new King(ANSI_WHITE_KING, 100, chessBoard.getSquares().get(59), "white");
        Qeen queenw = new Qeen(ANSI_WHITE_QUEEN, 8, chessBoard.getSquares().get(60), "white");
        Bishop bishopw = new Bishop(ANSI_WHITE_BISHOP, 3, chessBoard.getSquares().get(61), "white");
        Knight knightw = new Knight(ANSI_WHITE_KNIGHT, 3, chessBoard.getSquares().get(62), "white");
        Rook rookw = new Rook(ANSI_WHITE_ROOK, 4, chessBoard.getSquares().get(63), "white");

        // Init Pieces Black
        Rook rookB2 = new Rook(ANSI_BLACK_ROOK, 4, chessBoard.getSquares().get(0), "black");
        Knight knightB2 = new Knight(ANSI_BLACK_KNIGHT, 3, chessBoard.getSquares().get(1), "black");
        Bishop bishopB2 = new Bishop(ANSI_BLACK_BISHOP, 3, chessBoard.getSquares().get(2), "black");
        King kingB = new King(ANSI_BLACK_KING, 100, chessBoard.getSquares().get(3), "black");
        Qeen queenB = new Qeen(ANSI_BLACK_QUEEN, 8, chessBoard.getSquares().get(4), "black");
        Bishop bishopB = new Bishop(ANSI_BLACK_BISHOP, 3, chessBoard.getSquares().get(5), "black");
        Knight knightB = new Knight(ANSI_BLACK_KNIGHT, 3, chessBoard.getSquares().get(6), "black");
        Rook rookB = new Rook(ANSI_BLACK_ROOK, 4, chessBoard.getSquares().get(7), "black");
        Pawn pawnB8 = new Pawn(ANSI_BLACK_PAWN, 1, chessBoard.getSquares().get(8), "black");
        Pawn pawnB7 = new Pawn(ANSI_BLACK_PAWN, 1, chessBoard.getSquares().get(9), "black");
        Pawn pawnB5 = new Pawn(ANSI_BLACK_PAWN, 1, chessBoard.getSquares().get(11), "black");
        Pawn pawnB4 = new Pawn(ANSI_BLACK_PAWN, 1, chessBoard.getSquares().get(12), "black");
        Pawn pawnB6 = new Pawn(ANSI_BLACK_PAWN, 1, chessBoard.getSquares().get(10), "black");
        Pawn pawnB3 = new Pawn(ANSI_BLACK_PAWN, 1, chessBoard.getSquares().get(13), "black");
        Pawn pawnB2 = new Pawn(ANSI_BLACK_PAWN, 1, chessBoard.getSquares().get(14), "black");
        Pawn pawnB1 = new Pawn(ANSI_BLACK_PAWN, 1, chessBoard.getSquares().get(15), "black");


        for (Square s : chessBoard.getSquares()) {
            if (s.getPiece() != null) {
                if (s.getPiece().getColor().equals("white"))
                    playerOnePieces.add(s.getPiece());
            }
        }

        for (Square s : chessBoard.getSquares()) {
            if (s.getPiece() != null) {
                if (s.getPiece().getColor().equals("black")) {
                    playerTwoPieces.add(s.getPiece());
                }

            }
        }

        // -------------------------------------------------------------------------------------------------------------
        chessBoard.print();
        int counter = 0;
        while (counter < 40) {
            if (kingB.checkProbeBlack(chessBoard, kingB)) {
                System.out.println("check on black king!");
            }
            if (kingw.checkProbeWhite(chessBoard, kingw)) {
                System.out.println("Check on white king!!");
            }
            Scanner sc = new Scanner(System.in);
            System.out.println("Your move from: ");
            String userPieceSquare = sc.nextLine();
            System.out.println("Your move to: ");
            String userPieceTargetSquare = sc.nextLine();
            for (Square square : chessBoard.getSquares()) {
                if (square.getPiece() != null) {
                    if (square.getPiece().equals(kingw) || square.getPiece().equals(kingB)) {
                        if (userPieceSquare.equals("e1") && userPieceTargetSquare.equals("g1") && !kingw.isActivated()) {
                            kingw.castleWhiteKingSide(chessBoard);
                        } else if (userPieceSquare.equals("e1") && userPieceTargetSquare.equals("c1") && !kingw.isActivated()) {
                            kingw.castleWhiteQueenSide(chessBoard);
                        } else if (userPieceSquare.equals("e8") && userPieceTargetSquare.equals("g8") && !kingB.isActivated()) {
                            kingB.castleBlackKingSide(chessBoard);
                        } else if (userPieceSquare.equals("e8") && userPieceTargetSquare.equals("c8") && !kingB.isActivated()) {
                            kingB.castleBlackQueenSide(chessBoard);
                        } else if (userPieceSquare.equals(square.getSquareName())) {
                            if (square.getPiece().equals(kingw)) {
                                kingw.setActivated(true);
                            } else if (square.getPiece().equals(kingB)) {
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
                            square.getPiece().userMove(chessBoard, userPieceSquare, userPieceTargetSquare);
                        }
                    } else if (userPieceSquare.equals(square.getSquareName())) {
                        if (square.getPiece().equals(kingw)) {
                            kingw.setActivated(true);
                        } else if (square.getPiece().equals(kingB)) {
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
                        square.getPiece().userMove(chessBoard, userPieceSquare, userPieceTargetSquare);
                    }
                }
            }
            System.out.println();
            Collections.reverse(playerOnePieces);
            playerOnePieces.stream().map(Piece::getPieceName).forEach(System.out::print);
            int sup1 = playerOnePieces.stream().mapToInt(Piece::getPieceValue).sum();
            System.out.println(": " + sup1);
            playerTwoPieces.stream().map(Piece::getPieceName).forEach(System.out::print);
            int sup2 = playerTwoPieces.stream().mapToInt(Piece::getPieceValue).sum();
            System.out.println(": " + sup2);

            chessBoard.print();

            counter++;
        }
        return chessBoard;
    }
}