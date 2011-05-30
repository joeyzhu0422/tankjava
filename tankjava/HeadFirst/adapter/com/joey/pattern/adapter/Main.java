package com.joey.pattern.adapter;

import com.joey.pattern.adapter.adapter.TurkeyAdapter;
import com.joey.pattern.adapter.entities.Duck;
import com.joey.pattern.adapter.entities.impl.WildTurkey;

public class Main {

	public static void main(String[] args) {
		WildTurkey turkey = new WildTurkey();
		Duck turkeyAdapter = new TurkeyAdapter(turkey);
		
		System.out.println("The TurkeyAdapter says...");
		turkeyAdapter.quack();
		turkeyAdapter.fly();
		
		
	}
}
