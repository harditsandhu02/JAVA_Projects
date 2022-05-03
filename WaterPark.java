import java.util.ArrayList;
/**
 * This class implents the Park interface for the actual water park with each aspect
 * 
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 9 -- AmusementPark
 *
 * @author Hardit Sandhu
 * @version March 23, 2022
 */
public class WaterPark extends Object implements Park {

    private String name;
    private double admissionCost;
    private double land;
    private ArrayList<Ride> rides;
    private boolean indoor;
    private boolean outdoor;
    private boolean lazyRiver;
    private boolean wavePool;
    private boolean[] seasons;
    
    public WaterPark(
        String name, 
        double admissionCost,
        double land, 
        ArrayList<Ride> rides, 
        boolean indoor, 
        boolean outdoor, 
        boolean lazyRiver, 
        boolean wavePool, 
        boolean[] seasons) {

        this.name = name;
        this.admissionCost = admissionCost;
        this.land = land;
        this.rides = rides;
        this.indoor = indoor;
        this.outdoor = outdoor;
        this.lazyRiver = lazyRiver;
        this.wavePool = wavePool;
        this.seasons = seasons;
    }

    public boolean isLazyRiver() {
        boolean output = false;
        if (lazyRiver == true) {
            output = true;

        } else {
            output = false;
        }
        return output;
    }

    public void setLazyRiver(boolean lazyRiver) {
        this.lazyRiver = lazyRiver;
    }

    public boolean isWavePool() {
        boolean output = false;
        if (wavePool == true) {
            output = true;
        } else {
            output = false;
        }
        return output;
    }

    public void setWavePool(boolean wavePool) {
        this.wavePool = wavePool;
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
        try {
            ((Waterslide)ride).setSplashDepth(0.0);
            rides.add(ride);

        } catch (Exception e) {
            throw new WrongRideException("A waterpark can only have waterslide rides!");
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
        double newSplashDepth) {

        for (int i = 0; i < rides.size(); i++) {
            if (rides.get(i).equals(ride)) {
                Ride mane = rides.get(i);
                mane.setName(newName);
                mane.setColor(newColor);
                mane.setMinHeight(newMinheight);
                mane.setMaxRiders(newMaxRiders);
                ((Waterslide)mane).setSplashDepth(newSplashDepth);
                
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
        this.lazyRiver = false;
        this.wavePool = false;

    }
}
