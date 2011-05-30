package com.joey.pattern.abstractFactory.interfaces.impl;

import com.joey.pattern.abstractFactory.entities.Cheese;
import com.joey.pattern.abstractFactory.entities.Clams;
import com.joey.pattern.abstractFactory.entities.Dough;
import com.joey.pattern.abstractFactory.entities.Pepperoni;
import com.joey.pattern.abstractFactory.entities.Sauce;
import com.joey.pattern.abstractFactory.entities.Veggies;
import com.joey.pattern.abstractFactory.entities.impl.FreshClams;
import com.joey.pattern.abstractFactory.entities.impl.Garlic;
import com.joey.pattern.abstractFactory.entities.impl.MarinaraSauce;
import com.joey.pattern.abstractFactory.entities.impl.Mushroom;
import com.joey.pattern.abstractFactory.entities.impl.Onion;
import com.joey.pattern.abstractFactory.entities.impl.RedPepper;
import com.joey.pattern.abstractFactory.entities.impl.ReggianoCheese;
import com.joey.pattern.abstractFactory.entities.impl.SlicedPepperoni;
import com.joey.pattern.abstractFactory.entities.impl.ThinCrustDough;
import com.joey.pattern.abstractFactory.interfaces.PizzaIngredientFactory;

public class NYPizzaIngredientFactory implements PizzaIngredientFactory {

	public Cheese createCheese() {
		return new ReggianoCheese();
	}

	public Clams createClam() {
		return new FreshClams();
	}

	public Dough createDough() {
		return new ThinCrustDough();
	}

	public Pepperoni createPepperoni() {
		return new SlicedPepperoni();
	}

	public Sauce createSauce() {
		return new MarinaraSauce();
	}

	public Veggies[] createVeggies() {
		Veggies veggies[] = { new Garlic(), new Onion(), new Mushroom(),
				new RedPepper() };
		return veggies;
	}

}
