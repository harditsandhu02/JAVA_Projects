import java.util.ArrayList;
/**
 * This interface provides the set of each park's specifications that other classes must implement. 
 * 
 * Purdue University -- CS18000 -- Spring 2022 -- Homework 9 -- Park
 *
 * @author Hardit Sandhu
 * @version March 23, 2022
 */
public interface Park {
    
    public void addRide(Ride ride)  throws WrongRideException;
    public void close();
    public void enlarge(
        double addedLand, 
        double maxLand, 
        boolean addedIndoor, 
        boolean addedOutdoor) 
        throws SpaceFullException;
    public double getAdmissionCost();
    public double getLand();
    public String getName();
    public ArrayList<Ride> getRides();
    public boolean[] getSeasons();
    public boolean isIndoor();
    public boolean isOutdoor();
    public void removeRide(Ride ride);
    public void setAdmissionCost(double admissionCost);
    public void setName(String name);
    public void setSeasons(boolean[] seasons);
    
    
}