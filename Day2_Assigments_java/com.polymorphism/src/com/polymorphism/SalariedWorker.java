package com.polymorphism;

public class SalariedWorker extends Worker {
	
	 int rate;

	    public SalariedWorker(String name, int empNumber, int rate) {
	        super(name, empNumber);
	        this.rate = rate;
	    }

	    void Pay()
	    {
	        show();
	        System.out.println("Salary : " + rate * 40);
	    }
	

}
