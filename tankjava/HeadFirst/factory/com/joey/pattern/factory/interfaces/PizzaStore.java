package com.joey.pattern.factory.interfaces;

import com.joey.pattern.factory.entities.Pizza;

public abstract class PizzaStore {

	public Pizza orderPizza(String type) {
		Pizza pizza = createPizza(type);

		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();

		return pizza;
	}

	public abstract Pizza createPizza(String type);

}
