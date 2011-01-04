package com.joey.tank.beans.tank;

import java.awt.Color;

import com.joey.tank.beans.Bullet;
import com.joey.tank.constant.Constant;
import com.joey.tank.util.MapUtil;

public class MainTank extends Tank {

	public MainTank() {
		super();
		this.color = Color.YELLOW;
		this.x = Constant.ActiviteElement.MainTank.ORIGINAL_X;
		this.y = Constant.ActiviteElement.MainTank.ORIGINAL_Y;
		this.width = 30;
		this.height = 30;

		for (int i = 0; i < 3; i++) {
			preparedBulletQueue.add(new Bullet(this));
		}
	}

	public void action() {
//		System.out.println("Main Tank is action");
	}

	@Override
	public void removeExplode() {
		
		System.out.println("Main Tank remove Explode");
		MapUtil.putNothingToMultipleLayer(this);
		TankFactory.removeMainTank();
		
	}

}
