package Exercises.Guess_Number;

import java.util.*;
import java.lang.*;
public class Guess
{
    public static void main(String [] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int val = rand.nextInt(10) + 1;
        int num = 0;
        String userInput = "";
        process: do {
            System.out.println("Please enter input or enter quit");
            userInput = scan.nextLine();
            if(userInput.equals("quit"))
            {
                System.out.println("thanks for playing");
                System.exit(0);
            }
            else
            {
                try
                {
                    num = Integer.parseInt(userInput);
                }
                catch(NumberFormatException x)
                {
                    System.out.println("You have to enter a number bro");
                    continue;
                }
            }
            if(num > val)
            {
                System.out.println("go lower");
            }
            else if(num < val)
            {
                System.out.println("go higher");
            }
            else
            {
                System.out.println("You got it!");
                break;
            }

        }while(num != val);


    }
}
