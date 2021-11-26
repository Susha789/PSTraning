package com.abst.demo;

public class MainShape3D {

	public static void main(String[] args) {

		System.out.println("**************Cylinder****************");
		
		Cylinder cylinder = new Cylinder(1, 2);

		System.out.println("Volume of cylinder is :  " + cylinder.volume());
		
		System.out.println("SurfaceArea of cylinder is : " + cylinder.surfacearea());
		
		System.out.println("***************Sphere****************");
		
		Sphere sphere = new Sphere(4);
		
		System.out.println("volume of Sphere is : " + sphere.volume());
		
		System.out.println("SurfaceArea of Sphere is : " + sphere.surfacearea());
		
		
		System.out.println("*****************Cube*****************");
		
		
		Cube cube = new Cube(6);
		
        System.out.println("volume of Cube is : " + cube.volume());
		
		System.out.println("SurfaceArea of Cube is : " + cube.surfacearea());
		
		
		
		
	}

}
