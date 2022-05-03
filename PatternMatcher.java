/**
 * This program will allow a user to play a pattern game. The user will select the level of difficulty and
 * enter a starting digit for the sequence. The program will respond by printing the first four numbers in the pattern
 * and requesting the next three. There are three possible levels of difficulty.
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 05 -- Challenge
 *
 * @author Hardit Sandhu
 * @version February 16, 2022
 */
import java.lang.Math;
import java.util.Scanner;

public class PatternMatcher {

  public static void main(String[] args) {
    String chooseLevel =
      "Choose Level Difficulty:" + "\n1. Easy\n2. Medium\n3. Hard";
    String startNumber = "Enter a number to start the pattern:";
    String nextThree = "Enter the next 3 numbers in the pattern:";
    String congratulations = "Congrats! Your answer was correct!";
    String sorry = "Sorry! Your answer was incorrect!";
    String again = "Play Game Again? (y/n)";
    String ending = "Ending Pattern Matcher...";

    //TODO: write your code below

    Scanner scanner = new Scanner(System.in);
    boolean trueORfalse = false;

    int diff = 0;
    int start = 0;
    int nxtOne = 0;
    int nxtTwo = 0;
    int nxtThree = 0;

    String yorn = "N";

    do {
      do {
        System.out.println(chooseLevel);
        diff = scanner.nextInt();
      } while (diff > 3);

      if (diff == 1) {
        System.out.println(startNumber);
        start = scanner.nextInt();
        System.out.println(nextThree);
        System.out.println(
          start + " " + (start + 3) + " " + (start + 6) + " " + (start + 9)
        );

        nxtOne = scanner.nextInt();
        nxtTwo = scanner.nextInt();
        nxtThree = scanner.nextInt();

        if (nxtOne != (start + 12)) {
          System.out.println(sorry);
        } else if (nxtTwo != (start + 15)) {
          System.out.println(sorry);
        } else if (nxtThree != (start + 18)) {
          System.out.println(sorry);
        } else {
          System.out.println(congratulations);
        }
      } else if (diff == 2) {
        System.out.println(startNumber);
        start = scanner.nextInt();
        System.out.println(nextThree);
        System.out.println(
          start +
          " " +
          (start * 7) +
          " " +
          (int) (start * (Math.pow(7, 2))) +
          " " +
          (int) (start * (Math.pow(7, 3)))
        );

        nxtOne = scanner.nextInt();
        nxtTwo = scanner.nextInt();
        nxtThree = scanner.nextInt();

        if (nxtOne != ((int) (start * (Math.pow(7, 4))))) {
          System.out.println(sorry);
        } else if (nxtTwo != ((int) (start * (Math.pow(7, 5))))) {
          System.out.println(sorry);
        } else if (nxtThree != ((int) (start * (Math.pow(7, 6))))) {
          System.out.println(sorry);
        } else {
          System.out.println(congratulations);
        }
      } else if (diff == 3) {
        System.out.println(startNumber);
        start = scanner.nextInt();
        System.out.println(nextThree);
        System.out.println(
          (int) (Math.pow(start, 3) - 1) +
          " " +
          (int) (Math.pow(start + 1, 3) - 1) +
          " " +
          (int) (Math.pow(start + 2, 3) - 1) +
          " " +
          (int) (Math.pow(start + 3, 3) - 1)
        );

        nxtOne = scanner.nextInt();
        nxtTwo = scanner.nextInt();
        nxtThree = scanner.nextInt();

        if (nxtOne != (int) (Math.pow(start + 4, 3) - 1)) {
          System.out.println(sorry);
        } else if (nxtTwo != (int) (Math.pow(start + 5, 3) - 1)) {
          System.out.println(sorry);
        } else if (nxtThree != (int) (Math.pow(start + 6, 3) - 1)) {
          System.out.println(sorry);
        } else {
          System.out.println(congratulations);
        }
      }

      System.out.println(again);
      yorn = scanner.next();

      if (yorn.equals("Y") || yorn.equals("y")) { // if the user agrees, then the loop will start over
        trueORfalse = true;
      } else if (yorn != "Y") {
        System.out.println(ending);
        break;
      }
    } while (trueORfalse);
  }
}
