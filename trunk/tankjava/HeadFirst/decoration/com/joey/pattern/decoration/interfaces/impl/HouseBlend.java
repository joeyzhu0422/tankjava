package com.joey.pattern.decoration.interfaces.impl;

import com.joey.pattern.decoration.interfaces.Beverage;

public class HouseBlend extends Beverage{

	public HouseBlend() {
		this.description = "House Blend Coffee";
	}
	
	public double cost() {
		return .89;
	}
	
}
