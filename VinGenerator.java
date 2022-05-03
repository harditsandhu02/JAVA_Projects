import java.util.Scanner;
/**
 * Homework 3 -- Challenge ('VinGenerator')
 *
 * This program will accept multiple user inputs 
 * and output the adjusted information as well as the "VIN" number
 *
 * @author Hardit Sandhu, lab sec L13
 *
 * @version Janurary 29, 2022
 *
 */
public class VinGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Make:");
        String carMake = scanner.nextLine();
        
        System.out.println("Model:");
        String carModel = scanner.nextLine();
        
        System.out.println("Model Year:");
        int modelYr = scanner.nextInt();
        
        System.out.println("New Car?");
        boolean newCar = scanner.nextBoolean();
        
        System.out.println("Avg. Rating:");
        double avgRating = scanner.nextDouble();
        
        System.out.println("Price:");
        int lline = scanner.nextInt();
        String temp = scanner.nextLine();

        System.out.println("Dealership:");
        String dealer = scanner.nextLine();

        System.out.println("Phone Number:");
        String sline = scanner.nextLine();
        
        System.out.println("Serial Number:");
        String serialNumber = scanner.nextLine();
        
        System.out.println(modelYr + " " + carMake + " " + carModel);
        System.out.println("New Car?: " + newCar);
        System.out.printf("Avg. Rating: %.1f \n", avgRating); 
        System.out.println("Price: " + "$" + lline);
        System.out.println("Dealership: " + dealer);
        System.out.println("Phone Number: " + "(" + 
            sline.substring(0,3) + ")" + sline.substring(3,6) + 
            "-" + sline.substring(6,10));
        System.out.println("Serial Number: " + serialNumber);


        String s = Integer.toString(modelYr);
        String stage1 = s.substring(0,2);


        char ch1UP = Character.toUpperCase(carMake.charAt(0));
        String serial = String.valueOf(String.valueOf(serialNumber).charAt(0));
        int firstDigit = Integer.parseInt(serial);
        int finalch1 = (int)ch1UP + firstDigit;
        char stage2 = (char)finalch1;



        char ch2UP = Character.toUpperCase(carMake.charAt(carMake.length()-1));
        int finalch2 = (int)ch2UP + firstDigit;
        char stage3 = (char)finalch2;

        char ch1LOW = Character.toLowerCase(carMake.charAt(0));
        String serial2 = String.valueOf(String.valueOf(serialNumber).charAt(1));
        int secondDigit = Integer.valueOf(serial2);
        int finalch1LOW = (int)ch1LOW + secondDigit;
        char stage4 = (char)finalch1LOW;

        char ch2LOW = Character.toLowerCase(carMake.charAt(carMake.length()-1));
        int finalch2LOW = (int)ch2LOW + secondDigit;
        char stage5 = (char)finalch2LOW;

        char re1 = Character.toUpperCase(carModel.charAt(0));
        String newserial = String.valueOf(String.valueOf(serialNumber).charAt(0));
        int fDigit = Integer.valueOf(newserial);
        int final1 = (int)re1 + fDigit;
        char stage6 = (char)final1;

        char re2 = Character.toUpperCase(carModel.charAt(carModel.length()-1));
        int finalch2L = (int)re2 + fDigit;
        char stage7 = (char)finalch2L;

        char re3 = Character.toLowerCase(carModel.charAt(0));
        String newserial2 = String.valueOf(String.valueOf(serialNumber).charAt(1));
        int sDigit = Integer.valueOf(newserial2);
        int final1LOW = (int)re3 + sDigit;
        char stage8 = (char)final1LOW;

        char re4 = Character.toLowerCase(carModel.charAt(carModel.length()-1));
        int final2LOW = (int)re4 + sDigit;
        char stage9 = (char)final2LOW;

        String naw = String.valueOf(serialNumber);
        String newNUM = naw.substring(naw.length()-4,naw.length());

        String FinalVIN = stage1 + stage2 + stage3 + stage4 + stage5 + stage6 + stage7 + stage8 + stage9 + newNUM;

        System.out.println("VIN: " + FinalVIN);
    }  
}