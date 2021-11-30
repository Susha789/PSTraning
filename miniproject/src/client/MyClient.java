package client;

import java.util.Scanner;

import presentation.TravelManagerPresentationImpl;

public class MyClient {
	
	public static void main(String[] args) {
		
        TravelManagerPresentationImpl travelerPresentation = new TravelManagerPresentationImpl();
        Scanner sc = new Scanner(System.in);
        while (true) {
            travelerPresentation.showMenu();
            System.out.println("Enter your Choice: ");
            int choice = sc.nextInt();
            travelerPresentation.performMenu(choice);
        }

    }

}
