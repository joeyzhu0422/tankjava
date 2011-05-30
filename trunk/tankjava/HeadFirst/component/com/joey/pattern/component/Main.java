package com.joey.pattern.component;

import com.joey.pattern.component.entities.Menu;
import com.joey.pattern.component.entities.MenuComponent;
import com.joey.pattern.component.entities.MenuItem;
import com.joey.pattern.component.entities.Waitress;

public class Main {

	public static void main(String[] args) {

		MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU",
				"Breakfast");
		MenuComponent dinerMenu = new Menu("DINER MENU", "Lunch");
		MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
		MenuComponent dessertMenu = new Menu("DESSERT MENU",
				"Dessert of course!");

		MenuComponent allMenus = new Menu("ALL MENUS", "All menus combined");

		allMenus.add(pancakeHouseMenu);
		allMenus.add(dinerMenu);
		allMenus.add(cafeMenu);

		

		dinerMenu.add(new MenuItem("Apple Pie",
				"Apple pie with a flakey crust, topped with vanilla ice cream",
				true, 1.59));
		dinerMenu.add(new MenuItem("Apple Pie2",
				"Apple pie with a flakey crust, topped with vanilla ice cream",
				true, 1.59));
		
		dinerMenu.add(dessertMenu);

		dessertMenu.add(new MenuItem("Apple Pie3",
				"Apple pie with a flakey crust, topped with vanilla ice cream",
				true, 1.59));
		
		Waitress waitress = new Waitress(allMenus);
		
		waitress.printMenu();

	}
}
