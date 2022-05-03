import java.util.Scanner;
/**
 * Homework 3 -- Walkthrough ('CarInfo')
 *
 * This program will
 *
 * @author Hardit Sandhu, lab sec L13
 *
 * @version Janurary 27, 2022
 *
 */
public class WalkthroughHM3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Asking the user for the car's name
        System.out.println("Enter car's make:");
        String carMake = scanner.nextLine();
        
        // Asking the user for the car's model
        System.out.println("Enter car's model");
        String carModel = scanner.nextLine();
        
        // Asking the user for the car's highway and city MPG
        System.out.println("Enter car's highway and city MPG:");
        int highway = scanner.nextInt();
        int city = scanner.nextInt();
        
        // Asking the user for the car's ratings of its preformance and comfort
        System.out.println("Enter car's ratings of performance and comfort:");
        double performance = scanner.nextDouble();
        double comfort = scanner.nextDouble();
        
        
        // Finally, the program outputs the values with labels
        System.out.println("Make: " + carMake);
        System.out.println("Model: " + carModel);
        System.out.println("Highway MPG: " + highway);
        System.out.println("City MPG: " + city);
        
        // Formating this one to reduce it to a single decimal place
        System.out.printf("Performance Rating: %.1f \n" +
                "Comfort Rating: %.2f \n"
                , performance, comfort);
    }
}


