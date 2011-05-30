package com.joey.pattern.component.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Menu extends MenuComponent{

	private List<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
	
	private String name;
	
	private String description;
	
	public Menu(String name, String description) {
		
		this.name = name;
		this.description = description;
		
	}
	
	public void add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
	}

	public void remove(MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);
	}

	public String getName() {
		return name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void print() {
		System.out.print("\n" + getName());
		System.out.println(", " + getDescription());
		System.out.println("-----------------------------");
		
		Iterator<MenuComponent> iterator = menuComponents.iterator();
		while (iterator.hasNext()) {
			MenuComponent menuComponent = iterator.next();
			menuComponent.print();
		}
	}
}

