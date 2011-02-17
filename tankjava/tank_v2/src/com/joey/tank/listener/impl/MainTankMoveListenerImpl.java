package com.joey.tank.listener.impl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.joey.tank.beans.tank.TankFactory;
import com.joey.tank.constant.Constant;

public class MainTankMoveListenerImpl implements KeyListener {

	private static int _KEY = -1;

	private static Thread _THREAD = null;

	@Override
	public void keyPressed(KeyEvent e) {
		// System.out.println("Main Tank Listener key Pressed");

		if (null != TankFactory.getMainTank()) {

			if (e.getKeyCode() == KeyEvent.VK_S
					|| e.getKeyCode() == KeyEvent.VK_W
					|| e.getKeyCode() == KeyEvent.VK_A
					|| e.getKeyCode() == KeyEvent.VK_D) {

				_KEY = e.getKeyCode();

				action();
			}
		}
	}

	private void action() {

//		System.out.println("Before if, In move listener, key is " + _KEY
//				+ " thead' status is "
//				+ (null == _THREAD ? "thread is null" : _THREAD.isAlive()));

		if (null == _THREAD || !_THREAD.isAlive()) {

//			System.out.println("After if, In move listener, key is " + _KEY
//					+ " thead' status is "
//					+ (null == _THREAD ? "thread is null" : _THREAD.isAlive()));

			_THREAD = new Thread() {
				public void run() {
					while (_KEY != -1) {
						switch (_KEY) {
						case KeyEvent.VK_W:
							//System.out.println("Up is keyed....");
							TankFactory.getMainTank().setDirection(
									Constant.ActiviteElement.DIRECTION_UP);
							TankFactory.getMainTank().move();
							break;
						case KeyEvent.VK_S:
							// System.out.println("Down is keyed....");
							TankFactory.getMainTank().setDirection(
									Constant.ActiviteElement.DIRECTION_DOWN);
							TankFactory.getMainTank().move();
							break;
						case KeyEvent.VK_A:
							// System.out.println("Left is keyed....");
							TankFactory.getMainTank().setDirection(
									Constant.ActiviteElement.DIRECTION_LEFT);
							TankFactory.getMainTank().move();
							break;
						case KeyEvent.VK_D:
							// System.out.println("Right is keyed....");
							TankFactory.getMainTank().setDirection(
									Constant.ActiviteElement.DIRECTION_RIGHT);
							TankFactory.getMainTank().move();
							break;
						}

						try {
							Thread.sleep(Constant.Scene.THREAD_SLEEP_TIME * 10);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				};
			};

			_THREAD.start();

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		//System.out.println("Main Tank Listener key Released" + e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_W
				|| e.getKeyCode() == KeyEvent.VK_A
				|| e.getKeyCode() == KeyEvent.VK_D) {
			_KEY = -1;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println("Main Tank Listener key typed" + e.getKeyCode());
	}

}
