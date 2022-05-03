/**
 * This class is for each Rollercoaster and it's color, name, height requirement, max number of riders, and if it is
 * simulated
 * 
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 9 -- Rollercoaster
 *
 * @author Hardit Sandhu
 * @version March 23, 2022
 */
public class Rollercoaster extends Ride {

    private boolean simulated;

    public Rollercoaster(String name, String color, int minHeight, int maxRiders, boolean simulated) {

        super(name, color, minHeight, maxRiders);
        this.simulated = simulated;

    }
    
    public boolean isSimulated() {
        return simulated;
    }

    public void setSimulated(boolean simulated) {
        this.simulated = simulated;
    }

    @Override
    public boolean equals(Object o) {

        boolean output = false;
        if (o == this) {
            return true;
            
        } 
        if (!(o instanceof Rollercoaster)) {
            return false;
        
        }

        Rollercoaster temp = (Rollercoaster) o;

        if (((getName()).equals(temp.getName())) && 
            ((getColor()).equals(temp.getColor())) && 
            ((getMinHeight()) == (temp.getMinHeight())) && 
            ((getMaxRiders()) == (temp.getMaxRiders())) && 
            ((isSimulated() == temp.isSimulated()))) {

            output = true;
            
        }

        return output;
    }

    public String toString() {

        String simulatedNEW = Boolean.toString(isSimulated());
        return super.toString() + 
            "\nSimulated: " + 
            simulatedNEW;
    }

}
