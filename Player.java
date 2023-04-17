/*
The purpose of the Player is to easily keep track of the current Player and token.
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Player {
  ////////////////
  // PROPERTIES
  ///////////////
  private String name;
  private char token;
  private int turns = 0;
  private String color;
  private ArrayList<Integer> moves;
  final String RESET = "\u001B[0;0m"; 

  /////////////////
  // CONSTRUCTOR
  ////////////////
  public Player(String name) {
    this.name = name;
    this.moves = new ArrayList<Integer>();
  }

  /////////////////
  // METHODS
  ////////////////

  public int getInput(){
    Scanner scn = new Scanner(System.in);
    // getting user input
    System.out.println(getColor() + "\nWhich box do you want your token in? (" + getToken() + "): " + RESET);
    char pos = scn.next().charAt(0);
    int number = (int) pos - 48; // The ASCII position of numbers starts at 48 for 0
    return number;
  } 
  
  // GETTERS AND SETTERS
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public char getToken() {
    return token;
  }

  public void setToken(char token) {
    this.token = token;
  }
  
  public int getTurns() {
	 return turns;
  }

  public void setTurns(int turns) {
  	this.turns = turns;
  }
  
  public String getColor() {
  	return color;
  }
  
  public void setColor(String color) {
  	this.color = color;
  }
  
  public ArrayList<Integer> getMoves() {
	 return moves;
  }
  
  public void addMove(int pos){
    moves.add(pos);
  }

}