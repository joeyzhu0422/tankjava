package com.joey.pattern.adapter.adapter;

import com.joey.pattern.adapter.entities.Duck;
import com.joey.pattern.adapter.entities.Turkey;

public class TurkeyAdapter implements Duck{

	private Turkey turkey;
	
	public TurkeyAdapter(Turkey turkey) {
		this.turkey = turkey;
	}
	
	public void quack() {
		turkey.gobble();
	}

	public void fly() {
		turkey.fly();
	}

}
