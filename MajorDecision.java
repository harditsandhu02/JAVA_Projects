import java.util.Scanner;
/**
 * This program will help the user decide which major is right for them based on a couple of 'yes or no' based questionsx
 *
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 04 -- Challenge
 *
 * @author Hardit Sandhu
 * @version February 7, 2021
 */
public class MajorDecision {
    public static final String WELCOME_MESSAGE = "Hi! Welcome to the major decider. Answer \"Yes\" or \"No\" to " +
            "our questions.";
    public static final String ALREADY_KNOW = "Do you know which major you want?";
    public static final String MATH = "Do you like math?";
    public static final String PEOPLE = "Do you like talking to people?";
    public static final String TEACHING = "Do you like teaching?";
    public static final String SCIENCES = "Do you like the sciences?";
    public static final String MONEY = "Do you think of ways to make money?";
    public static final String LANGUAGES = "Do you like languages?";
    public static final String ENGLISH = "Do you like English?";
    public static final String COMPUTERS = "Do you like using computers?";
    public static final String BUILDING = "Do you like building things?";
    public static final String GOODBYE_MESSAGE = "Thank you. Goodbye.";

    // ------------------------- DO NOT MODIFY ABOVE -------------------------
    
    // IMPLEMENT YOUR SOLUTION HERE

    public static void main(String[] args) {    // initializing the 'main' function

        Scanner scanner = new Scanner(System.in);   // initializing the scanner system
        String yornMath = "";   // string 'yes or no Math' to hold the furture string value from the switch selection
    
        System.out.println(WELCOME_MESSAGE);    // displaying the 'welcome message'
        System.out.println(ALREADY_KNOW);   // asking the user the first question
        String firstAnswer = scanner.nextLine(); // the program will then read the user's answer and store it

        // switch algorithm depending on the user's first answer
        switch (firstAnswer) {
            // if the user answers 'yes' then the program will end
            case "Yes": 
                System.out.println(GOODBYE_MESSAGE);
                break;
            case "yes": 
                System.out.println(GOODBYE_MESSAGE);
                break;
            // however if the user answers 'no', then the program will continue
            case "No": 
                System.out.println(MATH);
                yornMath = scanner.nextLine();
                break;
            case "no": 
                System.out.println(MATH);
                yornMath = scanner.nextLine();
                break;
            // if nothing or the wrong thing is answered
            default: 
                System.out.println(GOODBYE_MESSAGE); // the program will output or display the 'goodbye message'
                break;	
        }

        // first block of if and else statements runs through the 'left' side of the flowchart
        if(yornMath.equals("yes") | yornMath.equals("Yes")){
            System.out.println(COMPUTERS);
            String yornComp = scanner.nextLine(); // reading the user's input and storing it in a string
            if(yornComp.equals("yes") | yornComp.equals("Yes")){
                System.out.println("Computer Science");
            } else if(yornComp.equals("no") | yornComp.equals("No")){
                System.out.println(BUILDING);
                String yornBuild = scanner.nextLine();  // reading the user's input and storing it in a string
                if (yornBuild.equals("yes") | yornBuild.equals("Yes")){
                    System.out.println("Engineering");
                } else if (yornBuild.equals("no") | yornBuild.equals("No")){
                    System.out.println(SCIENCES);
                    String yornSci = scanner.nextLine();    // reading the user's input and storing it in a string
                    if(yornSci.equals("yes") | yornSci.equals("Yes")){
                        System.out.println("Natural Sciences");
                    } else if (yornSci.equals("no") | yornSci.equals("No")){
                        System.out.println("Math");
                    }
                }
            } 
        // the second block of if statements runs through the 'middle' of the flowchart
        } else if (yornMath.equals("no") | yornMath.equals("No")){
            System.out.println(PEOPLE);
            String yornPeop = scanner.nextLine();   // reading the user's input and storing it in a string
            if(yornPeop.equals("yes") | yornPeop.equals("Yes")){
                System.out.println(TEACHING);
                String yornTech = scanner.nextLine();   // reading the user's input and storing it in a string
                if (yornTech.equals("yes") | yornTech.equals("Yes")){
                    System.out.println("Education");
                } else if(yornTech.equals("no") | yornTech.equals("No")){
                    System.out.println(SCIENCES);
                    String yornSciTwo = scanner.nextLine();    // reading the user's input and storing it in a string
                    if(yornSciTwo.equals("yes") | yornSciTwo.equals("Yes")){
                        System.out.println("Medicine");
                    } else if (yornSciTwo.equals("no") | yornSciTwo.equals("No")){
                        System.out.println(MONEY);
                        String yornMon = scanner.nextLine();    // reading the user's input and storing it in a string
                        if(yornMon.equals("yes") | yornMon.equals("Yes")){
                            System.out.println("Business");
                        } else if (yornMon.equals("no") | yornMon.equals("No")){ 
                            System.out.println("Psychology");
                        }
                    }
                }
            // this sub-block of if and else statements runs through the 'right' side of the flowchart
            } else if(yornPeop.equals("no") | yornPeop.equals("No")){
                System.out.println(LANGUAGES);
                String yornLang = scanner.nextLine(); // reading the user's input and storing it in a string
                if (yornLang.equals("no") | yornLang.equals("No")){
                    System.out.println("Art");
                } else {
                    System.out.println(ENGLISH);
                    String yornEng = scanner.nextLine(); // reading the user's input and storing it in a string
                    if(yornEng.equals("yes") | yornEng.equals("Yes")){
                        System.out.println("English");
                    } else {
                        System.out.println("Foreign Languages");
                    }
                }
            }
        }
    }
}