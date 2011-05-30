package com.joey.pattern.strategy;

import com.joey.pattern.strategy.entities.ModelDuck;

public class Main {

	public static void main(String[] args) {
		
		ModelDuck duck = new ModelDuck();
		
		duck.performFly();
		duck.performQuack();
		duck.display();
		
	}
	
}
