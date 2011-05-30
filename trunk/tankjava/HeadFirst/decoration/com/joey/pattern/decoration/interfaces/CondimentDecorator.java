package com.joey.pattern.decoration.interfaces;

public abstract class CondimentDecorator extends Beverage{
	
	protected Beverage beverage;
	
	public abstract String getDescription();
	
}
