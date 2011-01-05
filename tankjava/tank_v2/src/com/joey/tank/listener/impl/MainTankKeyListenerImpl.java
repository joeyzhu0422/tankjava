package com.joey.tank.listener.impl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.joey.tank.beans.tank.TankFactory;
import com.joey.tank.constant.Constant;

public class MainTankKeyListenerImpl implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
// System.out.println("Main Tank Listener key Pressed");

		if (null != TankFactory.getMainTank()) {

			int keyCode = e.getKeyCode();

			switch (keyCode) {
			case KeyEvent.VK_W:
// System.out.println("Up is keyed....");
				TankFactory.getMainTank().setDirection(
						Constant.ActiviteElement.DIRECTION_UP);
				TankFactory.getMainTank().move();
				return;
			case KeyEvent.VK_S:
// System.out.println("Down is keyed....");
				TankFactory.getMainTank().setDirection(
						Constant.ActiviteElement.DIRECTION_DOWN);
				TankFactory.getMainTank().move();
				return;
			case KeyEvent.VK_A:
// System.out.println("Left is keyed....");
				TankFactory.getMainTank().setDirection(
						Constant.ActiviteElement.DIRECTION_LEFT);
				TankFactory.getMainTank().move();
				return;
			case KeyEvent.VK_D:
// System.out.println("Right is keyed....");
				TankFactory.getMainTank().setDirection(
						Constant.ActiviteElement.DIRECTION_RIGHT);
				TankFactory.getMainTank().move();
				return;
			case KeyEvent.VK_J:
// System.out.println("Main Tank fire");
				TankFactory.getMainTank().fire();
				return;
			}

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
// System.out.println("Main Tank Listener key Released");
	}

	@Override
	public void keyTyped(KeyEvent e) {
// System.out.println("Main Tank Listener key typed");
	}

}
