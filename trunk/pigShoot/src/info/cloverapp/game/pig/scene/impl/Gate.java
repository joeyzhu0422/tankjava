package info.cloverapp.game.pig.scene.impl;

import info.cloverapp.game.pig.beans.Pig;
import info.cloverapp.game.pig.scene.IScene;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.List;

public class Gate implements IScene {

	// ª∫≥Â«¯Õº≤„
	private BufferedImage bufferScene;

	private volatile Pig pig;

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

		System.out.println(pig);
		pig.draw(bufferG);

		g.drawImage(bufferScene, 0, 0, width , height, null);

	}

	@Override
	public List<KeyListener> getKeyListenerList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() {

		pig = new Pig();

	}

	@Override
	public boolean isRun() {
		return true;
	}

}
