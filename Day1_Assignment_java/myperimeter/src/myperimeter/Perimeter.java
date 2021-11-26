package myperimeter;

public class Perimeter {

	public void perimeter(int length, int breadth) {
		int perimeter = 2 * length * breadth;
		System.out.println("Perimeter of Rectangle : " + perimeter);
	}
	
	
	public void perimeter(int side) {
		int perimeter = 4* side;
		System.out.println("Perimeter of Square : " + perimeter);
	}
	
	public void perimeter(double radius) {
		double perimeter = 2 * 3.142 * radius;
		System.out.println("Perimeter of Circle : "+ perimeter);
		
	}

}
