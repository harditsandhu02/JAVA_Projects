/**
 * This program is able to flip a word and output it in its reverse order. The program is also able to loop based on the user's choice.
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 05 -- Debugging
 *
 * @author Hardit Sandhu
 * @version February 07, 2022
 */
import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean big = false; // initializing the boolean value 'big'
        String yorn = ""; // initializing the string value 'yorn' ---- Yes or No

        do {
            System.out.println("Enter a string:");
            String input = scanner.nextLine();

            for (int i = input.length()-1; i >= 0; i--) { // for loop to start at the last character and work its way backwords
                    System.out.print(input.charAt(i)); // outputing each character one by one on the same line
            }

            System.out.println("\nAgain?"); 
            yorn = scanner.nextLine(); // asking the user if would like to reverse a string again

            if (yorn.equals("Y")){ // if the user agrees, then the loop will start over
                big = true;

            } else if (yorn != "Y") {
                break;
            }

        } while (big); // while true...
    }
}