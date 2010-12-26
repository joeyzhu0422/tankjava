package com.joey.tank.beans.tank;

import java.awt.Graphics;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.joey.tank.beans.ActiviteElement;
import com.joey.tank.beans.Bullet;
import com.joey.tank.constant.Constant;
import com.joey.tank.listener.impl.TankMoveListenerImpl;

public abstract class Tank extends ActiviteElement {

	protected Queue<Bullet> preparedBulletQueue = new LinkedBlockingQueue<Bullet>();

	protected Queue<Bullet> firedBulletQueue = new LinkedBlockingQueue<Bullet>();

	public Tank() {
		setMoveListener(new TankMoveListenerImpl());
	}

	public void draw(Graphics g) {
		System.out.println("Tank draw");

		g.setColor(color);

		g.fillRect(x * Constant.Scene.CELL_LENGTH, y
				* Constant.Scene.CELL_LENGTH + Constant.Scene.TOP_HEIGHT,
				width, height);

		int barrelWidth = 0, barrelHeight = 0;

		switch (direction) {
		case Constant.ActiviteElement.DIRECTION_UP:
			barrelWidth = width / 10;
			barrelHeight = height / 3;
			rBarrelX = x * Constant.Scene.CELL_LENGTH + width / 2 - barrelWidth
					/ 2;
			rBarrelY = y * Constant.Scene.CELL_LENGTH - barrelHeight;
			break;
		case Constant.ActiviteElement.DIRECTION_DOWN:
			barrelWidth = width / 10;
			barrelHeight = height / 3;
			rBarrelX = x * Constant.Scene.CELL_LENGTH + width / 2 - barrelWidth
					/ 2;
			rBarrelY = y * Constant.Scene.CELL_LENGTH + height;
			break;
		case Constant.ActiviteElement.DIRECTION_LEFT:
			barrelHeight = width / 10;
			barrelWidth = height / 3;
			rBarrelX = x * Constant.Scene.CELL_LENGTH - barrelWidth;
			rBarrelY = y * Constant.Scene.CELL_LENGTH + height / 2
					- barrelHeight / 2;
			break;
		case Constant.ActiviteElement.DIRECTION_RIGHT:
			barrelHeight = width / 10;
			barrelWidth = height / 3;
			rBarrelX = x * Constant.Scene.CELL_LENGTH + width;
			rBarrelY = y * Constant.Scene.CELL_LENGTH + height / 2
					- barrelHeight / 2;
			break;
		}

		g.fillRect(rBarrelX, rBarrelY + Constant.Scene.TOP_HEIGHT, barrelWidth,
				barrelHeight);
	}

	public void fire() {

		final Bullet bullet = this.poll();

		new Thread() {

			public void run() {

				while (bullet.move()) {
					try {
						Thread.sleep(150);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				put(bullet);
			}
		}.start();

	}

	public Bullet poll() {

		Bullet bullet = preparedBulletQueue.poll();
		bullet.setRxy(this.getRBarrelX(), this.getRBarrelY());
		bullet.setDirection(this.getDirection());
		firedBulletQueue.offer(bullet);

		return bullet;
	}

	public void put(Bullet bullet) {

		firedBulletQueue.remove(bullet);
		preparedBulletQueue.offer(bullet);

	}

	public int getRBarrelX() {
		return rBarrelX;
	}

	public void setRBarrelX(int barrelX) {
		rBarrelX = barrelX;
	}

	public int getRBarrelY() {
		return rBarrelY;
	}

	public void setRBarrelY(int barrelY) {
		rBarrelY = barrelY;
	}

	public Queue<Bullet> getFiredBulletQueue() {
		return firedBulletQueue;
	}

}
