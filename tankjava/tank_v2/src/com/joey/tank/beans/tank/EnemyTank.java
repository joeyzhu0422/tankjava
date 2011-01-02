package com.joey.tank.beans.tank;

import java.awt.Color;

import com.joey.tank.beans.Bullet;
import com.joey.tank.constant.Constant;
import com.joey.tank.util.MapUtil;

public class EnemyTank extends Tank {

	public EnemyTank(int x, int y) {
		super();
		this.color = Color.WHITE;
		this.x = x;
		this.y = y;
		this.width = 30;
		this.height = 30;
		this.direction = Constant.ActiviteElement.DIRECTION_DOWN;

		for (int i = 0; i < 3; i++) {
			preparedBulletQueue.add(new Bullet(this));
		}
	}

	public void action() {
		System.out.println("Enemy Tank is action");
	}

	@Override
	public void removeExplode() {
		
		MapUtil.putNothingToMultipleLayer(this);
		TankFactory.getCurrentEnemyTankList().remove(this);
		
	}

}
