package com.inheritance.part1;

public class City {

	private Vehicle vehicle;
	
	public City(Vehicle vehicle) {
		super();
		this.vehicle = vehicle;
	}

	public void details() {
		vehicle.display(vehicle);
	}
	
}
