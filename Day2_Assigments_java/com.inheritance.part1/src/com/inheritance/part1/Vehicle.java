package com.inheritance.part1;

public class Vehicle {
	
	private String color;
	private String model;
	private int noOfwheels;
	private int airBags;
	
	
	public Vehicle(String color, String model, int noOfwheels, int airBags) {
		super();
		this.color = color;
		this.model = model;
		this.noOfwheels = noOfwheels;
		this.airBags = airBags;
	}

	public String getColor() {
		return color;
	}

	public String getModel() {
		return model;
	}

	public int getNoOfwheels() {
		return noOfwheels;
	}

	public int getAirBags() {
	
		return airBags;
		
	
	
	}
		
	public void display(Vehicle myvehicle) {
		
		System.out.println("Sneha is driving "+myvehicle.getModel()+
							" which is of colour " + myvehicle.getColor()); 
		
		
		
	}
	
		
	}
	
	

