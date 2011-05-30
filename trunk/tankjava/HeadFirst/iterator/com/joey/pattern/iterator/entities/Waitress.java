package com.joey.pattern.iterator.entities;

import com.joey.pattern.iterator.entities.DinerMenu;
import com.joey.pattern.iterator.entities.MenuItem;
import com.joey.pattern.iterator.entities.PancakeHouseMenu;
import com.joey.pattern.iterator.interfaces.Iterator;

public class Waitress {

	private PancakeHouseMenu pancakeHouseMenu;

	private DinerMenu dinerMenu;

	public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu) {
		
		this.pancakeHouseMenu = pancakeHouseMenu;
		this.dinerMenu = dinerMenu;
		
	}
	
	public void printMenu() {
		
		Iterator pancakeIterator = pancakeHouseMenu.createIterator();
		Iterator dinerIterator = dinerMenu.createIterator();
		System.out.println("MENU\n----\nBREAKFAST");
		printMenu(pancakeIterator);
		System.out.println("\nLUNCH");
		printMenu(dinerIterator);
		
	}
	
	private void printMenu(Iterator iterator) {
		while (iterator.hasNext()) {

			MenuItem menuItem = (MenuItem) iterator.next();
			System.out.print(menuItem.getName() + ", ");
			System.out.print(menuItem.getPrice() + " -- ");
			System.out.println(menuItem.getDescription());
			
		}
	}
}
