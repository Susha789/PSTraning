package com.polymorphism;

public class WorkerMain {
	
	public static void main(String[] args)
    {
        DailyWorkers dailyWorkers = new DailyWorkers("Sushmita",1296,75);
        SalariedWorker salariedWorker = new SalariedWorker("Sushma",976,100);
        dailyWorkers.Pay(45);
        salariedWorker.Pay();
    }
	
}
