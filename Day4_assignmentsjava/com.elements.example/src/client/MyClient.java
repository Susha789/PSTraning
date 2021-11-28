package client;

import java.util.Scanner;

import presentation.ElementPresentation;
import presentation.ElementPresentationImpl;

public class MyClient {
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		ElementPresentation elementPresentation = new ElementPresentationImpl();
		while(true) {
			elementPresentation.showMenu();
			System.out.println("Enter choice : ");
			int choice=scanner.nextInt();
			elementPresentation.performMenu(choice);
		}

	}
}
