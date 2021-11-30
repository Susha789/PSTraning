package service;

import java.util.ArrayList;

import bean.Passenger;
import bean.TravelManager;

public interface TravelManagerService {
	
	boolean checkForBusAvailability(String source, String destination);
    ArrayList<TravelManager> listAllBuses();
    ArrayList<Passenger> listAllPassengers();
    boolean addPassenger(Passenger passenger);

}
