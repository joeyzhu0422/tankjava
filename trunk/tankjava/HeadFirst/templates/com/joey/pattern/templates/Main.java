package com.joey.pattern.templates;

import com.joey.pattern.templates.entities.CoffeeWithHook;
import com.joey.pattern.templates.entities.TeaWithHook;

public class Main {

	public static void main(String[] args) {
		
		TeaWithHook teaWithHook = new TeaWithHook();
		CoffeeWithHook coffeeWithHook = new CoffeeWithHook();
		
		System.out.println("Making tea...");
		teaWithHook.prepareRecipe();
		
		
		System.out.println("Making coffee");
		coffeeWithHook.prepareRecipe();
		
	}
}
