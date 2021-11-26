package com.inheritance.part1;

public class Road {

	private Bus bus;
	private Car car;
	private Truck truck;
	
	public Road(Bus bus, Car car, Truck truck) {
		super();
		this.bus = bus;
		this.car = car;
		this.truck = truck;
	}

	public void drive() {
		System.out.println(
				
				"\n Car of model " + car.getModel() +
				" Bus of model " + bus.getModel() +
				" Truck of model " + truck.getModel() + 
				" running on road ...."
				
				);
	}
	
}
	
	
	
	

