package com.joey.pattern.factory.interfaces.impl;

import com.joey.pattern.factory.entities.NYStyleCheesePizza;
import com.joey.pattern.factory.entities.NYStyleVeggiePizza;
import com.joey.pattern.factory.entities.Pizza;
import com.joey.pattern.factory.interfaces.PizzaStore;

public class NYPizzaStore extends PizzaStore {

	public Pizza createPizza(String type) {
		Pizza pizza = null;

		if ("cheese".equals(type)) {
			pizza = new NYStyleCheesePizza();
		} else if ("veggie".equals(type)) {
			pizza = new NYStyleVeggiePizza();
		}

		return pizza;
	}

}
