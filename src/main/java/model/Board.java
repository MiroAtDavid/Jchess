package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.*;

// TODO check (as method implemented, however 100% complete therefore game logic doesn't apply, checkmate, three moves repeat rule, 50 moves rule
// TODO .....

public class Board {

    private Player playerOne;
    private Player playertwo;
    private static ArrayList<Square> squares;
    static HashMap<Piece, ArrayList<Square>> recordMove = new HashMap<>();
    // Konstruktor -----------------------------------------------------------------------------------------------------

    public Board(Player playerOne, Player playertwo){
        setPlayertwo(playertwo);
        setPlayerOne(playerOne);
        squares = new ArrayList<>();

    }
    // Getter ---- -----------------------------------------------------------------------------------------------------

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayertwo() {
        return playertwo;
    }

    public static ArrayList<Square> getSquares(){
        return squares;
    }

    // Setter ----------------------------------------------------------------------------------------------------------

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public void setPlayertwo(Player playertwo) {
        this.playertwo = playertwo;
    }

    // Other Methods ---------------------------------------------------------------------------------------------------
    public Square addSquare(String squareName, int row, int col, Color color) throws BoardException {
        Square newSquare = new Square(squareName, row, col, color , new Rectangle(90,90));
        squares.add(newSquare);
        return newSquare;
    }
    public static HashMap<Piece, ArrayList<Square>> recordMoves(Piece piece, Square sourcePosition, Square targetPosition){
        recordMove.clear();
        ArrayList<Square> sqrs = new ArrayList<>();
        sqrs.add(sourcePosition);
        sqrs.add(targetPosition);
        recordMove.put(piece, sqrs);
        StringBuffer sb = new StringBuffer();
        sb.append("Recorded Move: ");
        sb.append(piece.getPieceName()).append(" ").append(sourcePosition.getSquareName()).append(" ").append(targetPosition.getSquareName());
        System.out.println(sb);
        return recordMove;
    }

    // toString --------------------------------------------------------------------------------------------------------
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n");
        sb.append("---------------------------------\n");
        for (int row = 8; row > 0; row --){
            for (int col = 1; col < 9; col++) {
                for (Square s : Board.getSquares()) {
                    if (s.getRow() == row && s.getCol() == col) {
                        if (!s.isOccupied())
                            sb.append("| " + "  ");
                        else if (s.getPiece().getColor().equals("white"))
                            sb.append("| ").append(s.getPiece().getPieceName()).append(" ");
                        else if (s.getPiece().getColor().equals("black"))
                            sb.append("| ").append(s.getPiece().getPieceName()).append(" ");
                    }
                }
            }
            sb.append("|");
            sb.append("\n---------------------------------\n");
        }

        return sb.toString();
    }
    public void print(){
        System.out.println(this);
    }
}
