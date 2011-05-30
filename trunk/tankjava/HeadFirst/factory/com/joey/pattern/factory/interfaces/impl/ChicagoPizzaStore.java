package com.joey.pattern.factory.interfaces.impl;

import com.joey.pattern.factory.entities.ChicagoStyleCheesePizza;
import com.joey.pattern.factory.entities.Pizza;
import com.joey.pattern.factory.interfaces.PizzaStore;

public class ChicagoPizzaStore extends PizzaStore {

	public Pizza createPizza(String type) {
		Pizza pizza = null;

		if ("cheese".equals(type)) {
			pizza = new ChicagoStyleCheesePizza();
		}

		return pizza;
	}
}
