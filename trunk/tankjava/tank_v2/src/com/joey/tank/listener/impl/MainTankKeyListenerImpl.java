package com.joey.tank.listener.impl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.joey.tank.beans.tank.MainTank;
import com.joey.tank.constant.Constant;

public class MainTankKeyListenerImpl implements KeyListener {

	private MainTank mainTank;

	public MainTankKeyListenerImpl(MainTank mainTank) {
		this.mainTank = mainTank;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Main Tank Listener key Pressed");

		int keyCode = e.getKeyCode();

		switch (keyCode) {
		case KeyEvent.VK_UP:
			System.out.println("Up is keyed....");
			mainTank.setDirection(Constant.ActiviteElement.DIRECTION_UP);
			break;
		case KeyEvent.VK_DOWN:
			System.out.println("Down is keyed....");
			mainTank.setDirection(Constant.ActiviteElement.DIRECTION_DOWN);
			break;
		case KeyEvent.VK_LEFT:
			System.out.println("Left is keyed....");
			mainTank.setDirection(Constant.ActiviteElement.DIRECTION_LEFT);
			break;
		case KeyEvent.VK_RIGHT:
			System.out.println("Right is keyed....");
			mainTank.setDirection(Constant.ActiviteElement.DIRECTION_RIGHT);
			break;
		case KeyEvent.VK_ENTER:
			System.out.println("Main Tank fire");
			mainTank.fire();
			return;
		}

		mainTank.move();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Main Tank Listener key Released");
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("Main Tank Listener key typed");
	}

}
