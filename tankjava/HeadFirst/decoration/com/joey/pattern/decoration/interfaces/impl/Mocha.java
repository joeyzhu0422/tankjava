package com.joey.pattern.decoration.interfaces.impl;

import com.joey.pattern.decoration.interfaces.Beverage;
import com.joey.pattern.decoration.interfaces.CondimentDecorator;

public class Mocha extends CondimentDecorator {

	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}

	public double cost() {
		return beverage.cost() + .20;
	}

}
