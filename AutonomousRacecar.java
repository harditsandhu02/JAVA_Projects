/**
 * This 'Race Car' program will increase the car's speed, output the speed value to the user, 
 * generate a random value, and compare that value to the minimum threshold.
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 05 -- Walkthrough
 *
 * @author Hardit Sandhu
 * @version February 07, 2022
 */
import java.util.Random;
import java.util.Scanner;

public class AutonomousRacecar {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int speed = 0;
        int seedValue;
        int newRandom;
        int threshold;

        System.out.println("Please enter the seed for the random number generator:");
        seedValue = scan.nextInt();

        System.out.println("Please enter the threshold:");
        threshold = scan.nextInt();

        Random random = new Random(seedValue);

        System.out.println("Starting the car...");
        System.out.print("Current speed: "); 

        for (int i = 5; i > 0; i = i + 5) { // for loop needed for processing
            System.out.print(i + "..."); // printing the first value of i 
            speed = i; // setting the speed value to that 'i'
            newRandom = random.nextInt((threshold * 10)) + 1 ;
            if (newRandom <= threshold) { // if statement to check if the threshold is greater than or equal to the random number
                System.out.print("Done!");  // if so, the program will print 'done'
                break; // to terminate the program
            } else {
                continue; // continue if and only if the threshold is not greater or equal to the ranodom number
            }
            
        }

        System.out.println("\nMaximum run speed: "  + speed);

    }
}

