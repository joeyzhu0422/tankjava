package com.joey.pattern.iterator.entities;

import com.joey.pattern.iterator.entities.MenuItem;
import com.joey.pattern.iterator.interfaces.Iterator;
import com.joey.pattern.iterator.interfaces.impl.DinerMenuIterator;

public class DinerMenu {

	public static final int MAX_ITEMS = 6;

	private int numerOfItems = 0;

	private MenuItem[] menuItems;

	public DinerMenu() {

		this.menuItems = new MenuItem[MAX_ITEMS];
		this.addItem("Vegetarian BLT",
				"Fakin Bacon with lettuce & tomato on whole whear", true, 2.99);
		this.addItem("BLT", "Bacon with lettuce & tomato on whole wheat",
				false, 2.99);
		this.addItem("Soup of the day",
				"Soup of the, with a side of potato salad", false, 3.29);
		this
				.addItem(
						"Hotdog",
						"A hot dog, with saurkraut, relish, onions, topped with cheese",
						false, 3.05);

	}

	public void addItem(String name, String description, boolean vegetarian,
			double price) {

		MenuItem menuItem = new MenuItem(name, description, vegetarian, price);

		if (numerOfItems > MAX_ITEMS) {
			System.err.println("Sorry, menu is full! Can't add item to menu");
		} else {
			menuItems[numerOfItems] = menuItem;
			numerOfItems++;
		}

	}

	public Iterator createIterator() {
		return new DinerMenuIterator(menuItems);
	}
}
