package com.joey.tank.listener.impl;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.joey.tank.beans.tank.MainTank;
import com.joey.tank.scene.impl.Gate;
import com.joey.tank.window.Window;

public class MenuKeyListenerImpl extends KeyAdapter {

	protected Window window;

	protected MainTank mainTank;

	protected int players = 1;

	public MenuKeyListenerImpl(Window window, MainTank mainTank) {

		this.window = window;
		this.mainTank = mainTank;

	}

	public void keyPressed(KeyEvent e) {

		int keyCode = e.getKeyCode();

		switch (keyCode) {
		case KeyEvent.VK_UP:
			if (players != 1) {
				mainTank.setY(mainTank.getY() - 40);
				players = 1;
			}
			break;
		case KeyEvent.VK_DOWN:
			if (players != 2) {
				mainTank.setY(mainTank.getY() + 40);
				players = 2;
			}
			break;
		case KeyEvent.VK_ENTER:

			this.window.stop();
			this.window.setScene(new Gate(window, players));
			this.window.start();

			break;

		}

	}

}
