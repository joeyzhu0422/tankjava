package com.joey.tank.listener.impl;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.joey.tank.scene.impl.Gate;
import com.joey.tank.window.Window;

public class MenuKeyListenerImpl extends KeyAdapter {
	
	protected Window window;

	public MenuKeyListenerImpl(Window window) {
		this.window = window;
	}
	
	public void keyPressed(KeyEvent e) {

		int keyCode = e.getKeyCode();
		
		if (keyCode == KeyEvent.VK_ENTER) {
			
			this.window.stop();
			this.window.setScene(new Gate());
			this.window.start();
			
		}
		
	}

}
