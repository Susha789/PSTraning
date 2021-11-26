package com.polymorphism;

public class DailyWorkers extends Worker {
	
	int rate;

    public DailyWorkers(String name, int empNumber, int rate) {
        super(name, empNumber);
        this.rate = rate;
    }

    void Pay(int numberOfHours)
    {
        show();
        System.out.println("Salary : " + rate * numberOfHours );
    }

}
