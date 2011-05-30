package com.joey.pattern.decoration;

import com.joey.pattern.decoration.interfaces.Beverage;
import com.joey.pattern.decoration.interfaces.impl.Espresso;
import com.joey.pattern.decoration.interfaces.impl.HouseBlend;
import com.joey.pattern.decoration.interfaces.impl.Mocha;

public class Main {

	public static void main(String[] args) {
		Beverage beverage = new Espresso();
		System.out.println(beverage.getDescription() + " $" + beverage.cost());

		Beverage beverage2 = new HouseBlend();
		beverage2 = new Mocha(beverage2);
		beverage2 = new Mocha(beverage2);
		System.out
				.println(beverage2.getDescription() + " $" + beverage2.cost());
	}

}
