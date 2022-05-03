/**
 * This class is an error exception for the max land availble for the park
 * 
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 9 -- SpaceFullException
 *
 * @author Hardit Sandhu
 * @version March 23, 2022
 */
public class SpaceFullException extends Exception {

    public SpaceFullException() {
        super("There is no more land to use for this park!");
    }
    public SpaceFullException(String message) {
        super(message);
    }
    
    
}
