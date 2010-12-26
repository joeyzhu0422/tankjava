package com.joey.tank.beans;

import java.awt.Color;
import java.awt.Graphics;

import com.joey.tank.beans.tank.Tank;
import com.joey.tank.listener.impl.BulletMoveListenerImpl;

public class Bullet extends ActiviteElement {

	protected Tank tank;

	public Bullet(Tank tank) {
		this.setMoveListener(new BulletMoveListenerImpl());
		this.color = Color.WHITE;
		this.width = 5;
		this.height = 5;
		this.tank = tank;

	}

	public void action() {
		System.out.println("Bullet is action");
	}

	public void draw(Graphics g) {
		System.out.println("Bullet draw");

		g.setColor(Color.WHITE);
		g.fillRect(x, y, width, height);
	}

	public void setXy(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
