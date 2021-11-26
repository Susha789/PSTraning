package com.myexception.example;

public class Employee {

	public static void main(String[] args) throws NameException, AgeException {

        String oldName = "Sushmita";
        String newName = "Sushmita k";
        int Age = 25;

        System.out.println("Employee Details :");

        if (oldName == newName) {
            throw new NameException();
        }

        if (Age < 0) {
            throw new AgeException("Age can not be negative !");
        } else if (Age <= 18) {
            throw new AgeException("Age must be grater then 18 !");
        } else if (Age >= 60){
            throw new AgeException("Age must be less then 60 !");
        }

        System.out.println("New Name : "+newName);
   	 
   	 System.out.println("Age : "+Age);
        
        
    }

	

}
