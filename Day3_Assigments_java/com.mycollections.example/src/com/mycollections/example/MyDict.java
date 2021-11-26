package com.mycollections.example;

import java.util.HashMap;

import java.util.Map;

import java.util.Scanner;

public class MyDict {

	public static void main(String[] args) {

		Map<String, String> english = new HashMap<String, String>();
        english.put("necessary", "Needed in order to achieve a particular result");
        english.put("importantly", "used for saying that a fact you are talking about is important");
        
        Scanner sc= new Scanner(System.in);
        System.out.print("Enter word: ");
        String a = sc.next();

        System.out.println("Meaning: " + english.get(a));

	}

}
