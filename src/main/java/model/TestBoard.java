package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.*;


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
            game();
        } catch (BoardException e) {
            throw new RuntimeException(e);
        }
    }

    // Initial clean board state with Pieces and Players ---------------------------------------------------------------
    public static Board initBoard() throws BoardException {

        ArrayList<Piece> playerOnePieces = new ArrayList<>();
        Player playerOne = new Player("PlayerOne", playerOnePieces, "White");
        // Init Board
        ArrayList<Piece> playerTwoPieces = new ArrayList<>();
        Player playerTwo = new Player("PlayerTwo", playerTwoPieces, "Black");

        Board chessBoard = new Board();

        chessBoard.addPlayer(playerOne);
        chessBoard.addPlayer(playerTwo);

        List<String> rowLetters = new ArrayList<>(
                List.of("a", "b", "c", "d", "e", "f", "g", "h")
        );
        List<String> colNumbers = new ArrayList<>(
                List.of("1", "2", "3", "4", "5", "6", "7", "8")
        );

        for (int i = 7; i >= 0; i--) {
            for (int j = 7; j >= 0; j--) {
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
        return chessBoard;
    }
    // -------------------------------------------------------------------------------------------------------------

    // Game Loop
    private static void game() throws BoardException {
        Board chessBoard = initBoard();
        chessBoard.print();
        ArrayList<Piece> playerOnePieces = chessBoard.getPlayers().get(0).getPieces();
        ArrayList<Piece> playerTwoPieces = chessBoard.getPlayers().get(1).getPieces();
        int counter = 0;
        King kingWhite = null;
        King kingBlack = null;
        for (Piece piece : chessBoard.getPlayers().get(0).getPieces()){
            if (piece instanceof King king)
                kingWhite = king;
        }
        for (Piece piece : chessBoard.getPlayers().get(1).getPieces()){
            if (piece instanceof King king)
                kingBlack = king;
        }
        assert kingWhite != null;
        assert kingBlack != null;
        while (!chessBoard.getPlayers().get(0).isCheckMate() && !chessBoard.getPlayers().get(1).isCheckMate()) {
            do {
                kingWhite.checkProbeWhite(chessBoard, kingWhite);
                kingWhite.checkMateProbeWhite(chessBoard, kingWhite);
                if (chessBoard.getPlayers().get(0).isCheckMate())
                    break;
                movePlayerOne(chessBoard);
                testgame(chessBoard);
            } while (chessBoard.getPlayers().get(0).isCheck());

            do {
                kingBlack.checkProbeBlack(chessBoard, kingBlack);
                kingBlack.checkMateProbeBlack(chessBoard, kingBlack);
                if (chessBoard.getPlayers().get(1).isCheckMate()) {
                    break;
                }
                movePlayerTwo(chessBoard);
                testgame(chessBoard);
            } while (chessBoard.getPlayers().get(1).isCheck());
            counter++;
        }
    }

    private static boolean movePlayerOne(Board board) throws BoardException {
        ArrayList<Piece> playerOnePieces = board.getPlayers().get(0).getPieces();
        ArrayList<Piece> playerTwoPieces = board.getPlayers().get(1).getPieces();

        Scanner sc = new Scanner(System.in);
        System.out.println("Player One, your move from: ");
        String userPieceSquare = sc.nextLine();
        System.out.println("Your move to: ");
        String userPieceTargetSquare = sc.nextLine();
        Square targetSquare = null;
        for (Square square : board.getSquares()) {
            if (square.getSquareName().equals(userPieceTargetSquare)) {
                targetSquare = square;
            }
        }
        for (Square square : board.getSquares()) {
            if (square.getPiece() != null) {
                if (playerOnePieces.contains(square.getPiece())) {
                    ArrayList<Square> checkTarget = null;
                    if (square.getPiece() instanceof King king) {
                        if (userPieceSquare.equals("e1") && userPieceTargetSquare.equals("g1") && !king.isActivated()) {
                            king.castleWhiteKingSide(board);
                            return true;
                        } else if (userPieceSquare.equals("e1") && userPieceTargetSquare.equals("g1") && king.isActivated()) {
                            square.setPiece(king);
                            square.setOccupied(true);
                            return false;
                        } else if (userPieceSquare.equals("e1") && userPieceTargetSquare.equals("c1") && !king.isActivated()) {
                            king.castleWhiteQueenSide(board);
                            return true;
                        } else if (userPieceSquare.equals("e1") && userPieceTargetSquare.equals("c1") && king.isActivated()) {
                            square.setPiece(king);
                            square.setOccupied(true);
                            return false;
                        } else if (userPieceSquare.equals(square.getSquareName())) {
                            if (square.getPiece().equals(king)) {
                                checkTarget = square.getPiece().checkPossiblePos(board);
                                if (checkTarget.contains(targetSquare))
                                    king.setActivated(true);
                            } else if (square.getPiece() instanceof King king1) {
                                checkTarget = square.getPiece().checkPossiblePos(board);
                                if (checkTarget.contains(targetSquare))
                                    king1.setActivated(true);
                            } else if (square.getPiece() instanceof Rook rook) {
                                checkTarget = square.getPiece().checkPossiblePos(board);
                                if (checkTarget.contains(targetSquare))
                                    rook.setActivated(true);
                            }
                            checkTarget = square.getPiece().checkPossiblePos(board);
                            Piece pi = null;
                            if (checkTarget.contains(targetSquare)){
                                assert targetSquare != null;
                                if (targetSquare.isOccupied()) {
                                    pi = targetSquare.getPiece();
                                }
                                Piece p = square.getPiece();
                                square.getPiece().userMove(board, userPieceSquare, userPieceTargetSquare);
                                if (king.checkProbeWhite(board, king)) {
                                    square.setPiece(p);
                                    square.setOccupied(true);
                                    targetSquare.setPiece(null);
                                    targetSquare.setOccupied(false);
                                    if (pi != null) {
                                        targetSquare.setPiece(pi);
                                        targetSquare.setOccupied(true);
                                    } else {
                                        targetSquare.setOccupied(false);
                                        targetSquare.setPiece(null);
                                    }
                                }
                            }
                            return true;
                        }
                    } else if (userPieceSquare.equals(square.getSquareName())) {
                        if (square.getPiece() instanceof King king) {
                            checkTarget = square.getPiece().checkPossiblePos(board);
                            if (checkTarget.contains(targetSquare))
                                king.setActivated(true);
                        } else if (square.getPiece() instanceof Rook rook) {
                            checkTarget = square.getPiece().checkPossiblePos(board);
                            if (checkTarget.contains(targetSquare))
                                rook.setActivated(true);
                        }
                        checkTarget = square.getPiece().checkPossiblePos(board);
                        Piece pi = null;
                        if (checkTarget.contains(targetSquare)){
                            assert targetSquare != null;
                            if (targetSquare.isOccupied()) {
                                pi = targetSquare.getPiece();
                            }
                            Piece p = square.getPiece();
                            square.getPiece().userMove(board, userPieceSquare, userPieceTargetSquare);
                            for (Piece piece : playerOnePieces) {
                                if (piece instanceof King king) {
                                    if (king.checkProbeWhite(board, king)) {
                                        square.setPiece(p);
                                        square.setOccupied(true);
                                        targetSquare.setOccupied(false);
                                        targetSquare.setPiece(null);
                                        if (pi != null) {
                                            targetSquare.setPiece(pi);
                                            targetSquare.setOccupied(true);
                                        } else {
                                            targetSquare.setOccupied(false);
                                            targetSquare.setPiece(null);
                                        }
                                    }
                                }
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return true;
    }

    private static boolean movePlayerTwo(Board board) throws BoardException {
        ArrayList<Piece> playerOnePieces = board.getPlayers().get(0).getPieces();
        ArrayList<Piece> playerTwoPieces = board.getPlayers().get(1).getPieces();

        Scanner sc = new Scanner(System.in);
        System.out.println("Player Two, your move from: ");
        String userPieceSquare = sc.nextLine();
        System.out.println("Your move to: ");
        String userPieceTargetSquare = sc.nextLine();
        Square targetSquare = null;
        for (Square square : board.getSquares()) {
            if (square.getSquareName().equals(userPieceTargetSquare)) {
                targetSquare = square;
            }
        }
        for (Square square : board.getSquares()) {
            if (square.getPiece() != null) {
                if (playerTwoPieces.contains(square.getPiece())) {
                    ArrayList<Square> checkTarget = null;
                    if (square.getPiece() instanceof King king) {
                        if (userPieceSquare.equals("e8") && userPieceTargetSquare.equals("g8") && !king.isActivated()) {
                            king.castleBlackKingSide(board);
                            return true;
                        } else if (userPieceSquare.equals("e8") && userPieceTargetSquare.equals("g8") && king.isActivated()) {
                            square.setPiece(king);
                            square.setOccupied(true);
                            return false;
                        } else if (userPieceSquare.equals("e8") && userPieceTargetSquare.equals("c8") && !king.isActivated()) {
                            king.castleBlackQueenSide(board);
                            return true;
                        } else if (userPieceSquare.equals("e8") && userPieceTargetSquare.equals("c8") && king.isActivated()) {
                            square.setPiece(king);
                            square.setOccupied(true);
                            return false;
                        } else if (userPieceSquare.equals(square.getSquareName())) {
                            if (square.getPiece().equals(king)) {
                                checkTarget = square.getPiece().checkPossiblePos(board);
                                if (checkTarget.contains(targetSquare))
                                    king.setActivated(true);
                            } else if (square.getPiece() instanceof King king1) {
                                checkTarget = square.getPiece().checkPossiblePos(board);
                                if (checkTarget.contains(targetSquare))
                                    king1.setActivated(true);
                            } else if (square.getPiece() instanceof Rook rook) {
                                checkTarget = square.getPiece().checkPossiblePos(board);
                                if (checkTarget.contains(targetSquare))
                                    rook.setActivated(true);
                            }
                            checkTarget = square.getPiece().checkPossiblePos(board);
                            if (checkTarget.contains(targetSquare)){
                                Piece p = square.getPiece();
                                square.getPiece().userMove(board, userPieceSquare, userPieceTargetSquare);
                                if (king.checkProbeBlack(board, king)) {
                                    square.setPiece(p);
                                    square.setOccupied(true);
                                    assert targetSquare != null;
                                    targetSquare.setOccupied(false);
                                    targetSquare.setPiece(null);
                                }
                            }
                            return true;
                        }
                    } else if (userPieceSquare.equals(square.getSquareName())) {
                        if (square.getPiece() instanceof King king) {
                            checkTarget = square.getPiece().checkPossiblePos(board);
                            if (checkTarget.contains(targetSquare))
                                king.setActivated(true);
                        } else if (square.getPiece() instanceof Rook rook) {
                            checkTarget = square.getPiece().checkPossiblePos(board);
                            if (checkTarget.contains(targetSquare))
                                rook.setActivated(true);
                        }
                        checkTarget = square.getPiece().checkPossiblePos(board);
                        Piece p = square.getPiece();
                        if (checkTarget.contains(targetSquare))
                            square.getPiece().userMove(board, userPieceSquare, userPieceTargetSquare);
                        for (Piece piece : playerTwoPieces) {
                            if (piece instanceof King king) {
                                if (king.checkProbeBlack(board, king)) {
                                    square.setPiece(p);
                                    square.setOccupied(true);
                                    assert targetSquare != null;
                                    targetSquare.setOccupied(false);
                                    targetSquare.setPiece(null);
                                }
                            }
                        }
                        return true;
                    }
                }
            }
        }
        return true;
    }

    private static void testgame(Board board) throws BoardException {
        ArrayList<Piece> playerOnePieces = board.getPlayers().get(0).getPieces();
        ArrayList<Piece> playerTwoPieces = board.getPlayers().get(1).getPieces();
        System.out.println();
        Collections.reverse(playerOnePieces);
        playerOnePieces.stream().map(Piece::getPieceName).forEach(System.out::print);
        int sup1 = playerOnePieces.stream().mapToInt(Piece::getPieceValue).sum();
        Collections.reverse(playerOnePieces);
        System.out.println(": " + sup1);
        playerTwoPieces.stream().map(Piece::getPieceName).forEach(System.out::print);
        int sup2 = playerTwoPieces.stream().mapToInt(Piece::getPieceValue).sum();
        System.out.println(": " + sup2);
        board.print();
    }

    //            TODO AI moves debugging etc - some AI shenanigens
    //            Random random = new Random();
    //            int move;
    //            move = random.nextInt(0, playerTwoPieces.size() -1);
    //            move = random.nextInt(0, playerTwoPieces.size() -1);
    //            playerTwoPieces.get(move).move(chessBoard);
    //            System.out.println();
    //            playerOnePieces.stream().map(Piece::getPieceName).forEach(System.out::print);
    //            int sump1 = playerOnePieces.stream().mapToInt(Piece::getPieceValue).sum();
    //            System.out.println(": " + sump1);
    //            playerTwoPieces.stream().map(Piece::getPieceName).forEach(System.out::print);
    //            int sump2 = playerTwoPieces.stream().mapToInt(Piece::getPieceValue).sum();
    //            System.out.println(": " + sump2);
    //            chessBoard.print();
}


