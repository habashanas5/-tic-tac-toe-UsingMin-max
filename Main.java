package minmax;


import java.util.Scanner;

public class Main {

  public static void main(String[] args) throws Exception {
    
     Board board ;
     System.out.println("********************************************");
     System.out.println("*- Do you want to complete the game or not ? y/Y / n/N ");
     Scanner scanner = new Scanner(System.in);
     
        boolean valid = false;
        while(!valid) {
            String complete = scanner.nextLine();
            if( complete.equals("y") ||complete.equals("Y") ) {
                 Read read= new Read();
                 read.readfile();
                       board = new Board(read.getInitialState());
                       
                 if(read.getMove()=='o' ||read.getMove()=='O') {
                     Player player1 = new Player(Symbol.CIRCLE);
                     Player player2 = new Player(Symbol.CROSS);
                     setupPlayer(player1);
                     setupPlayer(player2);
                     boolean winnerPosition = false;
                     board.printBoard();
                     while (!winnerPosition) {
                       player1.play(board);
                       System.out.println("**************************");
                       board.printBoard();
                       winnerPosition = board.evaluate();
                       if (winnerPosition) {
                         break;
                       }
                       player2.play(board);
                       System.out.println("**************************");

                       board.printBoard();
                       winnerPosition = board.evaluate();
         
                     }
                 } else{                                        
                     Player player1 = new Player(Symbol.CROSS);
                     Player player2 = new Player(Symbol.CIRCLE);
                     setupPlayer(player1);
                     setupPlayer(player2);
                     boolean winnerPosition = false;
                     board.printBoard();
                     while (!winnerPosition) {
                       player1.play(board);
                       System.out.println("**************************");
                       board.printBoard();
                       winnerPosition = board.evaluate();

                       if (winnerPosition) {
                         break;
                       }
                       player2.play(board);
                       System.out.println("**************************");
                       board.printBoard();
                       winnerPosition = board.evaluate();
          
                     }
            }    

                valid = true;
            }
            else if( complete.equals("n") ||complete.equals("N") ) {
                       board = new Board();
                       Player player1 = new Player(Symbol.CIRCLE);
                       Player player2 = new Player(Symbol.CROSS);
                       setupPlayer(player1);
                       setupPlayer(player2);
                       boolean winnerPosition = false;
                       board.printBoard();
                       while (!winnerPosition) {
                         player1.play(board);
                         System.out.println("**************************");
                         board.printBoard();
                         winnerPosition = board.evaluate();
                         if (winnerPosition) {
                           break;
                         }
                         player2.play(board);
                         System.out.println("**************************");
                         board.printBoard();
                         winnerPosition = board.evaluate();
                       }
                valid = true;
            }
           
        }   
  }

  private static void setupPlayer(Player player) {
    Scanner scanner = new Scanner(System.in);
    boolean isValid = false;
    while (!isValid) {
       System.out.println("**************************");
      System.out.println("*- Choose h/H for human player and m/M for machine:");
      String choice = scanner.nextLine();
      choice = choice.toLowerCase();
      if (choice.equals("h") ||choice.equals("H")) {
        player.setDecisionMaker(new Human());
        System.out.println("*- Your symbol in the game is: " + player.getSymbol());
        isValid = true;
      } else if (choice.equals("m")|| choice.equals("M")) {
        player.setDecisionMaker(new AI());
        System.out.println("*- Your symbol in the game is: " + player.getSymbol());
        isValid = true;
      } else {
        System.out.println("*- This isn't a valid choice");
      }
    }
  }
}
