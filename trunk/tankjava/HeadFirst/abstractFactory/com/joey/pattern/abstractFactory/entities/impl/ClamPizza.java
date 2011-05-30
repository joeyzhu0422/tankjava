package com.joey.pattern.abstractFactory.entities.impl;

import com.joey.pattern.abstractFactory.entities.Pizza;
import com.joey.pattern.abstractFactory.interfaces.PizzaIngredientFactory;

public class ClamPizza extends Pizza {
	protected PizzaIngredientFactory ingredientFactory;

	public ClamPizza(PizzaIngredientFactory ingredientFactory) {
		this.ingredientFactory = ingredientFactory;
	}

	public void prepare() {
		System.out.println("Preparing " + name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		clams = ingredientFactory.createClam();
	}

}
