package com.joey.pattern.iterator;

import com.joey.pattern.iterator.entities.DinerMenu;
import com.joey.pattern.iterator.entities.PancakeHouseMenu;
import com.joey.pattern.iterator.entities.Waitress;

public class Main {

	public static void main(String[] args) {
		
		PancakeHouseMenu pancakeHouseMenu = new PancakeHouseMenu();
		DinerMenu dinerMenu = new DinerMenu();
		
		Waitress waitress = new Waitress(pancakeHouseMenu, dinerMenu);
		
		waitress.printMenu();
		
	}
}
