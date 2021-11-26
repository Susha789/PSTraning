package com.abst.demo;

public class Cube extends Shape3D {
	
	private int side;

	public Cube(int side) {
		super();
		
		this.side = side;
	
	}
	
	public double volume() {
		
		return side * side * side;
		
	}
	

	
public double surfacearea() {
		
		return 6 * side * side;
	
	}
}
