import java.util.*;
import java.io.*;

public class Lottery {
    
 
   
   public static void main(String[] args) {
      int[] userarr = new int [6];
      int[] drawarr = new int[6];
      
      int compareNum;  
      
      userNumbers(userarr, drawarr);
   
   }
   
   // Takes Lottery Numbers from User.
   public static int[] userNumbers(int[] userarr, int[] drawarr) {
   
      Scanner input = new Scanner(System.in);
      
      System.out.println("######################### Welcome #########################");
      System.out.println("Please input 6 numbers between 1 and 20 to play the Lottery");
      System.out.println("###########################################################");
      System.out.println();
      System.out.print("Please input FIRST no: ");
      userarr[0] = input.nextInt();
      System.out.print("Please input SECOND no: ");
      userarr[1] = input.nextInt();
      System.out.print("Please input THIRD no: ");
      userarr[2] = input.nextInt();
      System.out.print("Please input FOURTH no: ");
      userarr[3] = input.nextInt();
      System.out.print("Please input FIFTH no: ");
      userarr[4] = input.nextInt();
      System.out.print("Please input LAST no: ");
      userarr[5] = input.nextInt();
      
      //input.close();
      
      
      //Checks if user input a number between 1 and 20, and if not, restarts the game.
      
      int legalNums;
      
      for (int i = 0; i < userarr.length; i++) {
         
         legalNums = userarr[i];
         
         if (!(legalNums > 0 && legalNums <= 20) ) {
         
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("You entered wrong numbers. Try Again.");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println();
           
            restart(userarr, drawarr);
               
            return null;
         
         }
         
      }
      
      drawNumbers(userarr, drawarr);
      
      return userarr;
   
   }
   
   // Makes a random Lotto draw.
   public static int[] drawNumbers(int[]userarr, int[] drawarr) {
      Random rng = new Random();
      
      int roll;
      
      for (int i = 0; i < drawarr.length; i++){
            
         roll = rng.nextInt(20) +1;
         
        //Makes sure there is no duplicates
         while (roll == drawarr[0] || roll == drawarr[1] || roll == drawarr[2] || roll == drawarr[3] || roll == drawarr[4] || roll == drawarr[5] ) {
         
            roll = rng.nextInt(20) +1;
            
         }
      
         drawarr[i] = roll;
        
      }
      
      doCompare(userarr, drawarr);
      
      return drawarr;
   }
   
   //Compares users numbers with Lottery Numbers.
   public static int doCompare(int[] userarr, int[]drawarr) {
   
      int compareNum = 0;
      
      for (int i = 0; i < userarr.length; i++) {
      
         for (int j = 0; j < drawarr.length; j++){
         
            if ( userarr[i] == drawarr[j] ) {
            
               compareNum++;
            
            }     
         }
      
      }
      
      winCheck(userarr, drawarr,compareNum); 
   
      return compareNum;  
   }
   
   //Checks what user has won
   public static void winCheck(int[] userarr, int[] drawarr, int compareNum) {
   
      System.out.println("You had " + compareNum + " correct Lottery Number(s).");
   
      String win = "";
      switch (compareNum) {
         case 5:  win = "YOU HIT THE FREAKIN JACKPOT - $10 MILLION!!";
            break;
         case 4:  win = "WINNER - $200.000!!";
            break;
         case 3:  win = "WINNER - $5,000!!";
            break;
         case 2:  win = "WINNER - $100!!";
            break;
         case 1:  win = "WINNER - $5!!";
            break;
         case 0:  win = "No matching numbers - you can go outside and play now.";
            break;
         default: win = "fuck";
      }
      
      System.out.println(win);
      
      System.out.println();
      
      playAgain(userarr, drawarr); 
      
   }
   
      // Asks if user wants to play again
   public static void playAgain(int[] userarr, int[] drawarr) {
      
      System.out.println("Do you want to play again ( y / n )");
      Scanner input = new Scanner(System.in);
      
      String playagain = input.next();
      
      if (playagain.equalsIgnoreCase("y")) {
      
         restart(userarr, drawarr);
      }
      else if (playagain.equalsIgnoreCase("n")) {
         
         System.out.print("Thanks for playing. Goodbye");
      
         
         /*
         //this asks for user to press a button to end program ( when run in console thru .exe )
         try {
            System.in.read();
         } 
         catch (IOException e) {
         // TODO Auto-generated catch block
            e.printStackTrace();
         }
         */
      } 
      else {
      
         System.out.println("You dun fucked it up, Press Y or N ");
         System.out.println();
      
         playAgain(userarr, drawarr);
      
      }
      
   }
   
      
   
   // retarts game if needed
   public static void restart (int[] userarr, int[] drawarr) {
   
      userNumbers(userarr, drawarr);
   
   }
   
   
  
}