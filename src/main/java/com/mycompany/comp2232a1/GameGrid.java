/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comp2232a1;
import java.util.Scanner;


/**
 *
 * @author Kristian Patrick
 */
public class GameGrid {
    //Data Members
    private int numRows;
    private int numCols;
    GamePiece[][] grid;
    Player player1, player2;
    private int numZhens;
    int[] hunter1Coord = {4 , 3};
    int[] hunter2Coord = {4 , 4};
    private int numHunters;
    Scanner in = new Scanner(System.in);
    private String strTemp;
    
    GamePiece gp = new GamePiece();
    Hunter hunter, hunter2;
    
    Bramble bramble = new Bramble();
    
    Zhen zhen = new Zhen();
    
    EdgeException edge = new EdgeException();
    
    CrowdingException crowd = new CrowdingException();
    
    //Constructor
    public GameGrid() { 
        numRows = 8;
        numCols = 8;
        grid = new GamePiece[numRows][numCols];
    }
    
    //Methods
    boolean addGamePiece(GamePiece piece, int row, int col) {
        if (grid[row][col].getSymbol() == '?'){ //Checks if space is empty
            grid[row][col] = piece;
            grid[row][col].setRowPos(row);
            grid[row][col].setColPos(col);
            return true;
        } else {
            return false;
        }
    } //addGamePiece
    
    void setupGrid() {
        //Initializing Grid Array Because Grid is an Array with class base type
        for (int a = 0; a < grid.length; a++){
            for (int s = 0; s < grid.length; s++){
            grid[a][s] = new GamePiece();
            }
        } //end for
        
        //Getting Information
        System.out.println("\nPlease enter name of player 1: ");//Get player 1 name
        strTemp = in.nextLine();
        player1 = new Player(strTemp);
        player1.setName(strTemp);
        
        System.out.println("\nPlease enter name of player 2: ");//Get player 2 name
        strTemp = in.nextLine();
        player2 = new Player(strTemp);
        player2.setName(strTemp);
        
        System.out.println("\nPlease enter the number of Zhens ");//Get number of zhens
        System.out.println("\nValid options: 16, 18 or 20");
        numZhens = in.nextInt();
        numHunters = 2;
        //Checking if user entered an invalid amount of Zhens 
        if ((numZhens != 16) && (numZhens != 18) && numZhens != 20){
            System.out.println("Invalid amount of Zhens entered!!");
            System.exit(0);
        }
        
        //Getting & Placing Hunters
        //Hunter 1
        System.out.println(player1.getName() + ", please enter two characters to represent your huunters");
        System.out.println("Valid Options: Any letter other than Z");
        char chartemp = in.next().charAt(0);
        //Checking if user entered Z
        if ((chartemp == 'Z') || (chartemp == 'z')){
            System.out.println("Invalid option entered!!");
            //re enter
        }
        
        hunter = new Hunter();
        hunter.setEnergyLevel(4);
        hunter.sethName(chartemp);
        hunter.setSymbol(chartemp);
        
        addGamePiece(hunter, hunter1Coord[0], hunter1Coord[1]);

        //Hunter 2
        System.out.println(player1.getName() + ", please enter a character to represent your other huunter");
        char chartemp2 = in.next().charAt(0);
        //Checking if user entered Z
        if ((chartemp2 == 'Z') || (chartemp2 == 'z')){
            System.out.println("Invalid option entered!!");
            //re enter
        }
        
        hunter2 = new Hunter();
        hunter2.setEnergyLevel(4);
        hunter2.sethName(chartemp2);
        hunter2.setSymbol(chartemp2);

        addGamePiece(hunter2, hunter2Coord[0], hunter2Coord[1]);
        
       //Placing Brambles
       //1st row
        grid[0][0] = new Bramble();
        grid[0][0]= new Bramble();
        grid[0][1]= new Bramble();
        grid[0][6]= new Bramble();
        grid[0][7]= new Bramble();
        
        //2nd row
        grid[1][0]= new Bramble();
        grid[1][1]= new Bramble();
        grid[1][6]= new Bramble();
        grid[1][7]= new Bramble();
        
        //6th row
        grid[6][0]= new Bramble();
        grid[6][1]= new Bramble();
        grid[6][6]= new Bramble();
        grid[6][7]= new Bramble();
        
        //7th row
        grid[7][0]= new Bramble();
        grid[7][1]= new Bramble();
        grid[7][6]= new Bramble();
        grid[7][7]= new Bramble();
        
        //Placing Zhens
        for (int i = 0; i < 3; i++){
            for(int k = 2; k < 6; k++){
               grid[i][k] = new Zhen();
            }
        }
        
        grid[2][0] = new Zhen();
        grid[2][1] = new Zhen();
        
        grid[2][6] = new Zhen();
        grid[2][7] = new Zhen();
        
        if (numZhens == 18 || numZhens == 20)
        {
            grid[3][0] = new Zhen();
            grid[3][7] = new Zhen();
        }
        
        if (numZhens == 20)
        {
        
        grid[4][0] = new Zhen();
        grid[4][7] = new Zhen();
        }   
    } //Set up grid
    
    public int[] getZhenRowCol()
    {
        int[] toMoveRowCol1 = new int[2];
        System.out.println(player2.getName() + ", Please select a Zhen from the board to move!");
        System.out.println("Select by entering a valid row-column pair");
        
        System.out.println("Please select the row of your Zhen");
        toMoveRowCol1[0] = in.nextInt();
        System.out.println("Please select the coloum of your Zhen");
        toMoveRowCol1[1] = in.nextInt();
        
        return toMoveRowCol1;
    }//getZhenRowCol
    
    public int zDirectionSelect()
    {
        int direction;
        
        //Displays a zhen's movement options
        displayMovementOptions(2);
        
        //Player selects a direction to move entered as an integer
        System.out.println("Please enter a valid direction to move represented by an integer");
        direction = in.nextInt();
        return direction;
    }//zDirectionSelect
    
    public void zhenPlay()
    {
        boolean valid = false;
        boolean valid2 = false;
        int[] tempArr = new int[2];
        int[] newPos = new int[2];
        while (valid != true)
        {
            tempArr = getZhenRowCol();
            if (grid[tempArr[0]][tempArr[1]] == hunter) //Checks is selection is valid
            {
                System.out.println("Invalid please a enter new Zhen row-colum pair");
                tempArr = getZhenRowCol();
            } else
            {
                valid = true;
            }
        }//while
    
        while (valid2 == false)
        {
        //Game determines validity of the move
        int direction = zDirectionSelect();
        newPos = zhen.findNewPos(direction); //Get Position
        
        if (validateMove(newPos[0], newPos[1]) == true) //If valid
        { //Adds new Zhen to position
            zhen.moveToNewPos(direction);
            grid[tempArr[0]][tempArr[1]] = new Zhen();
            valid2 = true;
        } else
        {
            System.out.println("Invalid Move!");
            System.out.println("Plese re select direction to move");
            valid2 = false;
        } // while
        }
    }//Zhen Play
    
  public int[] getHunterRowCol()
    {
        int[] toMoveRowCol1 = new int[2];
        
        int[] newPos = new int[2];
        int direction;
        System.out.println(player1.getName() + ", Please select a Hunter from the board to move!");
        System.out.println("Select by entering a valid row-column pair");
        
        System.out.println("Please select the row of your Hunter");
        toMoveRowCol1[0] = in.nextInt();
        System.out.println("Please select the coloum of your Hunter");
        toMoveRowCol1[1] = in.nextInt();
        
        return toMoveRowCol1;
    }//getHunterRowCol
  
     public int hDirectionSelect()
    {
        int direction;
        
        //Displays a hunters's movement options
        displayMovementOptions(1);
        
        //Player selects a direction to move entered as an integer
        System.out.println("Please enter a valid direction to move represented by an integer");
        direction = in.nextInt();
        return direction;
    }//hDirectionSelect
    
    public void hunterPlay()
    {
        boolean valid = false;
        boolean valid2 = false;
        int[] tempArr = new int[2];
        int[] newPos = new int[2];
        while (valid != true)
        {
            tempArr = getHunterRowCol();
            if (grid[tempArr[0]][tempArr[1]] != hunter) //Checks is selection is valid
            {
                System.out.println("Invalid please a enter new Zhen row-colum pair");
                tempArr = getHunterRowCol();
            } else
            {
                valid = true;
            }
        }//while //determines if hunter are at the row-col pair
    
        while (valid2 == false)
        {
        //Game determines validity of the move
        int direction = hDirectionSelect();
        newPos = hunter.findNewPos(direction); //Get Position
        
        if (validateMove(newPos[0], newPos[1]) == true) //If valid
        { //Adds new Hunter to position
            for (int i = 0; i <= 8; i++)
            {
                if (direction == i)
                {
                    hunter.moveToNewPos(direction);
                    grid[tempArr[0]][tempArr[1]] = new Hunter();
                }
            }//end for
            
            if (isZhenPosition(newPos[0], newPos[1]) == true) //Checks if a Zhen is in the position
                    {
                        if (direction == 9)
                             {  
                                 hunter.eatNorth();
                                 removePiece(newPos[0], newPos[1]); //Removes Zhen from board
                             }
                        if (direction == 11)
                            {
                                hunter.eatSouth();
                                removePiece(newPos[0], newPos[1]); //Removes Zhen from board
                             }       
                        if (direction == 12)
                            {
                                hunter.eatEast();
                                removePiece(newPos[0], newPos[1]); //Removes Zhen from board
                            }       
                        if (direction == 10)
                            {
                                 hunter.eatWest();
                                 removePiece(newPos[0], newPos[1]); //Removes Zhen from board
                            }
                    } 
            valid2 = true;
        } else
        {
            System.out.println("Invalid Move!");
            System.out.println("Plese re select direction to move");
            valid2 = false;
        } // while
        }
        
        /*TO IMPLEMENT
        7.b.iv. ,vii. & v
        */
    }//Hunter Play
    
    //End-Game Conditions
    //Zhen wins: Both Hunters are trapped
    //Hunters win: there are two few Zhens to overwhelm and trap both hunters
    
    /*
    Displays amessage with the appropriate command instructions for moving the current player's
    pieces indicated via the player parameter where 1 = Hunter, 2 = Zhen
    */
    public void displayMovementOptions(int player)
    {
        if (player == 1)//Hunter
        {
            System.out.println("Hunter Movement Options are: ");
            System.out.println(" 1 - North | 2 - South | 3 - East | 4 - West");
            System.out.println(" 5 - North-west | 6 - South-West | 7 - South-East | 8 - North-East");
            System.out.println(" 9 - Eat North | 10 - Eat West | 11 - Eat South | 12 - Eat East");
        }
        if (player == 2)//Zhen
        {
            System.out.println("Zhen Movement Options are: ");
            System.out.println(" 1 - North | 2 - South | 3 - East | 4 - West");
            System.out.println(" 5 - North-west | 6 - South-West | 7 - South-East | 8 - North-East");
        }
    }//Display movement
    
    boolean endGame() //Used to detect end game conditions
    {
        
       return false; 
    }
    
    boolean validateMove(int row, int col)//Validate the destination a piece will be moved to
    {
        //Destination is of board
        try 
        {
           grid[row][col] = new GamePiece(); 
       }
       catch(ArrayIndexOutOfBoundsException e) {
           System.out.println(edge.toString());
           System.out.println("Re-enter or die!");
       }
       
       if (grid[row][col] != gp)//PlaceHolder
               {
                   System.out.println(crowd.toString());
                   System.out.println("Destination occupied by another piece"); 
               }
       
        return true; //Valid Move
    }//Validate Move
    
    boolean isZhenPosition(int rowPos, int colPos) //Check if Zhen exists at rowPos, colPos
    {
        if(grid[rowPos][colPos] == zhen)
        {
          return true; 
        } else
            return false;
    }//isZhenPosition
    
    boolean removePiece(int rowPos, int colPos) //Remove an eaten Zhen
    {
        grid[rowPos][colPos] = new GamePiece(); //tentative
        return true; 
    }//removePiece
    
    void displayGrid() {
        
        for (int i = 0; i < grid.length; i++) 
        { 
            System.out.println("\n  ... ... ... ... ... ... ... ...");
            for (int j = 0; j < grid[i].length; j++)
            {

                if (grid[i][j].getSymbol() == '?')
                {
                    System.out.print(" |  ");         
                }
                else{
                    System.out.print(" | " + grid[i][j].getSymbol());
                }
            }
            System.out.print(" |");
        } //End int i for loop
                System.out.println("\n  ... ... ... ... ... ... ... ...");
        System.out.println("\nHunter " + hunter.gethName() + " energy: " + hunter.getEnergyLevel());
        System.out.println("Hunter " + hunter2.gethName() + " energy: " + hunter2.getEnergyLevel());
        System.out.println("Num of Zhens: " + numZhens);
        
        } //Dispay grid method  
} //End of Class
