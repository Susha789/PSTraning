package presentation;

import java.util.ArrayList;
import java.util.Scanner;

import bean.Element;
import service.ElementService;
import service.ElementServiceImpl;

public class ElementPresentationImpl implements ElementPresentation {

	private ElementService elementService = new ElementServiceImpl();

	@Override
	public void showMenu() {
		
		System.out.println("Elements in the Table");
		System.out.println("==================================");
		System.out.println("1. List All The Elements");
		System.out.println("2. Get the Element By Atomic number ");
		System.out.println("3. Add Element ");
		System.out.println("4. Delete Element");
		System.out.println("5. Update the Element By Atomic number");
		System.out.println("6. Exit");
		System.out.println("==================================");

		
		
	}

	@Override
	public void performMenu(int choice) {
		
		Scanner scanner=new Scanner(System.in);
		
		switch(choice) {
		case 1:
			ArrayList<Element> elementList = elementService.readElement();
			for(Element ele : elementList) {
				System.out.println(ele);
			}
			break;
		case 2:
			System.out.println("Enter Element atomic number to be searched for : ");
			String atomicNumber = scanner.next();
			Element element = elementService.getElementByAtomicNumber(Integer.parseInt(atomicNumber));
			if(element != null)
				System.out.println(element);
			else
				System.out.println("Element with atomic number "+ atomicNumber +" does not exist!");
			break;
		case 3:
			System.out.println("Enter Element Atomic Number : ");
			String an=scanner.next();
			System.out.println("Enter Element Weight : ");
			String aw=scanner.next();
			System.out.println("Enter Element Name: ");
			String name=scanner.next();
			System.out.println("Enter Element Chemical Symbol: ");
			String cs=scanner.next();
			
			Element newElement = new Element(Integer.parseInt(an), aw, name, cs);
			if(elementService.insertElement(newElement))
				System.out.println("RECORD ADDED!");
			else
				System.out.println("RECORD NOT ADDED!");
			break;
		case 4:
			System.out.println("Enter Element Atomic Number to be deleted : ");
			String atomicNumberToDelete = scanner.next();
			
			if(elementService.deleteElement(Integer.parseInt(atomicNumberToDelete)))
				System.out.println("RECORD DELETED!");
			else
				System.out.println("RECORD NOT DELETED!");
			break;

		case 5:
			System.out.println("Enter Element Atomic Number to update Atomic Weight  : ");
			String id = scanner.next();
			System.out.println("Enter new atomic weight  : ");
			String weight = scanner.next();
			
			if(elementService.updateElement(Integer.parseInt(id), weight))
				System.out.println("Element Updation Successful!");
			else
				System.out.println("Element Updation Failed!");
			break;
		case 6:
			System.out.println("Thanks for Using our System");
			System.exit(0);
		default:
			System.out.println("Invalid Choice");
		}

	}
		
	}


