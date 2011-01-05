package com.joey.tank.scene.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.List;

import com.joey.tank.scene.IScene;

public class Lost implements IScene {

	protected BufferedImage bufferScene;

	public void action() {
		// Do Nothing
	}

	public void draw(Graphics g, int width, int height) {

		bufferScene = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);

		// step.1 À´ª∫≥Â«¯…Ë÷√
		Graphics bufferG = bufferScene.getGraphics();
		
		// step.2 
		bufferG.setColor(Color.WHITE);
		bufferG.setFont(new Font(Font.DIALOG_INPUT, Font.BOLD, 18));

		g.drawImage(bufferScene, 0, 0, null);

	}

	public List<KeyListener> getKeyListenerList() {
		// Do Nothing
		return null;
	}

	public void init() {
		// Do Nothing
	}

	public boolean isRun() {
		return false;
	}

}
