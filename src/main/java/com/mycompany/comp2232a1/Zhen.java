/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comp2232a1;
import java.util.Arrays;  
/**
 *
 * @author Kristian Patrick
 */
public class Zhen extends GamePiece implements ControlActions{
    public Zhen() {
       type = "zhen";
       symbol = 'Z';
}  
    @Override
    public int[] findNewPos(int direction)
    {
        int newPos[]= new int[2];//creates an array that will hold the row in its first postion and the column value in its second position
        if (direction==1)//1="North"
        {
           newPos[0]= rowPos-1;
           newPos[1]= colPos;
  
            return newPos;
        }
        if (direction==2)//2 means "South"
        {
            newPos[0]= rowPos+1;
            newPos[1]= colPos;
            return newPos;
        }
        if (direction==3)//2 means "East"
        {
            newPos[0]= rowPos;
            newPos[1]= colPos+1;
        return newPos;
        }
        if (direction==4)//4 means "West"
        {
            newPos[0]= rowPos;
            newPos[1]= colPos-1;
            return newPos;
        } 
        if (direction == 5) //North West
        {
            newPos[0] = rowPos - 1;
            newPos[1] = colPos - 1;
            return newPos;
        }
        if (direction == 6) //South West
        {
            newPos[0] = rowPos + 1;
            newPos[1] = colPos - 1;
            return newPos;
        }
        if (direction == 7) //South East
        {
            newPos[0] = rowPos + 1;
            newPos[1] = colPos + 1;
            return newPos;
        }
        if (direction == 8)//North East
        {
            newPos[0] = rowPos + 1;
            newPos[1] = colPos - 1;
            return newPos;
        }
        else
        {
            newPos [0]=rowPos;
            newPos [1]=colPos;
            return newPos;
        }
    }
    
    @Override
    public void moveToNewPos(int direction){
        int arr[]= new int[2];
        arr = findNewPos(direction);
        setRowPos(arr[0]);
        setColPos(arr[1]);
    }
  
                       
}
