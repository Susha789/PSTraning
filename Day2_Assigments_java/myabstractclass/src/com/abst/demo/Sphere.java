package com.abst.demo;

public class Sphere extends Shape3D {
	
	
	private int radi;

	public Sphere(int radi) {
		super();
		
		this.radi = radi;
		
	}
	
	
	public double volume() {
		
		return 4 * 3.142 * radi * radi / 3;
		
		
		}
	
	
	public double surfacearea() {
		
		return 4 * 3.142 * radi;
	
	}
	

}
