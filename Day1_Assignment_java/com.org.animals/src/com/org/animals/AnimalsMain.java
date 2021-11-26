package com.org.animals;

public class AnimalsMain {

	public static void main(String[] args) {
		
		Deer deer = new Deer();
		Elephant elephant = new Elephant();
		Lion lion = new Lion();
		Giraffe giraffe = new Giraffe();
		Monkey monkey = new Monkey();
		Tiger tiger = new Tiger();
		
		System.out.println("****Deer****");
		System.out.println("Color :" + deer.getColor());
		System.out.println("Age :" + deer.getAge());
		System.out.println("Weight: " + deer.getWeight());
		System.out.println("Vegetarian: " + deer.isVegetarian());
		System.out.println("Climb: " + deer.canClimb());
		System.out.println("Sound: " + deer.sound());
		

		System.out.println("****Elephant****");
		System.out.println("Color :" + elephant.getColor());
		System.out.println("Age :" + elephant.getAge());
		System.out.println("Weight: " + elephant.getWeight());
		System.out.println("Vegetarian: " + elephant.isVegetarian());
		System.out.println("Climb: " + elephant.canClimb());
		System.out.println("Sound: " + elephant.sound());

		System.out.println("****Lion****");
		System.out.println("Color :" + lion.getColor());
		System.out.println("Age :" + lion.getAge());
		System.out.println("Weight: " + lion.getWeight());
		System.out.println("Vegetarian: " + lion.isVegetarian());
		System.out.println("Climb: " + lion.canClimb());
		System.out.println("Sound: " + lion.sound());

		System.out.println("****Giraffe****");
		System.out.println("Color :" + giraffe.getColor());
		System.out.println("Age :" + giraffe.getAge());
		System.out.println("Weight: " + giraffe.getWeight());
		System.out.println("Vegetarian: " + giraffe.isVegetarian());
		System.out.println("Climb: " + giraffe.canClimb());
		System.out.println("Sound: " + giraffe.sound());

		System.out.println("****Monkey****");
		System.out.println("Color :" + monkey.getColor());
		System.out.println("Age :" + monkey.getAge());
		System.out.println("Weight: " + monkey.getWeight());
		System.out.println("Vegetarian: " + monkey.isVegetarian());
		System.out.println("Climb: " + monkey.canClimb());
		System.out.println("Sound: " + monkey.sound());

		System.out.println("****Tiger****");
		System.out.println("Color :" + tiger.getColor());
		System.out.println("Age :" + tiger.getAge());
		System.out.println("Weight: " + tiger.getWeight());
		System.out.println("Vegetarian: " + tiger.isVegetarian());
		System.out.println("Climb: " + tiger.canClimb());
		System.out.println("Sound: " + tiger.sound());

	}

}
