package presentation;

import java.util.ArrayList;
import java.util.Scanner;

import bean.Passenger;
import bean.TravelManager;
import service.TravelManagerServiceImpl;

public class TravelManagerPresentationImpl implements TravelManagerPresentation {
	
	TravelManagerServiceImpl travelerService = new TravelManagerServiceImpl();
	Scanner scanner = new Scanner(System.in);

	@Override
	public void showMenu() {
		System.out.println("\nTraveler Management System");
		System.out.println("==================================");
		System.out.println("1. List All Buses");
		System.out.println("2. List All Passengers");
		System.out.println("3. Check Bus Availability ");
		System.out.println("4. Add Passenger");
		System.out.println("5. Exit");
		System.out.println("==================================\n");

	}

	@Override
	public void performMenu(int choice) {
		switch (choice) {
			case 1:
				ArrayList<TravelManager> list = travelerService.listAllBuses();
				for (TravelManager t : list)
					System.out.println(t);
				break;
			case 2:
				ArrayList<Passenger> list2 = travelerService.listAllPassengers();
				for (Passenger t : list2)
					System.out.println(t);
				break;
			case 3:
				System.out.println("Enter Source: ");
				String source = scanner.next();
				System.out.println("Enter Destination: ");
				String destination = scanner.next();
				boolean check = travelerService.checkForBusAvailability(source, destination);
				if (check)
					System.out.println("Tickets are available for this bus, your bus id is " + travelerService.getBusID(source, destination));
				else
					System.out.println("Ticket not available!");
				break;
			case 4:
				System.out.println("Enter Your Name: ");
				String name = scanner.next();
				System.out.println("Source: ");
				String src2 = scanner.next();
				System.out.println("Destination: ");
				String dest2 = scanner.next();
				if (!travelerService.checkForBusAvailability(src2, dest2)) {
					System.out.println("No Buses are available on this route!");
					break;
				}
				int id = 0;
				System.out.println("Please provide your ID (Unique): ");
				int pid = scanner.nextInt();
				System.out.println("Please provide your age: ");
				int age = scanner.nextInt();
				Passenger passenger = new Passenger(name, src2, dest2, id, age, pid);
				if (travelerService.addPassenger(passenger))
					System.out.println("Passenger added successfully!");
				else
					System.out.println("Can't Add Passenger!");
				break;
			case 5:
				System.out.println("Thank you! for using our services");
				System.exit(0);
			default:
				System.out.println("invalid choice");


		}

	}

}
