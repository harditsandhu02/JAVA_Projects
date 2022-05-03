import java.util.ArrayList;
/**
 * This class implents the Park interface for the actual amusment park with each aspect
 * 
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 9 -- AmusementPark
 *
 * @author Hardit Sandhu
 * @version March 23, 2022
 */
public class AmusementPark extends Object implements Park {

    private String name;
    private double admissionCost;
    private boolean arcade;
    private boolean bowling;
    private boolean indoor;
    private double land;
    private boolean outdoor;
    private ArrayList<Ride> rides;
    private boolean[] seasons;
    
    public AmusementPark(
        String name, 
        double admissionCost, 
        double land, 
        ArrayList<Ride> rides, 
        boolean indoor, 
        boolean outdoor, 
        boolean arcade, 
        boolean bowling, 
        boolean[] seasons) {

        this.name = name;
        this.admissionCost = admissionCost;
        this.land = land;
        this.rides = rides;
        this.indoor = indoor;
        this.outdoor = outdoor;
        this.arcade = arcade;
        this.bowling = bowling;
        this.seasons = seasons;
    }

    public boolean isArcade() {
        boolean output = false;
        if (arcade == true) {
            output = true;

        } else {
            output = false;
        }
        return output;
    }

    public void setArcade(boolean arcade) {
        this.arcade = arcade;
    }

    public boolean isBowling() {
        boolean output = false;
        if (bowling == true) {
            output = true;

        } else {
            output = false;
        }
        return output;
    }

    public void setBowling(boolean bowling) {
        this.bowling = bowling;
    }

    public double getAdmissionCost() {
        return admissionCost;
    }

    public void setAdmissionCost(double admissionCost) {
        this.admissionCost = admissionCost;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getLand() {
        return land;
    }

    public void addRide(Ride ride) throws WrongRideException {
        // if ride is not a rollercoaster, throw a WrongRideException
        try {
            ((Rollercoaster)ride).setSimulated(true);
            rides.add(ride);
            

        } catch (Exception e) {
            throw new WrongRideException("An amusement park can only have rollercoaster rides");
        } 

    
    }

    public void removeRide(Ride ride) {
        rides.remove(ride);
    }

    public ArrayList<Ride> getRides() {
        return rides;
    }

    public boolean isIndoor() {
        boolean output = false;
        if (indoor == true) {
            output = true;

        } else {
            output = false;
        }
        return output;
    }

    public boolean isOutdoor() {
        boolean output = false;
        if (outdoor == true) {

            output = true;

        } else {
            output = false;
        }
        return output;
    }

    public void setSeasons(boolean[] seasons) {
        this.seasons = seasons;
    }
    
    public boolean[] getSeasons() {
        return seasons;
    }

    public void enlarge(
        double addedLand, 
        double maxLand, 
        boolean addedIndoor, 
        boolean addedOutdoor) 
        throws SpaceFullException {

        if (land > maxLand) {
            throw new SpaceFullException("There is no more land to use for this park!");

        } else if ((addedLand + land) > maxLand) {
            throw new SpaceFullException("There is no more land to use for this park!");

        } else {

            if (addedIndoor == true) {
                indoor = true;
    
            }
            if (addedOutdoor == true) {
                outdoor = true;
            }

            land = land + addedLand;

        }

    }

    public void modifyRide(

        Ride ride, 
        String newName, 
        String newColor, 
        int newMinheight, 
        int newMaxRiders, 
        boolean newSimulated) {

        for (int i = 0; i < rides.size(); i++) {
            if (rides.get(i).equals(ride)) {
                Ride mane = rides.get(i);
                mane.setName(newName);
                mane.setColor(newColor);
                mane.setMinHeight(newMinheight);
                mane.setMaxRiders(newMaxRiders);
                ((Rollercoaster)mane).setSimulated(newSimulated);
                
            }
        }


    }

    public void close() {
        this.name = "";
        this.admissionCost = 0.0;
        this.land = 0.0;
        this.rides = null;
        this.seasons = null;
        this.indoor = false;
        this.outdoor = false;
        this.arcade = false;
        this.bowling = false;

    }
    
}