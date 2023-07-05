package model;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;


public class TestGraph {



    public static void main(String[] args) {
        try {
            testGraphEins();
        } catch (BoardException e) {
            throw new RuntimeException(e);
        }

    }

    public static Board testGraphEins() throws BoardException {

        Board testBoard = new Board(true);

        Square H8 = testBoard.knotenHinzufuegen("H8", 8, 8, Color.valueOf("sienna"));
        Square G8 = testBoard.knotenHinzufuegen("G8", 8, 7, Color.valueOf("beige"));
        Square F8 = testBoard.knotenHinzufuegen("F8", 8, 6, Color.valueOf("sienna"));
        Square E8 = testBoard.knotenHinzufuegen("E8", 8, 5, Color.valueOf("beige"));
        Square D8 = testBoard.knotenHinzufuegen("D8", 8, 4, Color.valueOf("sienna"));
        Square C8 = testBoard.knotenHinzufuegen("C8", 8, 3, Color.valueOf("beige"));
        Square B8 = testBoard.knotenHinzufuegen("B8", 8, 2, Color.valueOf("sienna"));
        Square A8 = testBoard.knotenHinzufuegen("A8", 8, 1, Color.valueOf("beige"));

        Square H7 = testBoard.knotenHinzufuegen("H7", 7, 8, Color.valueOf("beige"));
        Square G7 = testBoard.knotenHinzufuegen("G7", 7, 7, Color.valueOf("sienna"));
        Square F7 = testBoard.knotenHinzufuegen("F7", 7, 6, Color.valueOf("beige"));
        Square E7 = testBoard.knotenHinzufuegen("E7", 7, 5, Color.valueOf("sienna"));
        Square D7 = testBoard.knotenHinzufuegen("D7", 7, 4, Color.valueOf("beige"));
        Square C7 = testBoard.knotenHinzufuegen("C7", 7, 3, Color.valueOf("sienna"));
        Square B7 = testBoard.knotenHinzufuegen("B7", 7, 2, Color.valueOf("beige"));
        Square A7 = testBoard.knotenHinzufuegen("A7", 7, 1, Color.valueOf("sienna"));

        Square H6 = testBoard.knotenHinzufuegen("H6", 6, 8, Color.valueOf("sienna"));
        Square G6 = testBoard.knotenHinzufuegen("G6", 6, 7, Color.valueOf("beige"));
        Square F6 = testBoard.knotenHinzufuegen("F6", 6, 6, Color.valueOf("sienna"));
        Square E6 = testBoard.knotenHinzufuegen("E6", 6, 5, Color.valueOf("beige"));
        Square D6 = testBoard.knotenHinzufuegen("D6", 6, 4, Color.valueOf("sienna"));
        Square C6 = testBoard.knotenHinzufuegen("C6", 6, 3, Color.valueOf("beige"));
        Square B6 = testBoard.knotenHinzufuegen("B6", 6, 2, Color.valueOf("sienna"));
        Square A6 = testBoard.knotenHinzufuegen("A6", 6, 1, Color.valueOf("beige"));

        Square H5 = testBoard.knotenHinzufuegen("H5", 5, 8, Color.valueOf("beige"));
        Square G5 = testBoard.knotenHinzufuegen("G5", 5, 7, Color.valueOf("sienna"));
        Square F5 = testBoard.knotenHinzufuegen("F5", 5, 6, Color.valueOf("beige"));
        Square E5 = testBoard.knotenHinzufuegen("E5", 5, 5, Color.valueOf("sienna"));
        Square D5 = testBoard.knotenHinzufuegen("D5", 5, 4, Color.valueOf("beige"));
        Square C5 = testBoard.knotenHinzufuegen("C5", 5, 3, Color.valueOf("sienna"));
        Square B5 = testBoard.knotenHinzufuegen("B5", 5, 2, Color.valueOf("beige"));
        Square A5 = testBoard.knotenHinzufuegen("A5", 5, 1, Color.valueOf("sienna"));

        Square H4 = testBoard.knotenHinzufuegen("H4", 4, 8, Color.valueOf("sienna"));
        Square G4 = testBoard.knotenHinzufuegen("G4", 4, 7, Color.valueOf("beige"));
        Square F4 = testBoard.knotenHinzufuegen("F4", 4, 6, Color.valueOf("sienna"));
        Square E4 = testBoard.knotenHinzufuegen("E4", 4, 5, Color.valueOf("beige"));
        Square D4 = testBoard.knotenHinzufuegen("D4", 4, 4, Color.valueOf("sienna"));
        Square C4 = testBoard.knotenHinzufuegen("C4", 4, 3, Color.valueOf("beige"));
        Square B4 = testBoard.knotenHinzufuegen("B4", 4, 2, Color.valueOf("sienna"));
        Square A4 = testBoard.knotenHinzufuegen("A4", 4, 1, Color.valueOf("beige"));

        Square H3 = testBoard.knotenHinzufuegen("H3", 3, 8, Color.valueOf("beige"));
        Square G3 = testBoard.knotenHinzufuegen("G3", 3, 7, Color.valueOf("sienna"));
        Square F3 = testBoard.knotenHinzufuegen("F3", 3, 6, Color.valueOf("beige"));
        Square E3 = testBoard.knotenHinzufuegen("E3", 3, 5, Color.valueOf("sienna"));
        Square D3 = testBoard.knotenHinzufuegen("D3", 3, 4, Color.valueOf("beige"));
        Square C3 = testBoard.knotenHinzufuegen("C3", 3, 3, Color.valueOf("sienna"));
        Square B3 = testBoard.knotenHinzufuegen("B3", 3, 2, Color.valueOf("beige"));
        Square A3 = testBoard.knotenHinzufuegen("A3", 3, 1, Color.valueOf("sienna"));

        Square H2 = testBoard.knotenHinzufuegen("H2", 2, 8, Color.valueOf("sienna"));
        Square G2 = testBoard.knotenHinzufuegen("G2", 2, 7, Color.valueOf("beige"));
        Square F2 = testBoard.knotenHinzufuegen("F2", 2, 6, Color.valueOf("sienna"));
        Square E2 = testBoard.knotenHinzufuegen("E2", 2, 5, Color.valueOf("beige"));
        Square D2 = testBoard.knotenHinzufuegen("D2", 2, 4, Color.valueOf("sienna"));
        Square C2 = testBoard.knotenHinzufuegen("C2", 2, 3, Color.valueOf("beige"));
        Square B2 = testBoard.knotenHinzufuegen("B2", 2, 2, Color.valueOf("sienna"));
        Square A2 = testBoard.knotenHinzufuegen("A2", 2, 1, Color.valueOf("beige"));

        Square H1 = testBoard.knotenHinzufuegen("H1", 1, 8, Color.valueOf("beige"));
        Square G1 = testBoard.knotenHinzufuegen("G1", 1, 7, Color.valueOf("sienna"));
        Square F1 = testBoard.knotenHinzufuegen("F1", 1, 6, Color.valueOf("beige"));
        Square E1 = testBoard.knotenHinzufuegen("E1", 1, 5, Color.valueOf("sienna"));
        Square D1 = testBoard.knotenHinzufuegen("D1", 1, 4, Color.valueOf("beige"));
        Square C1 = testBoard.knotenHinzufuegen("C1", 1, 3, Color.valueOf("sienna"));
        Square B1 = testBoard.knotenHinzufuegen("B1", 1, 2, Color.valueOf("beige"));
        Square A1 = testBoard.knotenHinzufuegen("A1", 1, 1, Color.valueOf("sienna"));


        ArrayList<Piece> playerOnePieces = new ArrayList<>();
        ArrayList<Piece> playerTwoPieces = new ArrayList<>();

        Player playerOne = new Player("PlayerOne", playerOnePieces, 0, "White");
        Player playerTwo = new Player("PlayerTwp", playerTwoPieces, 0, "Black");

//        playerOne.setPieces(playerOnePieces);
//        playerTwo.setPieces(playerTwoPieces);


        Knight knightw = new Knight("Knight",
                3,
                Board.getSquares().get(62)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("knight.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("knight.png")))
        );

        Knight knightw2 = new Knight("Knight",
                3,
                Board.getSquares().get(57)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("knight.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("knight.png")))
        );

        Bishop bishopw = new Bishop("Bishop",
                3,
                Board.getSquares().get(61)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bishop.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bishop.png")))
        );
        Bishop bishopw2 = new Bishop("Bishop",
                3,
                Board.getSquares().get(58)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bishop.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bishop.png")))
        );
        Rook rookw = new Rook("Rook",
                4,
                Board.getSquares().get(63)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("rook.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("rook.png")))
        );
        Rook rookw2 = new Rook("Rook",
                4,
                Board.getSquares().get(56)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("rook.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("rook.png")))
        );
        Qeen queenw = new Qeen("Qeen",
                8,
                Board.getSquares().get(60)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("queen.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("queen.png")))
        );
        King kingw = new King("King",
                100,
                Board.getSquares().get(59)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("king.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("king.png")))
        );
        Pawn pawnW1 = new Pawn("Pawn",
                1,
                Board.getSquares().get(55)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("pawn.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("pawn.png")))
        );
        Pawn pawnW2 = new Pawn("Pawn",
                1,
                Board.getSquares().get(54)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("pawn.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("pawn.png")))
        );
        Pawn pawnW3 = new Pawn("Pawn",
                1,
                Board.getSquares().get(53)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("pawn.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("pawn.png")))
        );
        Pawn pawnW4 = new Pawn("Pawn",
                1,
                Board.getSquares().get(52)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("pawn.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("pawn.png")))
        );
        Pawn pawnW5 = new Pawn("Pawn",
                1,
                Board.getSquares().get(51)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("pawn.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("pawn.png")))
        );
        Pawn pawnW6 = new Pawn("Pawn",
                1,
                Board.getSquares().get(50)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("pawn.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("pawn.png")))
        );
        Pawn pawnW7 = new Pawn("Pawn",
                1,
                Board.getSquares().get(49)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("pawn.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("pawn.png")))
        );
        Pawn pawnW8 = new Pawn("Pawn",
                1,
                Board.getSquares().get(48)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("pawn.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("pawn.png")))
        );

        Knight knightB = new Knight("Black Knight",
                3,
                Board.getSquares().get(6)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bknight.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bknight.png")))
        );
        Knight knightB2 = new Knight("Black Knight",
                3,
                Board.getSquares().get(1)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bknight.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bknight.png")))
        );
        Bishop bishopB = new Bishop("Black Bishop",
                3,
                Board.getSquares().get(5)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bbishop.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bbishop.png")))
        );
        Bishop bishopB2 = new Bishop("Black Bishop",
                3,
                Board.getSquares().get(2)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bbishop.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bbishop.png")))
        );
        Rook rookB = new Rook("Black Rook",
                4,
                Board.getSquares().get(7)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("brook.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bbishop.png")))
        );
        Rook rookB2 = new Rook("Black Rook",
                4,
                Board.getSquares().get(0)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("brook.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bbishop.png")))
        );
        Qeen queenB = new Qeen("Black Qeen",
                8,
                Board.getSquares().get(4)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bqueen.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bbishop.png")))
        );
        King kingB = new King("Black King",
                100,
                Board.getSquares().get(3)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bking.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bking.png")))
        );
        Pawn pawnB1 = new Pawn("Black Pawn",
                1,
                Board.getSquares().get(15)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bpawn.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bpawn.png")))
        );

        Pawn pawnB2 = new Pawn("Black Pawn",
                1,
                Board.getSquares().get(14)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bpawn.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bpawn.png")))
        );
        Pawn pawnB3 = new Pawn("Black Pawn",
                1,
                Board.getSquares().get(13)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bpawn.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bpawn.png")))
        );
        Pawn pawnB4 = new Pawn("Black Pawn",
                1,
                Board.getSquares().get(12)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bpawn.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bpawn.png")))
        );
        Pawn pawnB5 = new Pawn("Black Pawn",
                1,
                Board.getSquares().get(11)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bpawn.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bpawn.png")))
        );
        Pawn pawnB6 = new Pawn("Black Pawn",
                1,
                Board.getSquares().get(10)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bpawn.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bpawn.png")))
        );
        Pawn pawnB7 = new Pawn("Black Pawn",
                1,
                Board.getSquares().get(9)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bpawn.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bpawn.png")))
        );
        Pawn pawnB8 = new Pawn("Black Pawn",
                1,
                Board.getSquares().get(8)
//                new ImageView(new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bpawn.png")))),
//                new Image(Objects.requireNonNull(TestGraph.class.getResourceAsStream("bpawn.png")))
        );

        playerOnePieces.add(knightw2);
        playerOnePieces.add(knightw);
        playerOnePieces.add(bishopw);
        playerOnePieces.add(bishopw2);
        playerOnePieces.add(rookw);
        playerOnePieces.add(rookw2);
        playerOnePieces.add(queenw);
        playerOnePieces.add(kingw);
        playerOnePieces.add(pawnW1);
        playerOnePieces.add(pawnW2);
        playerOnePieces.add(pawnW3);
        playerOnePieces.add(pawnW4);
        playerOnePieces.add(pawnW5);
        playerOnePieces.add(pawnW6);
        playerOnePieces.add(pawnW7);
        playerOnePieces.add(pawnW8);


        playerTwoPieces.add(knightB);
        playerTwoPieces.add(knightB2);
        playerTwoPieces.add(bishopB);
        playerTwoPieces.add(bishopB2);
        playerTwoPieces.add(rookB);
        playerTwoPieces.add(rookB2);
        playerTwoPieces.add(queenB);
        playerTwoPieces.add(kingB);
        playerTwoPieces.add(pawnB1);
        playerTwoPieces.add(pawnB2);
        playerTwoPieces.add(pawnB3);
        playerTwoPieces.add(pawnB4);
        playerTwoPieces.add(pawnB5);
        playerTwoPieces.add(pawnB6);
        playerTwoPieces.add(pawnB7);
        playerTwoPieces.add(pawnB8);

//        Random randomWhite = new Random();
//        Random randomBlack = new Random();
//
//        int counter = 0;
//        Piece movingPiece;
//        while (counter < 32) {
//                int randomMoveWhite = randomWhite.nextInt(playerOnePieces.size());
//                movingPiece = playerOnePieces.get(randomMoveWhite);
//                System.out.println(movingPiece.getPieceName());
//                System.out.println(movingPiece.getCurrentPositionSquare().getSquareName());
//                while (movingPiece.move() == null){
//                    Random w = new Random();
//                    int randomW = w.nextInt(playerOnePieces.size());
//                    movingPiece = playerOnePieces.get(randomWhite.nextInt(playerOnePieces.size()));
//                    movingPiece.move();
//                    System.out.println(movingPiece.getPieceName());
//                    System.out.println(movingPiece.getCurrentPositionSquare().getSquareName());
//                }
//                System.out.println(movingPiece.getCurrentPositionSquare().getSquareName());
//
//                int randomMoveBlack = randomBlack.nextInt(playerTwoPieces.size());
//                movingPiece = playerTwoPieces.get(randomMoveBlack);
//                System.out.println(movingPiece.getPieceName());
//                System.out.println(movingPiece.getCurrentPositionSquare().getSquareName());
//            while (movingPiece.move() == null){
//                int randomb = randomBlack.nextInt(playerTwoPieces.size());
//                movingPiece = playerOnePieces.get(randomBlack.nextInt(playerOnePieces.size()));
//                movingPiece.move();
//            }
//                System.out.println(movingPiece.getCurrentPositionSquare().getSquareName());
//            counter++;
//
//        }
//        pawnW4.move();
//
//        int val1 = 0;
//        for (Piece playerOnePiece : playerOnePieces) {
//            System.out.print(playerOnePiece.getPieceName() + ": " + playerOnePiece.getCurrentPositionSquare().getSquareName() + ", ");
//            val1 = val1 + playerOnePiece.getPieceValue();
////            System.out.println(val1);
//        }
//        int val2 = 0;
//        System.out.println();
//        for (Piece playerOnePiece : playerTwoPieces) {
//            System.out.print(playerOnePiece.getPieceName() + ": " + playerOnePiece.getCurrentPositionSquare().getSquareName() + ", ");
//            val2 = val2 - playerOnePiece.getPieceValue();
////            System.out.println(val2);
//        }

        for (Square s : Board.getSquares()){
            System.out.print("\n" + s.getSquareName() + " is occupied: ");
            System.out.print(s.isOccupied());
        }
        System.out.println("\n" + pawnW5.move().getSquareName());
        System.out.println("\n" + pawnB4.move().getSquareName());
        System.out.println("\n"  + bishopw2.move().getSquareName());
        System.out.println("\n"  + bishopw2.move().getSquareName());

        for (Square s : Board.getSquares()){
            System.out.print("\n" + s.getSquareName() + " is occupied: ");
            System.out.print(s.isOccupied());
        }
        return testBoard;
    }





}

