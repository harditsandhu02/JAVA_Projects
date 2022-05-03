/**
 * This class is for each Waterslide and it's color, name, height requirement, max number of 
 * riders, and its splash depth
 * 
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 9 -- Rollercoaster
 *
 * @author Hardit Sandhu
 * @version March 23, 2022
 */
public class Waterslide extends Ride {

    private double splashDepth;

    public Waterslide(
        String name, 
        String color, 
        int minHeight, 
        int maxRiders, 
        double splashDepth) {

        super(name, color, minHeight, maxRiders);
        this.splashDepth = splashDepth;
    }
    
    public double getSplashDepth() {
        return splashDepth;
    }

    public void setSplashDepth(double splashDepth) {
        this.splashDepth = splashDepth;
    }

    @Override
    public boolean equals(Object o) {

        boolean output = false;
        if (o == this) {
            return true;
        } 
        if (!(o instanceof Waterslide)) {
            return false;
        }

        Waterslide temp = (Waterslide) o;

        if (((getName()).equals(temp.getName())) && 
            ((getColor()).equals(temp.getColor())) && 
            ((getMinHeight()) == (temp.getMinHeight())) && 
            ((getMaxRiders()) == (temp.getMaxRiders())) && 
            ((getSplashDepth() == temp.getSplashDepth()))) {

            output = true;
        }

        return output;
    }

    public String toString() {

        String splashdepth = String.format("%.1f", getSplashDepth());

        return super.toString() + 
            "\nSplashDepth: " + 
            splashdepth + " feet";
    }

}
