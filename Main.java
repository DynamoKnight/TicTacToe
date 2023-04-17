class Main {
  public static void main(String[] args) {

    TTT t = new TTT(); // The improved version of ChatTTT
    ChatTTT ct = new ChatTTT();

    System.out.println("Hello world!");
    
    // Plays a Two-player TTT game
    Player player1 = new Player("Player 1");
    Player player2 = new Player("Player 2");
    t.play(player1,player2);
    
  }
}