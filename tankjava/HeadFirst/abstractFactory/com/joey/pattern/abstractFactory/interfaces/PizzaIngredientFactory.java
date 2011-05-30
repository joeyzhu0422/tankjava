package com.joey.pattern.abstractFactory.interfaces;

import com.joey.pattern.abstractFactory.entities.Cheese;
import com.joey.pattern.abstractFactory.entities.Clams;
import com.joey.pattern.abstractFactory.entities.Dough;
import com.joey.pattern.abstractFactory.entities.Pepperoni;
import com.joey.pattern.abstractFactory.entities.Sauce;
import com.joey.pattern.abstractFactory.entities.Veggies;

public interface PizzaIngredientFactory {

	public Dough createDough();

	public Sauce createSauce();

	public Cheese createCheese();

	public Veggies[] createVeggies();

	public Pepperoni createPepperoni();

	public Clams createClam();

}
