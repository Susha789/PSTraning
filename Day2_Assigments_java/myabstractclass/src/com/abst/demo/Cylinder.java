package com.abst.demo;

public class Cylinder extends Shape3D {
	
	private int radi, height;

	public Cylinder(int radiFromMain, int heightFromMain) {
		super();
		this.radi = radiFromMain;
		this.height = heightFromMain;
	}

	public double volume() {
	
		return 3.142 * radi * radi * height;
	}
	
	public double surfacearea() {
		
		return 2 * 3.142 * radi * height + 2 * 3.142 * radi * radi;
	}


}
