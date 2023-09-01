package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Objects;


public class King extends Piece {

    private boolean activated;

    // Konstruktor -----------------------------------------------------------------------------------------------------
    public King(String pieceName, int pieceValue, Square currentPositionSquare, ImageView imageView, Image image) throws BoardException {
        super(pieceName, pieceValue, currentPositionSquare, imageView, image);
        setActivated(false);
    }

    public King(String pieceName, int pieceValue, Square currentPositionSquare, String color) throws BoardException {
        super(pieceName, pieceValue, currentPositionSquare, color);
        setActivated(false);
    }

    // Getter ----------------------------------------------------------------------------------------------------------
    public boolean isActivated() {
        return activated;
    }

    // Setter-----------------------------------------------------------------------------------------------------------
    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    // Methods ---------------------------------------------------------------------------------------------------------
    @Override
    public ArrayList<Square> possiblePos(Board board) throws BoardException {
        ArrayList<Square> possibleMoves = new ArrayList<>();
        for (Square square : board.getSquares()) {
            for (int i = 1; i <= 1; i++) {
                if (!square.isOccupied()) {
                    if (square.getRow() == getCurrentPositionSquare().getRow() && square.getCol() == getCurrentPositionSquare().getCol())
                        continue;
                    if (square.getRow() == getCurrentPositionSquare().getRow() + i && square.getCol() == getCurrentPositionSquare().getCol() + i)
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() + i && square.getCol() == getCurrentPositionSquare().getCol() - i)
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() - i && square.getCol() == getCurrentPositionSquare().getCol() - i)
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() - i && square.getCol() == getCurrentPositionSquare().getCol() + i)
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() + i && square.getCol() == getCurrentPositionSquare().getCol())
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() - i && square.getCol() == getCurrentPositionSquare().getCol())
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() && square.getCol() == getCurrentPositionSquare().getCol() + i)
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() && square.getCol() == getCurrentPositionSquare().getCol() - i)
                        possibleMoves.add(square);
                } else if (square.isOccupied() && !square.getPiece().getColor().equals(this.getColor())) {
                    if (square.getRow() == getCurrentPositionSquare().getRow() + i && square.getCol() == getCurrentPositionSquare().getCol() + i)
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() + i && square.getCol() == getCurrentPositionSquare().getCol() - i)
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() - i && square.getCol() == getCurrentPositionSquare().getCol() - i)
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() - i && square.getCol() == getCurrentPositionSquare().getCol() + i)
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() + i && square.getCol() == getCurrentPositionSquare().getCol())
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() - i && square.getCol() == getCurrentPositionSquare().getCol())
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() && square.getCol() == getCurrentPositionSquare().getCol() + i)
                        possibleMoves.add(square);
                    if (square.getRow() == getCurrentPositionSquare().getRow() && square.getCol() == getCurrentPositionSquare().getCol() - i)
                        possibleMoves.add(square);
                }
            }
        }
        possibleMoves.removeIf(Objects::isNull);
        return possibleMoves;
    }

    // Castle White King Side ------------------------------------------------------------------------------------------
    public void castleWhiteKingSide(Board board) throws BoardException {
        Rook rook = (Rook) board.getSquares().get(56).getPiece();
        if (!isActivated() && !checkProbeCastleWhiteKingSide(board) && !rook.isActivated() && !board.getSquares().get(57).isOccupied()) {
            Rook.relocateRookCastleWhiteKingSide(board);
            userMoveCastleWhiteKingSide(board);
        }
    }

    private boolean checkProbeCastleWhiteKingSide(Board board) throws BoardException {
        for (Player player : board.getPlayers()) {
            for (Piece piece : player.getPieces()) {
                if (piece.getColor().equals("black")) {
                    for (Square square : piece.possiblePos(board)) {
                        if (square.getSquareName().equals("e1") ||
                                square.getSquareName().equals("f1") ||
                                square.getSquareName().equals("g1"))
                            return true;
                    }
                }
            }
        }
        return false;
    }

    private void userMoveCastleWhiteKingSide(Board board) throws BoardException {
        Piece king = board.getSquares().get(59).getPiece();
        board.getSquares().get(59).setOccupied(false);
        board.getSquares().get(59).removePiece(king);
        king.setCurrentPositionSquare(board.getSquares().get(57));
        board.getSquares().get(57).setPiece(king);
        board.recordMoves(king, board.getSquares().get(59), board.getSquares().get(57));
    }

    // Castle White Queen Side -----------------------------------------------------------------------------------------
    public void castleWhiteQueenSide(Board board) throws BoardException {
        Rook rook = (Rook) board.getSquares().get(63).getPiece();
        if (!board.getSquares().get(61).isOccupied() && !rook.isActivated() && !isActivated() && !checkProbeCastleWhiteQueenSide(board)) {
            Rook.relocateRookCastleWhiteQueenSide(board);
            userMoveCastleQueenSide(board);
        }
    }

    private boolean checkProbeCastleWhiteQueenSide(Board board) throws BoardException {
        for (Player player : board.getPlayers()) {
            for (Piece piece : player.getPieces()) {
                if (piece.getColor().equals("black")) {
                    for (Square square : piece.possiblePos(board)) {
                        if (square.getSquareName().equals("e1") ||
                                square.getSquareName().equals("d1") ||
                                square.getSquareName().equals("c1"))
                            return true;
                    }
                }
            }
        }
        return false;
    }

    private void userMoveCastleQueenSide(Board board) throws BoardException {
        Piece king = board.getSquares().get(59).getPiece();
        this.getCurrentPositionSquare().setOccupied(false);
        setCurrentPositionSquare(board.getSquares().get(61));
        board.getSquares().get(61).setPiece(this);
        board.recordMoves(king, board.getSquares().get(59), board.getSquares().get(61));
    }

    // Castle Black King Side ------------------------------------------------------------------------------------------
    public void castleBlackKingSide(Board board) throws BoardException {
        Rook rook = (Rook) board.getSquares().get(0).getPiece();
        if (!board.getSquares().get(2).isOccupied() && !isActivated() && !rook.isActivated() && !checkProbeCastleBlackKingSide(board)) {
            Rook.relocateRookCastleBlackKingSide(board);
            userMoveCastleBlackKingSide(board);
        }
    }

    private boolean checkProbeCastleBlackKingSide(Board board) throws BoardException {
        for (Player player : board.getPlayers()) {
            for (Piece piece : player.getPieces()) {
                if (piece.getColor().equals("white")) {
                    for (Square square : piece.possiblePos(board)) {
                        if (square.getSquareName().equals("e8") ||
                                square.getSquareName().equals("f8") ||
                                square.getSquareName().equals("g8"))
                            return true;
                    }
                }
            }
        }
        return false;
    }

    private void userMoveCastleBlackKingSide(Board board) throws BoardException {
        Piece king = board.getSquares().get(3).getPiece();
        this.getCurrentPositionSquare().setOccupied(false);
        setCurrentPositionSquare(board.getSquares().get(1));
        board.getSquares().get(1).setPiece(this);
        board.recordMoves(king, board.getSquares().get(3), board.getSquares().get(1));
    }

    // Castle Black Queen Side -----------------------------------------------------------------------------------------
    public void castleBlackQueenSide(Board board) throws BoardException {
        Rook rook = (Rook) board.getSquares().get(7).getPiece();
        if (!board.getSquares().get(5).isOccupied() && !isActivated() && !rook.isActivated() && !checkProbeCastleBlackQueenSide(board)) {
            Rook.relocateRookCastleBlackQueenSide(board);
            userMoveCastleBlackQueenSide(board);
        }
    }

    private boolean checkProbeCastleBlackQueenSide(Board board) throws BoardException {
        for (Player player : board.getPlayers()) {
            for (Piece piece : player.getPieces()) {
                if (piece.getColor().equals("white")) {
                    for (Square square : piece.possiblePos(board)) {
                        if (square.getSquareName().equals("e8") ||
                                square.getSquareName().equals("d8") ||
                                square.getSquareName().equals("c8"))
                            return true;
                    }
                }
            }
        }
        return false;
    }

    private void userMoveCastleBlackQueenSide(Board board) throws BoardException {
        Piece king = board.getSquares().get(3).getPiece();
        this.getCurrentPositionSquare().setOccupied(false);
        setCurrentPositionSquare(board.getSquares().get(5));
        board.getSquares().get(5).setPiece(this);
        board.recordMoves(king, board.getSquares().get(3), board.getSquares().get(5));
    }

    // Check Probe -----------------------------------------------------------------------------------------------------
    public boolean checkProbeWhite(Board board, Piece king) throws BoardException {
        for (Piece piece : board.getPlayers().get(1).getPieces()){
            for (Square s : piece.checkPossiblePos(board)){
                for (Piece p : board.getPlayers().get(0).getPieces()){
                    if (p.getPieceValue() == 100 && s.getSquareName().equals(p.getCurrentPositionSquare().getSquareName())) {
                        board.getPlayers().get(0).setCheck(true);
                        return true;
                    }
                }
            }
        }
        board.getPlayers().get(0).setCheck(false);
        return false;
    }

    public boolean checkProbeBlack(Board board, Piece king) throws BoardException {
        for (Piece piece : board.getPlayers().get(0).getPieces()){
            for (Square s : piece.checkPossiblePos(board)){
                for (Piece p : board.getPlayers().get(1).getPieces()){
                    if (p.getPieceValue() == 100 && s.getSquareName().equals(p.getCurrentPositionSquare().getSquareName())) {
                        board.getPlayers().get(1).setCheck(true);
                        return true;
                    }
                }
            }
        }
        board.getPlayers().get(1).setCheck(false);
        return false;
    }

    // Check Mate Probe ------------------------------------------------------------------------------------------------
    public void checkMateProbeWhite(Board board, Piece king) throws BoardException {
        boolean busy;
        Piece p = null;
        outerloop:
        for (Piece piece : board.getPlayers().get(0).getPieces()){
            for (Square square : piece.possiblePos(board)){
                Square current = piece.getCurrentPositionSquare();
                busy = false;
                if (square.isOccupied()){
                    busy = true;
                    p = square.getPiece();
                    square.removePiece(p);
                    square.setOccupied(false);
                    p.setCurrentPositionSquare(new Square("rs", -9, -9, Color.valueOf("sienna"), new Rectangle(0,0)));
                }
                current.removePiece(piece);
                current.setOccupied(false);
                square.setPiece(piece);
                square.setOccupied(true);
                piece.setCurrentPositionSquare(square);
                checkProbeWhite(board, king);
                if (!board.getPlayers().get(0).isCheck()) {
                    board.getPlayers().get(0).setCheckMate(false);
                    square.removePiece(piece);
                    square.setOccupied(false);
                    current.setPiece(piece);
                    current.setOccupied(true);
                    piece.setCurrentPositionSquare(current);
                    assert p != null;
                    if (busy){
                        square.setPiece(p);
                        square.setOccupied(true);
                        p.setCurrentPositionSquare(square);
                    }
                    break outerloop;
                } else {
                    board.getPlayers().get(0).setCheckMate(true);
                    //System.out.println("Player One is checkmate!");
                    square.setPiece(null);
                    square.setOccupied(false);
                    current.setPiece(piece);
                    current.setOccupied(true);
                    piece.setCurrentPositionSquare(current);
                    assert p != null;
                    if (busy){
                        square.setPiece(p);
                        square.setOccupied(true);
                        p.setCurrentPositionSquare(square);
                    }
                }
            }
        }
    }

    public void checkMateProbeBlack(Board board, Piece king) throws BoardException {
        boolean busy;
        Piece p = null;
        outerloop:
        for (Piece piece : board.getPlayers().get(1).getPieces()){
            for (Square square : piece.possiblePos(board)){
                Square current = piece.getCurrentPositionSquare();
                busy = false;
                if (square.isOccupied()){
                    busy = true;
                    p = square.getPiece();
                    square.removePiece(p);
                    square.setOccupied(false);
                    p.setCurrentPositionSquare(new Square("rs", -9, -9, Color.valueOf("sienna"), new Rectangle(0,0)));
                }
                current.removePiece(piece);
                current.setOccupied(false);
                square.setPiece(piece);
                square.setOccupied(true);
                piece.setCurrentPositionSquare(square);
                checkProbeBlack(board, king);
                if (!board.getPlayers().get(1).isCheck()) {
                    board.getPlayers().get(1).setCheckMate(false);
                    square.removePiece(piece);
                    square.setOccupied(false);
                    current.setPiece(piece);
                    current.setOccupied(true);
                    piece.setCurrentPositionSquare(current);
                    assert p != null;
                    if (busy){
                        square.setPiece(p);
                        square.setOccupied(true);
                        p.setCurrentPositionSquare(square);
                    }
                    break outerloop;
                } else {
                    board.getPlayers().get(1).setCheckMate(true);
                    //System.out.println("Player Two is checkmate!");
                    square.setPiece(null);
                    square.setOccupied(false);
                    current.setPiece(piece);
                    current.setOccupied(true);
                    piece.setCurrentPositionSquare(current);
                    assert p != null;
                    if (busy){
                        square.setPiece(p);
                        square.setOccupied(true);
                        p.setCurrentPositionSquare(square);
                    }
                }
            }
        }
    }
}