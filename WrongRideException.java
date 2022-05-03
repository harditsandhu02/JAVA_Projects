/**
 * This class is an error exception if the ride is not an rollercoaster
 * 
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 9 -- WrongRideException
 *
 * @author Hardit Sandhu
 * @version March 23, 2022
 */
public class WrongRideException extends Exception {
    
    public WrongRideException() {
        super("An amusement park can only have rollercoaster rides");
    }
    public WrongRideException(String message) {
        super(message);
    }
}
