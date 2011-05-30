package com.joey.pattern.iterator.entities;

import java.util.ArrayList;
import java.util.List;

import com.joey.pattern.iterator.entities.MenuItem;
import com.joey.pattern.iterator.interfaces.Iterator;
import com.joey.pattern.iterator.interfaces.impl.PancakeHouseIterator;

public class PancakeHouseMenu {

	private List<MenuItem> menuItems;

	public PancakeHouseMenu() {

		this.menuItems = new ArrayList<MenuItem>();

		this.addItem("K&B's Pancake Breakfast",
				"Pancakes with scrambled eggs, and toast", true, 2.99);
		this.addItem("Regular Pancake Breakfast",
				"Pancakes with fried eggs, sausage", false, 2.99);
		this.addItem("Blueberry Pancakes",
				"Pancakes made with fresh blueberries", true, 3.49);
		this.addItem("Waffles",
				"Waffles, with your choice of blueberries or strawberries",
				true, 3.59);

	}

	public void addItem(String name, String description, boolean vegetarian,
			double price) {

		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);
		menuItems.add(menuItem);

	}

	public List<MenuItem> getMenuItems() {
		return menuItems;
	}

	public Iterator createIterator() {
		return new PancakeHouseIterator(menuItems);
	}
}
