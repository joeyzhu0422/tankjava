package com.joey.tank.main;

import com.joey.tank.scene.impl.Menu;
import com.joey.tank.window.Window;

public class Main {

	public static void main(String[] args) {

		// step.1 scene
		Window window = new Window();

		window.setScene(new Menu(window));
		
		window.start();
	}
}
