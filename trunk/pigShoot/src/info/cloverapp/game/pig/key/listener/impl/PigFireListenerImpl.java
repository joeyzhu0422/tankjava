package info.cloverapp.game.pig.key.listener.impl;

import info.cloverapp.game.pig.beans.Pig;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PigFireListenerImpl implements KeyListener {

	private static int _KEY = -1;

	private static Thread _THREAD = null;
	
	private Pig pig;

	public PigFireListenerImpl(Pig pig) {
		this.pig = pig;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// System.out.println("Main Tank Listener key Pressed");

		if (null != pig) {

			if (e.getKeyCode() == KeyEvent.VK_J) {
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
						case KeyEvent.VK_J:
							pig.fire();
							break;
						}
					}

					try {
						Thread.sleep(20);
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
		//System.out.println("Main Tank Listener key Released" + e.getKeyCode());
		if (e.getKeyCode() == KeyEvent.VK_J) {
			_KEY = -1;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		//System.out.println("Main Tank Listener key typed" + e.getKeyCode());
	}

}
