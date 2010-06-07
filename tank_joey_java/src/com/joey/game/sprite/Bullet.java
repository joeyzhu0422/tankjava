package com.joey.game.sprite;

import com.joey.game.base.sprite.ActivityRpgSprite;
import com.joey.game.constant.Constant;
import com.joey.game.map.MapFactory;

public class Bullet extends ActivityRpgSprite {

	private Tank pTank;

	public Bullet(Tank pTank, int speed) {
		this(pTank, "images/ball.gif", 40, 40, speed, 1);
	}

	public Bullet(Tank pTank, String fileName, int width, int height,
			int speed, int size) {
		super(fileName, width, height, Constant.TYPE_BULLET, speed, size);
		this.pTank = pTank;
		this.moveRepeat = true;
	}

	public void init() {
		this.reviseXy();
		final Bullet self = this;
		this.locked = false;
		this.moveDer = pTank.getMoveDer();
		this.move(new MoveCallback() {
			public void execute() {
				self.freeGrid();
				self.explode();
				self.recover();
			}
		});
		self.pTank.useGrid();
	}

	public void reviseXy() {
		this.x = pTank.getX();
		this.y = pTank.getY();
		this.der = pTank.getMoveDer();
		switch (this.der) {

		case Constant.RpgSprite.UP:
			y = Math.max(0, y - 1);
			break;
		case Constant.RpgSprite.DOWN:
			y = Math.min(22, y + 1);
			break;
		case Constant.RpgSprite.LEFT:
			x = Math.max(0, x - 1);
			break;
		case Constant.RpgSprite.RIGHT:
			x = Math.min(22, x + 1);
			break;
		}
		this.setXy(x * 20, y * 20);

	}

	public boolean hit(int moveDer, MoveCallback callback) {
		int[][] baffles = this.probe(moveDer);

		int[][] map = MapFactory.getCurrentMap();

		boolean ret = false;

		for (int i = 0; i < baffles.length; i++) {
			int y = baffles[i][0];
			int x = baffles[i][1];
			int type = map[y][x];

			// 爆炸处理
			if (type == Constant.TYPE_ETANK || type == Constant.TYPE_HOME
					|| type == Constant.TYPE_SEA || type == Constant.TYPE_STEEL
					|| type == Constant.TYPE_STON || type == Constant.TYPE_TANK) {

				// 击中海洋，回收子弹但不爆炸
				if (type == Constant.TYPE_SEA) {
					this.freeGrid();
					this.recover();
					return true;
				}

				// 敌方坦克互相击中无效
				if (type == Constant.TYPE_ETANK
						&& this.pTank.getType() == Constant.TYPE_ETANK) {
					this.freeGrid();
					this.recover();
					return true;
				}

				if (type == Constant.TYPE_TANK || type == Constant.TYPE_ETANK) {
					// TODO
				}

				callback.execute();

				if (type == Constant.TYPE_HOME) {
					// TODO game over
				}

				if (type == Constant.TYPE_STON) {
					this.clearUi(y, x);
					ret = true;
				}
			}
		}

		return ret;
	}

	public void explode() {
		Explode explode = this.pTank.exp.poll();

		explode.setPTank(this.pTank);
		explode.setXy(xValue, yValue);
		SpriteContainer.exploedQueue.offer(explode);
	}

	public void clearUi(int y, int x) {
		int[][] map = MapFactory.getCurrentMap();
		map[y][x] = 0;
	}

	public void recover() {
		setXy(1000, 1000);
		if (this.pTank.clip.size() < 3) {
			this.pTank.clip.offer(this);
		}
		SpriteContainer.fireList.remove(this);
	}

	public static Explode getExplodeEff() {
		return (Explode) explode.clone();
	}

	// ################################ 爆炸效果 #################################
	private static Explode explode;

	static {
		if (null == explode) {
			explode = new Explode();
		}
	}

	public static class Explode extends ActivityRpgSprite implements Cloneable {

		private Tank pTank;
		
		public Explode() {
			super("images/explode.gif", 40, 40, 11, 2, 1);
		}

		public Object clone() {
			try {
				return super.clone();
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
				return null;
			}
		}

		@Override
		public boolean hit(int moveDer, MoveCallback callback) {
			// TODO Auto-generated method stub
			return false;
		}

		public Tank getPTank() {
			return pTank;
		}

		public void setPTank(Tank tank) {
			pTank = tank;
		}

		
	}

}
