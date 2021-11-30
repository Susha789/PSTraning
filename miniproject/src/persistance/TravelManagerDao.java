package persistance;

import java.util.ArrayList;

import bean.Passenger;
import bean.TravelManager;

public interface TravelManagerDao {
	
	ArrayList<TravelManager> listAllBus();

    ArrayList<Passenger> listAllPassenger();

    boolean checkAvailability(String source, String destination);

    int addPassenger(Passenger passenger);

}
