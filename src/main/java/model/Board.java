package model;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.*;
import java.util.*;

public class Board {

    private static ArrayList<Square> square;
    private boolean gewichtet;
    private boolean gerichtet;


    // Konstruktor -----------------------------------------------------------------------------------------------------
    public Board(boolean gewichtet){
        square = new ArrayList<>();
        setGewichtet(gewichtet);
        setGerichtet(gerichtet);
    }

    // Getter ---- -----------------------------------------------------------------------------------------------------
    public static ArrayList<Square> getSquares(){
        return square;
    }
    public boolean isGewichtet(){
        return gewichtet;
    }
    public boolean isGerichtet() {
        return gerichtet;
    }
    public Square getKnotenBezeichnung(String knotenBezeichnung){
        for (Square k : square) {
            if(k.getSquareName().equals(knotenBezeichnung))
                return k;
        }
        return null;
    }

    // Setter ---- -----------------------------------------------------------------------------------------------------
    public void setGewichtet(boolean gewichtet){
        this.gewichtet = gewichtet;
    }
    public void setGerichtet(boolean gerichtet) {
        this.gerichtet = gerichtet;
    }
    // Andere Methoden -------------------------------------------------------------------------------------------------
    public Square knotenHinzufuegen(String knotenBezeichnung, int row, int col, Color color) throws BoardException {
        Square squareNeu = new Square(knotenBezeichnung, row, col, color , new Rectangle(90,90));
        square.add(squareNeu);
        return squareNeu;
    }
    public void kanteHinzufuegen(Square startSquare, Square endSquare, int gewicht) {
        if (!gewichtet)
            gewicht = 1;
        startSquare.kanteHinzufuegen(endSquare, gewicht);
        if (!gerichtet)
            endSquare.kanteHinzufuegen(startSquare,gewicht);
    }
    public void kanteEntfernen(Square startSquare, Square endSquare) {
        startSquare.kanteEntfernen(endSquare);
        if (!gerichtet)
            endSquare.kanteEntfernen(startSquare);
    }
    public void knotenEntfernen(Square squareZuEntfernen) {
        square.remove(squareZuEntfernen);
    }

    // Graph von CSV Datei laden ---------------------------------------------------------------------------------------
    public static String graphCSVview(File file) throws BoardException {
        Board board = new Board(true);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String zeile;
            int reihe = 0;
            while ((zeile = br.readLine()) != null) {
                sb.append(zeile).append("\n");
                reihe++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    // String ausgabe --------------------------------------------------------------------------------------------------
    public String toString() {
        return "";
    }
    public void print(){
        System.out.println(this);
    }

}
