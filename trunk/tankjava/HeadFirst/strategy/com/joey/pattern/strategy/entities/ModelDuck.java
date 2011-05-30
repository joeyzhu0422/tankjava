package com.joey.pattern.strategy.entities;

import com.joey.pattern.strategy.interfaces.impl.FlyNoWay;
import com.joey.pattern.strategy.interfaces.impl.Quack;

public class ModelDuck extends Duck{
	
	public ModelDuck() {
		this.setFlyBehavior(new FlyNoWay());
		this.setQuackBehavior(new Quack());
	}
	
	public void display() {
		System.out.println("I'm a model duck");
	}
	
}
