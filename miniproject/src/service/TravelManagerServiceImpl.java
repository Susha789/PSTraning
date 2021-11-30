package service;

import java.util.ArrayList;

import bean.Passenger;
import bean.TravelManager;
import persistance.TravelManagerDaoImpl;

public class TravelManagerServiceImpl implements TravelManagerService {
	
	private final TravelManagerDaoImpl travelerDao = new TravelManagerDaoImpl();

	public int getBusID(String src,String dest) {
		return travelerDao.getBusId(src, dest);
	}

	@Override
	public boolean checkForBusAvailability(String source, String destination) {
		return travelerDao.checkAvailability(source, destination);
	}

	@Override
	public ArrayList<TravelManager> listAllBuses() {
		return travelerDao.listAllBus();
	}

	@Override
	public ArrayList<Passenger> listAllPassengers() {
		return travelerDao.listAllPassenger();
	}

	@Override
	public boolean addPassenger(Passenger passenger) {
		return (travelerDao.addPassenger(passenger) == 1);
	}

}
