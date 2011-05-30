package com.joey.pattern.decoration.interfaces.impl;

import com.joey.pattern.decoration.interfaces.Beverage;

public class Espresso extends Beverage{

	public Espresso() {
		this.description = "Espresso";
	}
	
	public double cost() {
		return 1.99;
	}

}
