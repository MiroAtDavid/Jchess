package model;


public class Kante {

    private Square startSquare;
    private Square endSquare;
    private int knotenGewicht;

    public Kante(Square startSquare, Square endSquare, int gewicht) {
        this.startSquare = startSquare;
        this.endSquare = endSquare;
        this.knotenGewicht = gewicht;
    }

    public Square getStart() {
        return startSquare;
    }
    public Square getEnde() {
        return endSquare;
    }
    public int getKnotenGewicht() {
        return knotenGewicht;
    }
    public void setStartKnoten(Square startSquare) {
        this.startSquare = startSquare;
    }
    public void setEndKnoten(Square endSquare) {
        this.endSquare = endSquare;
    }
    public void setKnotenGewicht(int knotenGewicht) {
        this.knotenGewicht = knotenGewicht;
    }
}