package com.joey.tank.beans.tank;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.joey.tank.beans.ActiviteElement;
import com.joey.tank.beans.Bullet;
import com.joey.tank.beans.IExplode;
import com.joey.tank.beans.IMultipleMapElement;
import com.joey.tank.constant.Constant;
import com.joey.tank.listener.impl.TankMoveListenerImpl;

public abstract class Tank extends ActiviteElement implements
		IMultipleMapElement, IExplode {

	protected Queue<Bullet> preparedBulletQueue = new LinkedBlockingQueue<Bullet>();

	protected Queue<Bullet> firedBulletQueue = new LinkedBlockingQueue<Bullet>();

	protected int barrelX, barrelY, bulletX, bulletY;

	protected boolean isDrawed;

	protected boolean isPass;

	protected boolean isBulletPass;

	protected boolean isExploded;

	protected int[] diameter = { 4, 7, 12, 18, 26, 32, 32, 30, 14, 6 };

	protected int currentExplodeStep = 0;

	public Tank() {

		setMoveListener(new TankMoveListenerImpl());
		this.isPutInMap = true;
		this.isExploded = false;
		this.isPass = false;
	}

	public void draw(Graphics g) {

		if (!isDrawed()) {

			if (isExploded()) {
				this.explode(g);
			} else {

				// System.out.println("Tank draw");

				g.setColor(color);

				g.fill3DRect(x, y, width, height, true);

				int barrelWidth = 0, barrelHeight = 0;

				switch (direction) {
				case Constant.ActiviteElement.DIRECTION_UP:
					barrelWidth = width / 10;
					barrelHeight = height / 3;
					barrelX = x + width / 2 - barrelWidth / 2;
					bulletX = barrelX;
					barrelY = y - barrelHeight;
					bulletY = barrelY + Constant.Scene.CELL_LENGTH;
					break;
				case Constant.ActiviteElement.DIRECTION_DOWN:
					barrelWidth = width / 10;
					barrelHeight = height / 3;
					barrelX = x + width / 2 - barrelWidth / 2;
					bulletX = barrelX;
					barrelY = y + height;
					bulletY = barrelY - Constant.Scene.CELL_LENGTH;
					break;
				case Constant.ActiviteElement.DIRECTION_LEFT:
					barrelHeight = width / 10;
					barrelWidth = height / 3;
					barrelX = x - barrelWidth;
					bulletX = barrelX + Constant.Scene.CELL_LENGTH;
					barrelY = y + height / 2 - barrelHeight / 2;
					bulletY = barrelY;
					break;
				case Constant.ActiviteElement.DIRECTION_RIGHT:
					barrelHeight = width / 10;
					barrelWidth = height / 3;
					barrelX = x + width;
					bulletX = barrelX - Constant.Scene.CELL_LENGTH;
					barrelY = y + height / 2 - barrelHeight / 2;
					bulletY = barrelY;
					break;
				}

				g.fill3DRect(barrelX, barrelY, barrelWidth, barrelHeight, true);
			}

			this.isDrawed = true;
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
		bullet.setXy(this.getBulletX(), this.getBulletY());
		bullet.setDirection(this.getDirection());
		firedBulletQueue.offer(bullet);

		return bullet;
	}

	public void put(Bullet bullet) {

		firedBulletQueue.remove(bullet);
		preparedBulletQueue.offer(bullet);

	}

	public boolean isExploded() {
		return isExploded;
	}

	public int getCurrentExplodeStep() {
		return currentExplodeStep;
	}

	public int getTotalExplodeStep() {
		return diameter.length;
	}

	public abstract void removeExplode();

	public void explode(Graphics g) {

		// System.out.println("Tank Exploding ...");

		Color c = this.color;
		g.setColor(Color.ORANGE);
		g.fillOval(x, y, diameter[getCurrentExplodeStep()],
				diameter[getCurrentExplodeStep()]);
		g.setColor(c);
		this.currentExplodeStep++;

		if (getCurrentExplodeStep() > getTotalExplodeStep() - 1) {
			// System.out.println("Tank Exploded ...");
			this.isExploded = false;
			this.removeExplode();
		}
	}

	public void bulletAction() {
		this.isExploded = true;
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

	public int getBulletX() {
		return bulletX;
	}

	public int getBulletY() {
		return bulletY;
	}

	public boolean isDrawed() {
		return isDrawed;
	}

	public void setDrawed(boolean isDrawed) {
		this.isDrawed = isDrawed;
	}

	public Queue<Bullet> getFiredBulletQueue() {
		return firedBulletQueue;
	}

}
