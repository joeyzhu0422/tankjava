package com.joey.pattern.abstractFactory.entities;

public abstract class Pizza {

	protected String name;

	protected Dough dough;

	protected Sauce sauce;

	protected Veggies[] veggies;

	protected Cheese cheese;

	protected Pepperoni pepperoni;

	protected Clams clams;

	public abstract void prepare();

	public void bake() {
		System.out.println("Bake for 25 minutes at 350");
	}

	public void cut() {
		System.out.println("Cutting the pizza into diagonal slices");
	}

	public void box() {
		System.out.println("Place pizza in official PizzaStore box");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		String _veggies = "";

		if (null != veggies) {
			for (Veggies veggie : veggies) {
				_veggies += veggie.getClass().getSimpleName() + " ";
			}
		}

		return name + " " + getName(dough) + " " + getName(sauce) + " "
				+ _veggies + getName(cheese) + " " + getName(pepperoni) + " "
				+ getName(clams);
	}

	private String getName(Object obj) {
		if (null != obj) {
			return obj.getClass().getSimpleName();
		} else {
			return "";
		}

	}
}
