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

	protected int barrelX, barrelY;

	public Tank() {
		setMoveListener(new TankMoveListenerImpl());
	}

	public void draw(Graphics g) {
		System.out.println("Tank draw");

		g.setColor(color);

		g.fillRect(x, y, width, height);

		int barrelWidth = 0, barrelHeight = 0;

		switch (direction) {
		case Constant.ActiviteElement.DIRECTION_UP:
			barrelWidth = width / 10;
			barrelHeight = height / 3;
			barrelX = x + width / 2 - barrelWidth / 2;
			barrelY = y - barrelHeight;
			break;
		case Constant.ActiviteElement.DIRECTION_DOWN:
			barrelWidth = width / 10;
			barrelHeight = height / 3;
			barrelX = x + width / 2 - barrelWidth / 2;
			barrelY = y + height;
			break;
		case Constant.ActiviteElement.DIRECTION_LEFT:
			barrelHeight = width / 10;
			barrelWidth = height / 3;
			barrelX = x - barrelWidth;
			barrelY = y + height / 2 - barrelHeight / 2;
			break;
		case Constant.ActiviteElement.DIRECTION_RIGHT:
			barrelHeight = width / 10;
			barrelWidth = height / 3;
			barrelX = x + width;
			barrelY = y + height / 2 - barrelHeight / 2;
			break;
		}

		g.fillRect(barrelX, barrelY, barrelWidth, barrelHeight);
	}

	public void fire() {

		final Bullet bullet = this.poll();

		if (null == bullet) {
			return;
		}

		new Thread() {

			public void run() {

				while (bullet.move()) {
					try {
						Thread.sleep(15);
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
		bullet.setXy(this.getBarrelX(), this.getBarrelY());
		bullet.setDirection(this.getDirection());
		firedBulletQueue.offer(bullet);

		return bullet;
	}

	public void put(Bullet bullet) {

		firedBulletQueue.remove(bullet);
		preparedBulletQueue.offer(bullet);

	}

	public int getBarrelX() {
		return barrelX;
	}

	public int getBarrelY() {
		return barrelY;
	}

	public Queue<Bullet> getFiredBulletQueue() {
		return firedBulletQueue;
	}

}
