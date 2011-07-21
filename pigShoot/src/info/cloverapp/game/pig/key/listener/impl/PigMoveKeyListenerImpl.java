package info.cloverapp.game.pig.key.listener.impl;

import info.cloverapp.game.pig.beans.Pig;
import info.cloverapp.game.pig.constant.Constant;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PigMoveKeyListenerImpl implements KeyListener {

	private static int _KEY = -1;

	private static Thread _THREAD = null;

	private Pig pig;

	public PigMoveKeyListenerImpl(Pig pig) {
		this.pig = pig;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("Pig Listener key Pressed");

		if (null != pig) {

			if (e.getKeyCode() == KeyEvent.VK_S
					|| e.getKeyCode() == KeyEvent.VK_W) {

				_KEY = e.getKeyCode();

				action();
			}
		}
	}

	private void action() {

		if (null == _THREAD || !_THREAD.isAlive()) {

			_THREAD = new Thread() {
				public void run() {
					while (_KEY != -1) {
						switch (_KEY) {
						case KeyEvent.VK_W:
							// System.out.println("Up is keyed....");
							pig
									.setDirection(Constant.ActiviteElement.DIRECTION_UP);
							pig.move();
							break;
						case KeyEvent.VK_S:
							// System.out.println("Down is keyed....");
							pig
									.setDirection(Constant.ActiviteElement.DIRECTION_DOWN);
							pig.move();
							break;
// case KeyEvent.VK_A:
// // System.out.println("Left is keyed....");
// pig
// .setDirection(Constant.ActiviteElement.DIRECTION_LEFT);
// pig.move();
// break;
// case KeyEvent.VK_D:
// // System.out.println("Right is keyed....");
// pig
// .setDirection(Constant.ActiviteElement.DIRECTION_RIGHT);
// pig.move();
// break;
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
		// System.out.println("Pig Listener key Released" +
		// e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_W
				|| e.getKeyCode() == KeyEvent.VK_A
				|| e.getKeyCode() == KeyEvent.VK_D) {
			_KEY = -1;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// System.out.println("Pig Listener key typed" + e.getKeyCode());
	}

}
