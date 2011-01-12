package com.joey.tank.listener.impl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.joey.tank.beans.tank.TankFactory;
import com.joey.tank.constant.Constant;

public class SubTankKeyListenerImpl implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
// System.out.println("Main Tank Listener key Pressed");

		if (null != TankFactory.getSubTank()) {

			int keyCode = e.getKeyCode();

			switch (keyCode) {
			case KeyEvent.VK_UP:
// System.out.println("Up is keyed....");
				TankFactory.getSubTank().setDirection(
						Constant.ActiviteElement.DIRECTION_UP);
				TankFactory.getSubTank().move();
				return;
			case KeyEvent.VK_DOWN:
// System.out.println("Down is keyed....");
				TankFactory.getSubTank().setDirection(
						Constant.ActiviteElement.DIRECTION_DOWN);
				TankFactory.getSubTank().move();
				return;
			case KeyEvent.VK_LEFT:
// System.out.println("Left is keyed....");
				TankFactory.getSubTank().setDirection(
						Constant.ActiviteElement.DIRECTION_LEFT);
				TankFactory.getSubTank().move();
				return;
			case KeyEvent.VK_RIGHT:
// System.out.println("Right is keyed....");
				TankFactory.getSubTank().setDirection(
						Constant.ActiviteElement.DIRECTION_RIGHT);
				TankFactory.getSubTank().move();
				return;
			case KeyEvent.VK_4:
// System.out.println("Main Tank fire");
				TankFactory.getSubTank().fire();
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
