/**
 * This class is for each ride for the park.
 * 
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 9 -- Ride
 *
 * @author Hardit Sandhu
 * @version March 23, 2022
 */
public class Ride extends Object {
    private String color;
    private int maxRiders;
    private int minHeight;
    private String name;


    public Ride() {
        this.name = "";
        this.color = "";
        this.minHeight = 0;
        this.maxRiders = 0;
    }

    public Ride(String name, String color, int minHeight, int maxRiders) {
        this.name = name;
        this.color = color;
        this.minHeight = minHeight;
        this.maxRiders = maxRiders;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    
    public int getMinHeight() {
        return minHeight;
    }

    public void setMinHeight(int minHeight) {
        this.minHeight = minHeight;
    }

    public int getMaxRiders() {
        return maxRiders;
    }

    public void setMaxRiders(int maxRiders) {
        this.maxRiders = maxRiders;
    }



    @Override
    public boolean equals(Object o) {

        boolean output = false;
        if (o == this) {
            return true;
        } 
        if (!(o instanceof Ride)) {
            return false;
            
        }

        Ride temp = (Ride) o;

        if (((getName()).equals(temp.getName())) && 
            ((getColor()).equals(temp.getColor())) && 
            ((getMinHeight()) == (temp.getMinHeight())) && 
            ((getMaxRiders()) == (temp.getMaxRiders()))) {

            output = true;
            System.out.println("ride");
        }

        return output;

    }

    //@Override
    public String toString() {

        String minH=Integer.toString(this.getMinHeight());
        String maxR = Integer.toString(this.getMaxRiders());

        String finalNOW = "";

        finalNOW = "Name: " + this.getName() + 
            "\nColor: " + this.getColor() + 
            "\nMinHeight: " + minH + 
            " inches" + "\nMaxRiders: " + maxR;

        return finalNOW;
    }

    
}
