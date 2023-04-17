/*
The TTT class creates a game board that can be placed and played on for Tic-Tac-Toe. The Size is able to change. 
*/
import java.util.Scanner;
import java.util.ArrayList;

public class TTT {

  /////////////////
  // PROPERTIES
  /////////////////
  private final int SIZE = 3;
  private char state[][]; // Game board
  final String BLUE = "\u001B[1;34m"; // Player 1
  final String RED = "\u001B[1;31m"; // Player 2
  final String RESET = "\u001B[0;0m"; 
  private ArrayList<Integer> moves;

  /////////////////
  // CONSTRUCTOR
  /////////////////
  public TTT() {
    this.state = new char[SIZE][SIZE];
    this.moves = new ArrayList<Integer>();
  }

  ///////////////
  // METHODS
  //////////////
  public void fill() {
    int count = 0; // The true position
    for (int i = 0; i < SIZE; i++) {
      for(int j = 0; j < SIZE; j++){
        state[i][j] = (char)(count+'0'); // ASCII VALUE
        count++;
      }
    }
  }

  public void play(Player p1, Player p2) {
    // Number order
    fill();    
    // Style
    p1.setToken('X');
    p2.setToken('O');
    p1.setColor(BLUE);
    p2.setColor(RED);
    // The game begins until it ends
    boolean gameEnd = false;
    while (gameEnd == false) {
      gameEnd = move(p1);
      if(gameEnd == false){
        gameEnd = move(p2);
      }
    }
    draw(); // Final board
  }

  // Shows the Board
  public void draw() {
    System.out.println();
    for (char[] rows : state) {
      for (char x : rows) {
        if(x == 'X'){
          System.out.printf(" [" + BLUE + " %c " + RESET + "]", x);
        }
        else if(x == 'O'){
          System.out.printf("[" + RED + " %c " + RESET + "]", x);
        }
        else{
          System.out.printf("[ %c ]", x);
        }
        
      }
      System.out.println();
    }
  }

  // Aidan will present
  // Checks if the spot is avaliable and fills it
  public boolean move(Player p) {
    draw();
    int number = p.getInput();
    int row = number / SIZE;
    int column = number % SIZE;
    
    if (state[row][column] == 'X' || state[row][column] == 'O') {
      System.out.println("Pick another spot");
      return move(p);
    } 
    else {
      state[row][column] = p.getToken();
      p.addMove(number);
      return didWin(p.getToken());
    }
  }


  // Checks all checks
  public boolean didWin(char t) {
    if (checkRows(t) || 
        checkColumns(t) || 
        checkDiagonalLeft(t) || 
        checkDiagonalRight(t)) {
      return true;
    }
    return false;
  }



  // Breaks down the 2D-Array
  // Tries every row and moves if there is a breakage
  public boolean checkRows(char t){
    for (char[] row : state) {
      if(checkRow(row, t)){
        return true;
      }
    }
    return false;
  }
  
  // Increments through the row(x++) and checks every column if all the elements are identical
  private boolean checkRow(char[] row, char t) {
      // If it never breaks, then you have a complete row
      for (char token : row) {
        if (token != t) {
          return false;
        }
      }
      System.out.println("Player " + t + " wins!");
      return true; // Means row won
  }

  // Tries every column and moves if there is a breakage
  private boolean checkColumns(char t){
    for (int column = 0; column < SIZE; column++) {
      if(checkColumn(column, t)){
        return true;
      }
    }
    return false;
  }
  // Increments down the column(y++) and checks every row if all the elements are identical
  private boolean checkColumn(int column, char t) {
    for (int token = 0; token < SIZE; token++) { 
      if (state[token][column] != t) {
        return false; // Means column failed
      }
    }
    System.out.println("Player " + t + " wins!");
    return true; // Appeared all time
  }

  // Checks from the Top Left to the Bottom Right, increases x and y by one until it reaches Bottom Right.
  private boolean checkDiagonalLeft(char t) {
    for (int diag = 0; diag < SIZE; diag++) {
      if (state[diag][diag] != t) {
        return false;
      } 
    }
    System.out.println("player " + t + " wins!");
    return true; // Appeared all times
  }

  // Checks from the Top Right to the Bottom Left, decreases x but increases y by one until it reaches Bottom Left.
  private boolean checkDiagonalRight(char t) {
    int row = 0; // Represents down movement
    for (int column = SIZE - 1; column >= 0; column--) {
      if (state[row][column] != t) {
        return false;
      } 
      row++; // Next column
    }
    System.out.println("player " + t + " wins!");
    return true; // Appeared all times
  }

}