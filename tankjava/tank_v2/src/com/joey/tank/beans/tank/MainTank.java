package com.joey.tank.beans.tank;

import java.awt.Color;

import com.joey.tank.beans.Bullet;
import com.joey.tank.constant.Constant;
import com.joey.tank.util.MapUtil;

public class MainTank extends Tank {

	private int life = 3;

	public MainTank() {
		super();
		this.color = Color.YELLOW;
		this.x = Constant.ActiviteElement.MainTank.ORIGINAL_X;
		this.y = Constant.ActiviteElement.MainTank.ORIGINAL_Y;
		this.width = 30;
		this.height = 30;
		this.direction = Constant.ActiviteElement.DIRECTION_UP;

		for (int i = 0; i < 3; i++) {
			preparedBulletQueue.add(new Bullet(this));
		}
	}

	public void action() {
		// System.out.println("Main Tank is action");
	}

	@Override
	public void removeExplode() {

		System.out.println("Main Tank remove Explode");

		// step.1 ȥ����ǰλ��̹��
		MapUtil.putNothingToMultipleLayer(this);

		// step.2 ����̹��λ��
		this.reset();

		// step.3 ��ը��������
		this.currentExplodeStep = 0;

		// step.4 ���� �� 1
		this.life--;

		// step.5 ���������������̹��
		if (this.life > 0) {
			MapUtil.putToMultipleLayer(this);
		}

	}

	public void reset() {

		this.setX(Constant.ActiviteElement.MainTank.ORIGINAL_X);
		this.setY(Constant.ActiviteElement.MainTank.ORIGINAL_Y);
		this.setDirection(Constant.ActiviteElement.DIRECTION_UP);
		
	}

	public int getLife() {
		return life;
	}

}