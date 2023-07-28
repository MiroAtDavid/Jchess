package model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Objects;



public class King extends Piece{

    private boolean activated;

    // Konstruktor -----------------------------------------------------------------------------------------------------

    public King(String pieceName, int pieceValue, Square currentPositionSquare, ImageView imageView, Image image) throws BoardException {
        super(pieceName, pieceValue, currentPositionSquare, imageView, image);
        setActivated(false);
    }
    public King(String pieceName, int pieceValue, Square currentPositionSquare, String color) throws BoardException {
        super(pieceName, pieceValue,currentPositionSquare, color);
        setActivated(false);
    }

    // Getter ----------------------------------------------------------------------------------------------------------
    public boolean isActivated() {
        return activated;
    }

    // Setter-----------------------------------------------------------------------------------------------------------
    public void setActivated(boolean activated) { // TODO if king has moved set activated to true
        this.activated = activated;
    }

    // Methods ---------------------------------------------------------------------------------------------------------
    @Override
    public ArrayList<Square> possiblePos() {
        ArrayList<Square> possibleMoves = new ArrayList<>();
        for (Square square : Board.getSquares()){
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
    public void castleWhiteKingSide() throws BoardException {
        Rook rook = (Rook) Board.getSquares().get(56).getPiece();
        if (!isActivated() && !checkProbeCastleWhiteKingSide() && !rook.isActivated() && !Board.getSquares().get(57).isOccupied()) {
            Rook.relocateRookCastleWhiteKingSide();
            userMoveCastleWhiteKingSide();
        }
    }
    private boolean checkProbeCastleWhiteKingSide() throws BoardException {
        for (Piece piece : Player.getPieces()){
            if (piece.getColor().equals("black")) {
                for (Square square : piece.possiblePos()) {
                    if (square.getSquareName().equals("e1") ||
                            square.getSquareName().equals("f1") ||
                            square.getSquareName().equals("g1"))
                        return true;
                }
            }
        }
        return false;
    }
    private void userMoveCastleWhiteKingSide() throws BoardException {
        Piece king = Board.getSquares().get(59).getPiece();
        Board.getSquares().get(59).setOccupied(false);
        Board.getSquares().get(59).removePiece(king);
        king.setCurrentPositionSquare(Board.getSquares().get(57));
        Board.getSquares().get(57).setPiece(king);
        Board.recordMoves(king, Board.getSquares().get(59), Board.getSquares().get(57));
    }

    // Castle White Queen Side -----------------------------------------------------------------------------------------
    public void castleWhiteQueenSide() throws BoardException {
        Rook rook = (Rook) Board.getSquares().get(63).getPiece();
        if (!Board.getSquares().get(61).isOccupied() && !rook.isActivated() && !isActivated() && !checkProbeCastleWhiteQueenSide()) {
            Rook.relocateRookCastleWhiteQueenSide();
            userMoveCastleQueenSide();
        }
    }
    private boolean checkProbeCastleWhiteQueenSide() throws BoardException {
        for (Piece piece : Player.getPieces()){
            if (piece.getColor().equals("black")) {
                for (Square square : piece.possiblePos()) {
                    if (square.getSquareName().equals("e1") ||
                            square.getSquareName().equals("d1") ||
                            square.getSquareName().equals("c1"))
                        return true;
                }
            }
        }
        return false;
    }
    private void userMoveCastleQueenSide() throws BoardException {
        Piece king = Board.getSquares().get(59).getPiece();
        this.getCurrentPositionSquare().setOccupied(false);
        setCurrentPositionSquare(Board.getSquares().get(61));
        Board.getSquares().get(61).setPiece(this);
        Board.recordMoves(king, Board.getSquares().get(59), Board.getSquares().get(61));


    }

    // Castle Black King Side ------------------------------------------------------------------------------------------
    public void castleBlackKingSide() throws BoardException {
        Rook rook = (Rook) Board.getSquares().get(0).getPiece();
        if (!Board.getSquares().get(2).isOccupied() && !isActivated() && !rook.isActivated() && !checkProbeCastleBlackKingSide()) {
            Rook.relocateRookCastleBlackKingSide();
            userMoveCastleBlackKingSide();
        }
    }
    private boolean checkProbeCastleBlackKingSide() throws BoardException {
        for (Piece piece : Player.getPieces()){
            if (piece.getColor().equals("white")) {
                for (Square square : piece.possiblePos()) {
                    if (square.getSquareName().equals("e8") ||
                            square.getSquareName().equals("f8") ||
                            square.getSquareName().equals("g8"))
                        return true;
                }
            }
        }
        return false;
    }
    private void userMoveCastleBlackKingSide() throws BoardException {
        Piece king = Board.getSquares().get(3).getPiece();
        this.getCurrentPositionSquare().setOccupied(false);
        setCurrentPositionSquare(Board.getSquares().get(1));
        Board.getSquares().get(1).setPiece(this);
        Board.recordMoves(king, Board.getSquares().get(3), Board.getSquares().get(1));



    }

    // Castle Black Queen Side -----------------------------------------------------------------------------------------
    public void castleBlackQueenSide() throws BoardException {
        Rook rook = (Rook) Board.getSquares().get(7).getPiece();
        if (!Board.getSquares().get(5).isOccupied() && !isActivated() && !rook.isActivated() && !checkProbeCastleBlackQueenSide()) {
            Rook.relocateRookCastleBlackQueenSide();
            userMoveCastleBlackQueenSide();
        }
    }
    private boolean checkProbeCastleBlackQueenSide() throws BoardException {
        for (Piece piece : Player.getPieces()){
            if (piece.getColor().equals("white")) {
                for (Square square : piece.possiblePos()) {
                    if (square.getSquareName().equals("e8") ||
                            square.getSquareName().equals("d8") ||
                            square.getSquareName().equals("c8"))
                        return true;
                }
            }
        }
        return false;
    }
    private void userMoveCastleBlackQueenSide() throws BoardException {
        Piece king = Board.getSquares().get(3).getPiece();
        this.getCurrentPositionSquare().setOccupied(false);
        setCurrentPositionSquare(Board.getSquares().get(5));
        Board.getSquares().get(5).setPiece(this);
        Board.recordMoves(king, Board.getSquares().get(3), Board.getSquares().get(5));


    }

    // Check Probe -----------------------------------------------------------------------------------------------------
    public boolean checkProbeWhite(Piece king) throws BoardException {
        for (Square s : Board.getSquares()){
            if (s.getPiece() != null && s.getPiece().getColor().equals("black")) {
                for (Square square : s.getPiece().possiblePos()) {
                    if (square.getSquareName().equals(king.getCurrentPositionSquare().getSquareName()))
                        return true;
                }
            }
        }
        return false;
    }
    public boolean checkProbeBlack(Piece king) throws BoardException {
        for (Square s :Board.getSquares()){
            if (s.getPiece() != null && s.getPiece().getColor().equals("white")) {
                for (Square square : s.getPiece().possiblePos()) {
                    if (square.getSquareName().equals(king.getCurrentPositionSquare().getSquareName()))
                        return true;
               }
            }
        }
        return false;
    }

}
