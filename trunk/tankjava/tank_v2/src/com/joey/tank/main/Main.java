package com.joey.tank.main;

import com.joey.tank.scene.Menu;
import com.joey.tank.scene.Window;

public class Main {

	public static void main(String[] args) {

		// step.1 scene
		Window window = new Window();

		window.setScene(new Menu(window));
		
		window.start();
	}
}
