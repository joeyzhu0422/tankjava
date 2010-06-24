package com.joey.tetris.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.joey.tetris.entities.Ground;
import com.joey.tetris.entities.Shape;
import com.joey.tetris.util.Global;

public class GamePanel extends JPanel {

	private Ground ground;
	private Shape shape;

	public void display(Ground ground, Shape shape) {
		System.out.println("GamePanel's display");
		this.ground = ground;
		this.shape = shape;
		this.repaint();
	}

	public void paint(Graphics g) {

		g.setColor(Color.WHITE);

		g.fillRect(0, 0, this.getSize().width, this.getSize().height);

		if (null != ground) {
			ground.drawMe(g);
		}
		if (null != shape) {
			shape.drawMe(g);
		}
	}

	public GamePanel() {
		this.setSize(Global.WIDTH * Global.CELL_SIZE, Global.HEIGHT
				* Global.CELL_SIZE);
	}
}
