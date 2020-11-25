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
public class Hunter extends GamePiece implements ControlActions, EatingActions{
    private int energyLevel;
    final private int MAXENERGY = 6;
    public char hName;
    int timesNotEaten;

   
    public Hunter(){
       type = "hunter";
       symbol = 'H';
    }
    //ControlActions Implementations
    @Override
    public int[] findNewPos(int direction) {
        int newPos[]= new int[2];
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
            newPos[0] = rowPos;
            newPos[1] = colPos;
            return newPos;
        }
    }
    
    @Override
    public void moveToNewPos(int direction){
        int arr[] = new int[2];
        arr = findNewPos(direction);
        setRowPos(arr[0]);
        setColPos(arr[1]);
    }
    
    //EatingActions Implementations
    @Override
    public void eatWest(){
        int eatArr[] = new int[2];
        eatArr[0]= rowPos;
        eatArr[1]= colPos - 1;
        //Places the hunter in the new position
        setRowPos(eatArr[0]);
        setColPos(eatArr[2]);
        setTimesNotEaten(0); //Resets the number of rounds since the hunter last ate to 0
        if (energyLevel != 6)
        {
            energyLevel++; //Hunter gains a single energy point a Zhen is eaten Max is 6
        }
        if (energyLevel > 6)
        {
           //Death by Gluttony 
        }
    }
    
    @Override
    public void eatEast(){
        int eatArr[] = new int[2];
        eatArr[0]= rowPos;
        eatArr[1]= colPos + 1;
        //Places the hunter in the new position
        setRowPos(eatArr[0]);
        setColPos(eatArr[2]);
        setTimesNotEaten(0); //Resets the number of rounds since the hunter last ate to 0
        
    }
    
    @Override
    public void eatNorth(){
       int eatArr[] = new int[2];
        eatArr[0]= rowPos - 1;
        eatArr[1]= colPos;
        //Places the hunter in the new position
        setRowPos(eatArr[0]);
        setColPos(eatArr[2]);
        setTimesNotEaten(0); //Resets the number of rounds since the hunter last ate to 0 
    }
    
    @Override
    public void eatSouth(){
        int eatArr[] = new int[2];
        eatArr[0]= rowPos + 1;
        eatArr[1]= colPos;
        //Places the hunter in the new position
        setRowPos(eatArr[0]);
        setColPos(eatArr[2]);
        setTimesNotEaten(0); //Resets the number of rounds since the hunter last ate to 0
    }
    //Accessors and Mutator Methods
    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public char gethName() {
        return hName;
    }

    public void sethName(char hName) {
        this.hName = hName;
    }
    
    public int getMAXENERGY() {
        return MAXENERGY;
    }
    
     public int getTimesNotEaten() {
        return timesNotEaten;
    }

    public void setTimesNotEaten(int timiesNotEaten) {
        this.timesNotEaten = timiesNotEaten;
    }
}
