package info.cloverapp.game.pig.scene.impl;

import info.cloverapp.game.pig.beans.Pig;
import info.cloverapp.game.pig.key.listener.impl.PigFireListenerImpl;
import info.cloverapp.game.pig.key.listener.impl.PigMoveKeyListenerImpl;
import info.cloverapp.game.pig.move.listener.impl.PigMoveListenerImpl;
import info.cloverapp.game.pig.scene.IScene;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class Gate implements IScene {

	// ª∫≥Â«¯Õº≤„
	private BufferedImage bufferScene;

	private List<KeyListener> keyListenerList;

	private volatile Pig pig;

	private Object lock = new Object();

	@Override
	public void action() {
		// TODO Auto-generated method stub

	}

	@Override
	public void draw(Graphics g, int width, int height) {

		bufferScene = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		// step.1 À´ª∫≥Â«¯…Ë÷√
		Graphics bufferG = bufferScene.getGraphics();

		bufferG.setColor(Color.BLACK);
		bufferG.fillRect(0, 0, width, height);

		pig.draw(bufferG);

		g.drawImage(bufferScene, 0, 0, width, height, null);

	}

	@Override
	public List<KeyListener> getKeyListenerList() {

		if (null == keyListenerList) {

			synchronized (lock) {

				if (null == keyListenerList) {

					keyListenerList = new ArrayList<KeyListener>();

					keyListenerList.add(new PigMoveKeyListenerImpl(pig));
					keyListenerList.add(new PigFireListenerImpl(pig));

				}

			}
		}

		return keyListenerList;
	}

	@Override
	public void init() {

		pig = new Pig();

		pig.setMoveListener(new PigMoveListenerImpl());

	}

	@Override
	public boolean isRun() {
		return true;
	}

}
