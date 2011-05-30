package com.joey.pattern.templates.entities;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoffeeWithHook extends CaffeineBeverageWithHook {

	public void brew() {
		System.out.println("Dripping Coffee through filter");
	}

	public void addCondiments() {
		System.out.println("Adding Sugar and Milk");
	}

	public boolean customerWantsCondiments() {
		String answer = getUserInput();

		return answer.toLowerCase().startsWith("y");
	}

	private String getUserInput() {
		String answer = null;

		System.out
				.println("Would you like milk and sugar with your coffee (y/n)?");

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		try {
			answer = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (answer == null) {
			return "n";
		}

		return answer;
	}

}
