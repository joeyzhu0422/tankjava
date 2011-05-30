package com.joey.pattern.adapter.entities.impl;

import com.joey.pattern.adapter.entities.Duck;

public class MallardDuck implements Duck{

	public void quack() {
		System.out.println("Quack");
	}

	public void fly() {
		System.out.println("I'm flying");
	}

}
