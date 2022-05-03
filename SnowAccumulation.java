import java.util.Scanner;

/**
 * This program (project) is able to calculate the snowfalls
 * that correspond to the daily snowfall over a week at two local ski resorts.
 * The user will also be able to display (print) the full report of the
 * snowfall totals if the user elects to receive it, display the total snowfall
 * accumulation for both resorts, display the aggregate data for each resort,
 * including the total and average accumulations. Finally it will identify
 * and display the resort who had snowier days more frequently.
 *
 *
 * @author Hardit Sandhu
 * @version February 21, 2022
 */
public class SnowAccumulation {
  public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("Welcome!");
      System.out.println("Enter Resort One Name:");
      String resortOne = scanner.nextLine();
      System.out.println("Enter Resort Two Name:");
      String resortTwo = scanner.nextLine();
      System.out.println("Enter Snow Accumulations:");
      String accumulations = scanner.nextLine();
      System.out.println("Enter Report type:" +
              "\n1. Full" +
              "\n2. Summary");
      int reportType = scanner.nextInt();

      scanner.close();

      // The values of each of the accumulations are defined below, 
      // you should use these double variables to make your calculations.
      // Each string has 7 paired values so the format of the string is resortOneDayOne
      // - resortTwoDayOne, resortOneDayTwo - resortTwoDayTwo, ...
      int currentStringIndex = 0;
      double resortOneDayOne = Double.parseDouble(accumulations.substring(currentStringIndex,
                                                                          accumulations.indexOf("-")));
      currentStringIndex += accumulations.indexOf("-") + 1;
      double resortTwoDayOne = Double.parseDouble(accumulations.substring(currentStringIndex,
                                                                          accumulations.indexOf(",")));
      accumulations = accumulations.substring(accumulations.indexOf(",") + 1);

      currentStringIndex = 0;
      double resortOneDayTwo = Double.parseDouble(accumulations.substring(currentStringIndex,
                                                                          accumulations.indexOf("-")));
      currentStringIndex += accumulations.indexOf("-") + 1;
      double resortTwoDayTwo = Double.parseDouble(accumulations.substring(currentStringIndex,
                                                                          accumulations.indexOf(",")));
      accumulations = accumulations.substring(accumulations.indexOf(",") + 1);

      currentStringIndex = 0;
      double resortOneDayThree = Double.parseDouble(accumulations.substring(currentStringIndex,
                                                                            accumulations.indexOf("-")));
      currentStringIndex += accumulations.indexOf("-") + 1;
      double resortTwoDayThree = Double.parseDouble(accumulations.substring(currentStringIndex,
                                                                            accumulations.indexOf(",")));
      accumulations = accumulations.substring(accumulations.indexOf(",") + 1);

      currentStringIndex = 0;
      double resortOneDayFour = Double.parseDouble(accumulations.substring(currentStringIndex,
                                                                           accumulations.indexOf("-")));
      currentStringIndex += accumulations.indexOf("-") + 1;
      double resortTwoDayFour = Double.parseDouble(accumulations.substring(currentStringIndex,
                                                                           accumulations.indexOf(",")));
      accumulations = accumulations.substring(accumulations.indexOf(",") + 1);

      currentStringIndex = 0;
      double resortOneDayFive = Double.parseDouble(accumulations.substring(currentStringIndex,
                                                                           accumulations.indexOf("-")));
      currentStringIndex += accumulations.indexOf("-") + 1;
      double resortTwoDayFive = Double.parseDouble(accumulations.substring(currentStringIndex,
                                                                           accumulations.indexOf(",")));
      accumulations = accumulations.substring(accumulations.indexOf(",") + 1);

      currentStringIndex = 0;
      double resortOneDaySix = Double.parseDouble(accumulations.substring(currentStringIndex,
                                                                          accumulations.indexOf("-")));
      currentStringIndex += accumulations.indexOf("-") + 1;
      double resortTwoDaySix = Double.parseDouble(accumulations.substring(currentStringIndex,
                                                                          accumulations.indexOf(",")));
      accumulations = accumulations.substring(accumulations.indexOf(",") + 1);

      currentStringIndex = 0;
      double resortOneDaySeven = Double.parseDouble(accumulations.substring(currentStringIndex,
                                                                            accumulations.indexOf("-")));
      currentStringIndex += accumulations.indexOf("-") + 1;
      double resortTwoDaySeven = Double.parseDouble(accumulations.substring(currentStringIndex));
      
      // if the user inputs the value of "1", then the program will display each day of 
      // the week and its corresponding snowfall values

      if (reportType == 1) { 

        System.out.println(resortOne + " Full Report: "); // start by displaying the first resort's name

        // followed by the day and snowfall values

        System.out.printf("Monday: %.2f \n", resortOneDayOne);

        System.out.printf("Tuesday: %.2f \n", resortOneDayTwo);

        System.out.printf("Wednesday: %.2f \n", resortOneDayThree);

        System.out.printf("Thursday: %.2f \n", resortOneDayFour);

        System.out.printf("Friday: %.2f \n", resortOneDayFive);

        System.out.printf("Saturday: %.2f \n", resortOneDaySix);

        System.out.printf("Sunday: %.2f \n", resortOneDaySeven);


        System.out.println(resortTwo + " Full Report: "); // then the program will display the second resort's name

        // followed by the day and snowfall values

        System.out.printf("Monday: %.2f \n", resortTwoDayOne);

        System.out.printf("Tuesday: %.2f \n", resortTwoDayTwo);

        System.out.printf("Wednesday: %.2f \n", resortTwoDayThree);

        System.out.printf("Thursday: %.2f \n", resortTwoDayFour);

        System.out.printf("Friday: %.2f \n", resortTwoDayFive);

        System.out.printf("Saturday: %.2f \n", resortTwoDaySix);

        System.out.printf("Sunday: %.2f \n", resortTwoDaySeven);

      }

      int oneGREATER = 0;
       // integer 'oneGREATER' set to 0
      int twoGREATER = 0;
       // integer 'twoGREATER' set to 0

      double resortOneTotalACC = 0.0; 
      // double 'resortOneTotalACC' set to 0
      double resortTwoTotalACC = 0.0; 
      // double 'resortTwoTotalACC' set to 0

      double[] resortONEdays = {
        resortOneDayOne,
        resortOneDayTwo,
        resortOneDayThree,
        resortOneDayFour,
        resortOneDayFive,
        resortOneDaySix,
        resortOneDaySeven}; // array resortONEdays that has double values initialized

      double[] resortTWOdays = {
        resortTwoDayOne,
        resortTwoDayTwo,
        resortTwoDayThree,
        resortTwoDayFour,
        resortTwoDayFive,
        resortTwoDaySix,
        resortTwoDaySeven}; // array resortTWOdays that has double values initialized

      for (int i = 0; i < resortONEdays.length; i++) { // for loop to loop inside the two arrays
        // adding each value in corresponding array to get the total

        resortOneTotalACC = resortOneTotalACC + resortONEdays[i]; 

        resortTwoTotalACC = resortTwoTotalACC + resortTWOdays[i];

        // if one resorts snowfall value is greater, than increase the counter
        if (resortONEdays[i] > resortTWOdays[i]) {
          
          oneGREATER++;

        } else if (resortTWOdays[i] > resortONEdays[i]) {

          twoGREATER++; // increasing the counter
        }
      }

      // displaying the information to the user

      System.out.printf("Total Accumulation: %.2f \n",(resortOneTotalACC + resortTwoTotalACC)); 
      // outputs the total accumulation of both resorts combined with the formatted value


      // outputs the total accumulation of each resort combined with the formatted values
      System.out.printf(resortOne + " Total Accumulation: %.2f \n", resortOneTotalACC);

      System.out.printf(resortTwo + " Total Accumulation: %.2f \n", resortTwoTotalACC);


      // calculating the average snowfall in each resort

      double resortOneAvg = (resortOneTotalACC / 7.0); // initalizing variable 'resortOneAvg' and setting it to the average of resort one

      double resortTwoAvg = (resortTwoTotalACC / 7.0); // initalizing variable 'resortTwoAvg' and setting it to the average of resort two

      // outputing the average accumulation for each resort
      System.out.printf(resortOne + " Average Accumulation: %.2f \n", resortOneAvg);

      System.out.printf(resortTwo + " Average Accumulation: %.2f \n",resortTwoAvg);

      // if the snowfall in one resort is greater than the other, the program will inform the user

      if (oneGREATER > twoGREATER) {

        System.out.println(resortOne + " had greater snowfall on more days than " + resortTwo + "!");

        // if resort one has more snowfall
      } else if (oneGREATER < twoGREATER) {

        System.out.println(resortTwo + " had greater snowfall on more days than " + resortOne + "!"); 

        // if resort two has more snowfall
      }


      
      // if one resort has the more snowfall on one day compared to its competitor, than the program will inform the user

      if (oneGREATER == 7) {

        System.out.println(resortOne + " is the undisputed winner!"); // if resort one has the more snow during every day of the week

      } else if (twoGREATER == 7) {

        System.out.println(resortTwo + " is the undisputed winner!"); // if resort two has the more snow during every day of the week

      }
  }
}
