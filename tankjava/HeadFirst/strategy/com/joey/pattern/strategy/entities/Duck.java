package com.joey.pattern.strategy.entities;

import com.joey.pattern.strategy.interfaces.FlyBehavior;
import com.joey.pattern.strategy.interfaces.QuackBehavior;

public abstract class Duck {

	private FlyBehavior flyBehavior;

	private QuackBehavior quackBehavior;
	
	public abstract void display();

	public void performFly() {
		flyBehavior.fly();
	}

	public void performQuack() {
		quackBehavior.quack();
	}

	/** setter and getter */
	public FlyBehavior getFlyBehavior() {
		return flyBehavior;
	}

	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public QuackBehavior getQuackBehavior() {
		return quackBehavior;
	}

	public void setQuackBehavior(QuackBehavior quackBehavior) {
		this.quackBehavior = quackBehavior;
	}

}
