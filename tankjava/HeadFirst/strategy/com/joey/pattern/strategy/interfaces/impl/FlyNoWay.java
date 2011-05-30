package com.joey.pattern.strategy.interfaces.impl;

import com.joey.pattern.strategy.interfaces.FlyBehavior;

public class FlyNoWay implements FlyBehavior{

	public void fly() {
		System.out.println("I can't fly");
	}

}
