package com.joey.pattern.strategy.interfaces.impl;

import com.joey.pattern.strategy.interfaces.QuackBehavior;

public class Squeak implements QuackBehavior{

	public void quack() {
		System.out.println("Squeak");
	}

}
