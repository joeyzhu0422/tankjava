package com.joey.tank.listener.impl;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import com.joey.tank.beans.tank.TankFactory;
import com.joey.tank.constant.Constant;

public class MainTankFireListenerImpl implements KeyListener {

	private static int _KEY = -1;

	private static Thread _THREAD = null;

	@Override
	public void keyPressed(KeyEvent e) {
		// System.out.println("Main Tank Listener key Pressed");

		if (null != TankFactory.getMainTank()) {

			if (e.getKeyCode() == KeyEvent.VK_J) {
				_KEY = e.getKeyCode();

				action();
			}
		}
	}

	private void action() {

		System.out.println("Before if, In fire listener, key is " + _KEY
				+ " thead' status is "
				+ (null == _THREAD ? "thread is null" : _THREAD.isAlive()));

		if (null == _THREAD || !_THREAD.isAlive()) {

			System.out.println("After if, In fire listener, key is " + _KEY
					+ " thead' status is "
					+ (null == _THREAD ? "thread is null" : _THREAD.isAlive()));

			_THREAD = new Thread() {
				public void run() {
					while (_KEY != -1) {
						switch (_KEY) {
						case KeyEvent.VK_J:
							System.out.println("Main Tank fire");
							TankFactory.getMainTank().fire();
							break;
						}
					}

					try {
						Thread.sleep(Constant.Scene.THREAD_SLEEP_TIME * 10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				};
			};

			_THREAD.start();

		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Main Tank Listener key Released" + e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_J) {
			_KEY = -1;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		System.out.println("Main Tank Listener key typed" + e.getKeyCode());
	}

}
