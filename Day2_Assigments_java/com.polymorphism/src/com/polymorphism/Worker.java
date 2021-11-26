package com.polymorphism;

public class Worker {
	
	 String name;
	    int empNumber;

	    public Worker(String name, int empNumber) {
	        this.name = name;
	        this.empNumber = empNumber;
	    }

	    void show() {
	        System.out.println("\n--------------------------");
	        System.out.println("Employee number : " + empNumber);
	        System.out.println("Employee name : " + name);
	    }


}
