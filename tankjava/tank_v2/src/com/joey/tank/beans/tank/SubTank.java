package com.joey.tank.beans.tank;

import java.awt.Color;

import com.joey.tank.beans.Bullet;
import com.joey.tank.constant.Constant;
import com.joey.tank.util.MapUtil;

public class SubTank extends Tank {

	private int life = 1;

	public SubTank() {
		super();

		this.color = Color.GREEN;
		this.x = Constant.ActiviteElement.SubTank.ORIGINAL_X;
		this.y = Constant.ActiviteElement.SubTank.ORIGINAL_Y;
		this.width = 30;
		this.height = 30;
		this.direction = Constant.ActiviteElement.DIRECTION_UP;

		for (int i = 0; i < 3; i++) {
			preparedBulletQueue.add(new Bullet(this));
		}

	}

	public void action() {
		// System.out.println("Sub Tank is action");
	}

	@Override
	public void removeExplode() {

		System.out.println("Sub Tank remove Explode");

		// step.1 去除当前位置坦克
		MapUtil.putNothingToMultipleLayer(this);

		// step.2 重置坦克位置
		this.setX(Constant.ActiviteElement.MainTank.ORIGINAL_X);
		this.setY(Constant.ActiviteElement.MainTank.ORIGINAL_Y);
		this.setDirection(Constant.ActiviteElement.DIRECTION_UP);
		
		// step.3 爆炸参数重置
		this.currentExplodeStep = 0;
		
		// step.4 生命 － 1
		this.life--;
		
		// step.5 如果还有命，放置坦克
		if (this.life > 0) {
			MapUtil.putToMultipleLayer(this);
		}

	}

	public int getLife() {
		return life;
	}

}
