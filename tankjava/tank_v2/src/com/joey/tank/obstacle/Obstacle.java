package com.joey.tank.beans.obstacle;

import java.awt.Graphics;

import com.joey.tank.beans.StaticElement;
import com.joey.tank.constant.Constant;

public abstract class Obstacle extends StaticElement {

	protected boolean isPass;

	public Obstacle(int x, int y) {
		this.width = Constant.Scene.CELL_LENGTH;
		this.height = Constant.Scene.CELL_LENGTH;
		this.x = x;
		this.y = y;
	}

	public boolean isPass() {
		return isPass;
	}

	public void draw(Graphics g) {

		g.setColor(this.color);
		g.fill3DRect(x, y, width, height, true);

	}
}
