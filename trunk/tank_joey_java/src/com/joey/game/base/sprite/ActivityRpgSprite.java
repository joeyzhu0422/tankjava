package com.joey.game.base.sprite;

import com.joey.game.constant.Constant;
import com.joey.game.map.MapFactory;

public abstract class ActivityRpgSprite extends RpgSprite implements
		IActivityRpgSprite {

	// 是否允许移动
	public boolean locked = true;

	// 移动间隔锁
	public boolean stepLocked = false;

	// TODO 占位，子类对应的dom
	protected Object obj;

	// 移动速度
	protected int speed;

	// 是否重复移动，默认否
	protected boolean moveRepeat = false;

	// 移动方向
	protected int der = UP;

	// 控制操作方向 (未实施时)
	protected int moveDer = UP;

	public ActivityRpgSprite(String fileName, int width, int height, int type,
			int x, int y, int speed, int size) {
		super(fileName, width, height, type, x, y, size);
		this.speed = speed;

	}

	public ActivityRpgSprite(String fileName, int width, int height, int type,
			int speed, int size) {
		this(fileName, width, height, type, 0, 0, speed, size);
	}

	public void useGrid() {
		int x = this.x, y = this.y;
		int[][] map = MapFactory.getCurrentMap();
		map[y][x] = map[y][x + 1] = map[y + 1][x] = map[y + 1][x + 1] = this.type;
	}

	public void freeGrid() {
		int x = this.x, y = this.y;
		int[][] map = MapFactory.getCurrentMap();
		map[y][x] = map[y][x + 1] = map[y + 1][x] = map[y + 1][x + 1] = 0;
	}

	int xd, yd = 0;

	public void move(MoveCallback callback) {
		if (this.stepLocked || this.locked) {
			return;
		}
		
		this.der = moveDer;

		xd = yd = 0;

		if (this.toBorder(moveDer, callback)) {
			return;
		}

		this.freeGrid();

		if (this.hit(moveDer, callback)) {
			return;
		}

		this.stepLocked = true;

		switch (der) {
		case RIGHT:
			this.x += 1;
			xd = +2;
			break;
		case LEFT:
			this.x -= 1;
			xd = -2;
			break;
		case UP:
			this.y -= 1;
			yd = -2;
			break;
		case DOWN:
			this.y += 1;
			yd = 2;
			break;
		}

		this.useGrid();

		final ActivityRpgSprite self = this;
		final MoveCallback _callback = callback;
		new Thread() {

			public void run() {
				try {
					for (int i = 0; i < 10; i++) {

						self.setxValue(self.getxValue() + xd);

						self.setyValue(self.getyValue() + yd);

						Thread.sleep((10 - self.speed) * 10);
					}

					self.stepLocked = false;

					if (moveRepeat) {
						self.move(_callback);
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();

	}

	public boolean toBorder(int der, MoveCallback callback) {
		if (der == Constant.RpgSprite.UP && this.y == 0
				|| der == Constant.RpgSprite.DOWN && this.y == 22
				|| der == Constant.RpgSprite.LEFT && this.x == 0
				|| der == Constant.RpgSprite.RIGHT && this.x == 22) {
			callback.execute();
			return true;
		}

		return false;
	}

	public int[][] probe(int der) {
		int x = this.x;
		int y = this.y;

		int[][] baffles = new int[2][];

		switch (der) {
		case Constant.RpgSprite.LEFT:
			baffles[0] = new int[] { y, x - 1 };
			baffles[1] = new int[] { y + 1, x - 1 };
			break;
		case Constant.RpgSprite.RIGHT:
			baffles[0] = new int[] { y, x + 2 };
			baffles[1] = new int[] { y + 1, x + 2 };
			break;
		case Constant.RpgSprite.UP:
			baffles[0] = new int[] { y - 1, x };
			baffles[1] = new int[] { y - 1, x + 1 };
			break;
		case Constant.RpgSprite.DOWN:
			baffles[0] = new int[] { y + 2, x };
			baffles[1] = new int[] { y + 2, x + 1 };
			break;
		}

		return baffles;
	}

	public int getDer() {
		return der;
	}

	public void setDer(int der) {
		this.der = der;

	}

	public void setMoveDer(int moveDer) {
		this.moveDer = moveDer;
	}

	public int getMoveDer() {
		return this.moveDer;
	}

	public abstract boolean hit(int moveDer, MoveCallback callback);

}
