package com.joey.tank.beans.tank;

import java.awt.Color;

import com.joey.tank.beans.Bullet;
import com.joey.tank.constant.Constant;
import com.joey.tank.util.MapUtil;

public class SubTank extends Tank {

	public SubTank() {
		super();

		this.color = Color.GREEN;
		this.x = Constant.ActiviteElement.SubTank.ORIGINAL_X;
		this.y = Constant.ActiviteElement.SubTank.ORIGINAL_Y;
		this.width = 30;
		this.height = 30;

		for (int i = 0; i < 3; i++) {
			preparedBulletQueue.add(new Bullet(this));
		}

	}

	public void action() {
//		System.out.println("Sub Tank is action");
	}

	@Override
	public void removeExplode() {
		
		System.out.println("Sub Tank remove Explode");
		MapUtil.putNothingToMultipleLayer(this);
		TankFactory.removeSubTank();
	}

}
