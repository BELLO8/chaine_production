package com.usine;

public class Piece {
    private String type_piece;
    private int niveau_qualité_piece;

    public Piece(String type_piece, int niveau_qualité_piece) {
        this.type_piece = type_piece;
        this.niveau_qualité_piece = niveau_qualité_piece;
    }

    public Piece() {
    }

    public String getType_piece() {
        return type_piece;
    }

    public void setType_piece(String type_piece) {
        this.type_piece = type_piece;
    }

    public int getNiveau_qualité_piece() {
        return niveau_qualité_piece;
    }

    public void setNiveau_qualité_piece(int niveau_qualité_piece) {
        this.niveau_qualité_piece += niveau_qualité_piece;
    }
}
