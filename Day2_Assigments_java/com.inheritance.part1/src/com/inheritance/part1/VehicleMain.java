package com.inheritance.part1;


public class VehicleMain {

	public static void main(String[] args) {

		Car car = new Car("white", "honda", 4, 6);
		
		System.out.println("============CAR============");
		
		System.out.println("Car's colour :"+car.getColor()); 
		System.out.println("Car's Model :"+car.getModel());
		System.out.println("No. of wheels in Car : "+car.getNoOfwheels());
		System.out.println("No. of AirBags in Car : "+car.getAirBags());
		
		
		Truck truck = new Truck("orange", "Mahindra", 4, 2);
	
		System.out.println("\n===========Truck===========");
		
		System.out.println("Truck's colour : "+truck.getColor()); 
		System.out.println("Truck's Model : "+truck.getModel());
		System.out.println("No. of wheels in Truck : "+truck.getNoOfwheels());
		System.out.println("No. of AirBags in Truck : "+truck.getAirBags());
		
		Bus bus = new Bus("Red", "Tata", 4, 0);
		
		System.out.println("\n=============Bus============");
		
		System.out.println("Bus's colour : "+bus.getColor()); 
		System.out.println("Bus's Model : "+bus.getModel());
		System.out.println("No. of wheels in Bus : "+bus.getNoOfwheels());
		System.out.println("No. of AirBags in Truck : "+bus.getAirBags());
		
		
		
		System.out.println("\n=============ROAD============");
		
		Road road = new Road(bus, car, truck);
	
		road.drive();
	
		System.out.println("\n=============CITY============");
		

		City city = new City(bus);
		city.details();	
		
		City city2 = new City(car);
		city2.details();	
		
		City city3 = new City(truck);
		city3.details();	
		
		
	}

	


}
