/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comp2232a1;

/**
 *
 * @author Kristian Patrick
 */
public class GamePiece {
    public String type;
    public char symbol;
    public int rowPos;
    public int colPos;
    
    public GamePiece()
        {
            type = "?";
            symbol = '?';
        }
    
    //Accessor and Mutator Methods
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getRowPos() {
        return rowPos;
    }

    public void setRowPos(int rowPos) {
        this.rowPos = rowPos;
    }

    public int getColPos() {
        return colPos;
    }

    public void setColPos(int colPos) {
        this.colPos = colPos;
    }
}
