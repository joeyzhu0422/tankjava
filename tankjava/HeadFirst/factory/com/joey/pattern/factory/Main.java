package com.joey.pattern.factory;

import com.joey.pattern.factory.entities.Pizza;
import com.joey.pattern.factory.interfaces.impl.ChicagoPizzaStore;
import com.joey.pattern.factory.interfaces.impl.NYPizzaStore;

public class Main {

	public static void main(String[] args) {

		NYPizzaStore nyPizzaStore = new NYPizzaStore();

		Pizza pizza1 = nyPizzaStore.orderPizza("veggie");
		System.out.println("Ethan order a " + pizza1.getName() + "\n");

		ChicagoPizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
		Pizza pizza2 = chicagoPizzaStore.orderPizza("cheese");
		System.out.println("Ethan order a " + pizza2.getName() + "\n");
	}
}
