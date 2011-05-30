package com.joey.pattern.abstractFactory;

import com.joey.pattern.abstractFactory.entities.Pizza;
import com.joey.pattern.abstractFactory.interfaces.PizzaStore;
import com.joey.pattern.abstractFactory.interfaces.impl.NYPizzaStore;

public class Main {

	public static void main(String[] args) {

		PizzaStore pizzaStore = new NYPizzaStore();

		Pizza pizza = pizzaStore.orderPizza("cheese");

		System.out.println(pizza);

	}
}
