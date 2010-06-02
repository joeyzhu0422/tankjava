package com.joey.game.sprite;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

import com.joey.game.base.sprite.ActivityRpgSprite;
import com.joey.game.constant.Constant;
import com.joey.game.map.MapFactory;

public class Tank extends ActivityRpgSprite {

	// 坦克默认速度
	private static final int F_SPEED = 3;

	// 初始x, 坦克复活的时候使用
	private int fx;

	// 初始y, 坦克复活的时候使用
	private int fy;

	// 初始移动方向
	private int fder;

	// 弹夹大小，最多存放3个子弹
	private int clipLength = 3;

	protected Queue<Bullet> clip = new LinkedBlockingQueue<Bullet>(clipLength);

	private boolean clipLocked = false;

	private int bobDer;

	public boolean fireLocked = true;

	private int life;

	protected int invTime = 2000;

	private boolean reliveLocked = false;

	private Queue<Bullet.Explode> exp = new LinkedBlockingQueue<Bullet.Explode>(
			clipLength);

	public Tank(String fileName, int width, int height, int x, int y, int size) {
		super(fileName, width, height, Constant.TYPE_TANK, x, y, F_SPEED, size);
		this.init();
	}

	public void init() {
		this.setPos(this.fder);
		//this.setXy(this.x, this.y);
		this.useGrid();
		this.initClip();
	}

	/**
	 * 初始化弹夹
	 * 
	 */
	public void initClip() {
		for (int i = 0; i < this.clipLength; i++) {
			this.exp.offer(Bullet.getExplodeEff());
			this.clip.offer(new Bullet(this, 9));
		}
	}

	/**
	 * 设置移动方向
	 */
	public void setPos(int der) {
		this.der = der;
		this.fder = der;
	}

	/**
	 * 开火
	 */
	public void fire() {

		if (this.fireLocked || this.reliveLocked || this.clipLocked
				|| this.clip.size() <= 0) {
			return;
		}
		this.clipLocked = true;
		Bullet fireBullet = this.clip.poll();
		SpriteContainer.fireList.add(fireBullet);
		fireBullet.init();
		final Tank self = this;
		new Thread() {
			public void run() {
				try {
					Thread.sleep(600);
					self.clipLocked = false;
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();

		this.fireLocked = true;

	}

	/**
	 * 复活
	 */
	public void relive() {

	}

	public void showInfo() {

	}

	/**
	 * 坦克无敌
	 */
	public void invincible() {

	}

	public int getFder() {
		return fder;
	}

	public void setFder(int fder) {
		this.fder = fder;
	}

	public int getBobDer() {
		return bobDer;
	}

	public void setBobDer(int bobDer) {
		this.bobDer = bobDer;
	}

	public Queue<Bullet> getClip() {
		return clip;
	}

	/**
	 * 碰撞
	 * 
	 * @return
	 */
	public boolean hit(int moveDer, MoveCallback callback) {

		int[][] baffles = this.probe(moveDer);

		for (int i = 0; i < baffles.length; i++) {
			int type = MapFactory.getCurrentMap()[baffles[i][0]][baffles[i][1]];
			if (type == Constant.TYPE_ETANK || type == Constant.TYPE_HOME
					|| type == Constant.TYPE_SEA || type == Constant.TYPE_STEEL
					|| type == Constant.TYPE_STON || type == Constant.TYPE_TANK) {
				return true;
			}
		}

		return false;
	}

}
