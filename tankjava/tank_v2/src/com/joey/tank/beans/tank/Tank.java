package com.joey.tank.beans.tank;

import java.awt.Graphics;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.joey.tank.beans.ActiviteElement;
import com.joey.tank.beans.Bullet;
import com.joey.tank.beans.MapElement;
import com.joey.tank.constant.Constant;
import com.joey.tank.listener.impl.TankMoveListenerImpl;

public abstract class Tank extends ActiviteElement implements MapElement {

	protected Queue<Bullet> preparedBulletQueue = new LinkedBlockingQueue<Bullet>();

	protected Queue<Bullet> firedBulletQueue = new LinkedBlockingQueue<Bullet>();

	protected int barrelX, barrelY;

	protected boolean isDrawed;

	protected boolean isPass;

	protected boolean isBulletPass;

	public Tank() {
		setMoveListener(new TankMoveListenerImpl());
		this.isPutInMap = true;
	}

	public void draw(Graphics g) {

		if (!isDrawed()) {
			System.out.println("Tank draw");

			g.setColor(color);

			g.fill3DRect(x, y, width, height, true);

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

			this.isDrawed = true;

			g.fill3DRect(barrelX, barrelY, barrelWidth, barrelHeight, true);
		}
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
						Thread.sleep(50);
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
		if (null == bullet) {
			return null;
		}
		bullet.setXy(this.getBarrelX(), this.getBarrelY());
		bullet.setDirection(this.getDirection());
		firedBulletQueue.offer(bullet);

		return bullet;
	}

	public void put(Bullet bullet) {

		firedBulletQueue.remove(bullet);
		preparedBulletQueue.offer(bullet);

	}

	public void bulletAction() {
		// TODO Auto-generated method stub
	}

	public void init() {
		this.isDrawed = false;
	}

	public boolean isBulletPass() {
		return isBulletPass;
	}

	public boolean isPass() {
		return isPass;
	}

	public int getBarrelX() {
		return barrelX;
	}

	public int getBarrelY() {
		return barrelY;
	}

	public boolean isDrawed() {
		return isDrawed;
	}

	public Queue<Bullet> getFiredBulletQueue() {
		return firedBulletQueue;
	}

}
