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
public class ZhenHunters {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Welcoming and introducing user to the game
        System.out.println("Welcome to Zhen Hunters!");
        System.out.println("Zhen Hunters is a two-player board game");
        System.out.print("The goal of the game is for either the Hunters to\n"
                + "eat enough Zhens or the Zhens to surround the Hunters such \n"
                + "that they cannot move.");
        
        //Creating an instance of GameGrid
        GameGrid gameGrid = new GameGrid();
        
        //Setting up the grid
        gameGrid.setupGrid();
        
        //Displaying the grid
        gameGrid.displayGrid();
        
        //Zhen Player Selects Zhens and Direction for each
        while (gameGrid.endGame() == false) //Play until endgame condition is reached
        {
        gameGrid.zhenPlay();
        gameGrid.displayGrid();
        
        gameGrid.hunterPlay();
        gameGrid.displayGrid();
        }
        
    }
    
}
